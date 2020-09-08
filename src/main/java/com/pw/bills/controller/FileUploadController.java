package com.pw.bills.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pw.bills.pojo.Bills;
import com.pw.bills.pojo.User;
import com.pw.bills.service.BillsService;
import com.pw.bills.service.FileService;
import com.pw.bills.utils.BillsExprot;
import com.pw.bills.utils.BillsVo;
import com.pw.bills.utils.Result;
import com.pw.bills.utils.TestExprot;



@Controller
public class FileUploadController {
	@Autowired
	private FileService fileService;
	@Autowired
	private BillsService billsService;
	
	@RequestMapping("uploadPage")
	public String gotoUploadPage(HttpServletRequest request) {
		Result fileList = fileService.getFileList();
		request.setAttribute("filename", fileList.getData());
		//request.setAttribute("mainPage", "fileupload/upload.jsp");
		
		return "file";
	}
	@RequestMapping(value="upload",method=RequestMethod.POST)
    public   String upload(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {
       ModelAndView mv = new ModelAndView("message");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());

        // uploads文件夹位置
        String rootPath = request.getSession().getServletContext().getRealPath("upload");
        // 原始名称
        String originalFileName = file.getOriginalFilename();
        // 新文件名
        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
        // 创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH)+1));

        // 新文件
        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
        // 判断目标文件所在目录是否存在
        if( !newFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        System.out.println(newFile);
        // 将内存中的数据写入磁盘
        file.transferTo(newFile);
        // 完整的url
        fileService.saveFileData(newFileName);
       String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH)+1) + "/" + newFileName;
       mv.addObject("path", fileUrl);
       return  "redirect:uploadPage";
    }

		
   
    
	@RequestMapping("/down")  
    public void down(HttpServletRequest request,HttpServletResponse response
    		,@RequestParam(value = "filename")String filename) throws Exception{  
        //模拟文件，myfile.txt为需要下载的文件  
        String fileName = request.getSession().getServletContext().getRealPath("upload/2020/6")+"/"+filename;  
        //获取输入流  
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));  
        //假如以中文名下载的话  
        String filenamea = "下载文件.jpg";  
        //转码，免得文件名中文乱码  
        filenamea = URLEncoder.encode(filenamea,"UTF-8");  
        //设置文件下载头  
        response.addHeader("Content-Disposition", "attachment;filename=" + filenamea);    
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
        response.setContentType("multipart/form-data");   
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        int len = 0;  
        while((len = bis.read()) != -1){  
            out.write(len);  
            out.flush();  
        }  
        out.close();  
    }  
	@RequestMapping("excel")
	public String toExcel() {
		return "excel";
	}
	@PostMapping("excel")
	public ResponseEntity  excel(HttpServletRequest request,HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("upload");
		TestExprot.main2(path+"/user1.xls");
		/*
		 * //组装路径 String filePath=realPath+"/"+path; System.out.println(filePath);
		 */
	    //读取文件
		System.out.println(path+"/user1.xls");
	    File file=new File(path+"/user1.xls");
	    
	    byte[] bytes = null;
	    try{
	        bytes = FileUtils.readFileToByteArray(file);
	        }catch(Exception e){
	            e.printStackTrace();
	       }
	       //创建封装响应头信息的对象。
	       HttpHeaders header = new HttpHeaders();
	       //封装响应内容类型(APPLICATION_OCTET_STREAM)
	       header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	       //设置下载文件的名称
	       //如果文件名有中文，必须使用URLEncoder进行编码
	       String filename="";
	       try{
	           filename = URLEncoder.encode("user1.xls","UTF-8");
	       }catch(Exception e){
	           e.printStackTrace();
	       }
	       header.setContentDispositionFormData("attachment",filename);
	       //创建ResponseEntity对象
	       ResponseEntity entity = new ResponseEntity(bytes,header,HttpStatus.CREATED);
	       file.delete();
	       return entity;
	}
	@PostMapping("excel2")
	public ResponseEntity  excel2(BillsVo billsVo,HttpServletRequest request,HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("upload");
		//去数据库查询满足条件的数据
		User user = (User) request.getSession().getAttribute("user");
		Integer userId = user.getId();
		List<Bills> billsList = billsService.getAllBIllsExcel(billsVo,userId);
		
		BillsExprot<Bills> billsExprot = new BillsExprot<>();
		try {
			billsExprot.getId(billsList, path+ "/"+userId+".xls", userId+".xls");
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {
			e1.printStackTrace();
		}
		/*
		 * //组装路径 String filePath=realPath+"/"+path; System.out.println(filePath);
		 */
	    //读取文件
		System.out.println(path+"/"+userId+".xls");
	    File file=new File(path+"/"+userId+".xls");
	    
	    byte[] bytes = null;
	    try{
	        bytes = FileUtils.readFileToByteArray(file);
	        }catch(Exception e){
	            e.printStackTrace();
	       }
	       //创建封装响应头信息的对象。
	       HttpHeaders header = new HttpHeaders();
	       //封装响应内容类型(APPLICATION_OCTET_STREAM)
	       header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	       //设置下载文件的名称
	       //如果文件名有中文，必须使用URLEncoder进行编码
	       String filename="";
	       try{
	           filename = URLEncoder.encode(userId+".xls","UTF-8");
	       }catch(Exception e){
	           e.printStackTrace();
	       }
	       header.setContentDispositionFormData("attachment",filename);
	       //创建ResponseEntity对象
	       ResponseEntity entity = new ResponseEntity(bytes,header,HttpStatus.CREATED);
	       file.delete();
	       return entity;
	}
}
