package com.pw.bills.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.bills.mapper.BillsFileMapper;
import com.pw.bills.pojo.BillsFile;
import com.pw.bills.pojo.BillsFileExample;
import com.pw.bills.pojo.BillsFileExample.Criteria;
import com.pw.bills.service.FileService;
import com.pw.bills.utils.Result;

@Service
public class FileServiceImpl implements FileService{
	@Autowired
	private BillsFileMapper billsFileMapper;
	
	@Override
	public Result getFileList() {
		// TODO Auto-generated method stub
		BillsFileExample example = new BillsFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		List<BillsFile> billsFileList = billsFileMapper.selectByExample(example);
		return Result.ok(billsFileList);
	}

	@Override
	public void saveFileData(String newFileName) {
		// TODO Auto-generated method stub
		BillsFile file = new BillsFile();
		file.setName(newFileName);
		billsFileMapper.insertSelective(file);
	}

}
