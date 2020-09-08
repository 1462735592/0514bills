package com.pw.bills.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pw.bills.mapper.BillsMapper;
import com.pw.bills.mapper.BillsTypeMapper;
import com.pw.bills.pojo.Bills;
import com.pw.bills.pojo.BillsExample;
import com.pw.bills.pojo.BillsExample.Criteria;
import com.pw.bills.pojo.BillsType;
import com.pw.bills.service.BillsService;
import com.pw.bills.service.BillsTypeService;
import com.pw.bills.utils.BillsVo;
import com.pw.bills.utils.LayuiData;
import com.pw.bills.utils.Result;

@Service
public class BillServiceImpl implements BillsService{
	@Autowired
	private BillsMapper billsMapper;
	@Autowired
	private BillsTypeService billsTypeService;
	//根据用户id查找其所有的账单
	@Override
	public LayuiData getAllBills(Integer userId,BillsVo billsVo) {
		BillsExample example = new BillsExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(billsVo.getStart()==null) {
			try {
				billsVo.setStart(sdf.parse("1970-1-1 08:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(billsVo.getEnd()==null) {
			//设置查询时间范围的条件
			billsVo.setEnd(new Date());
			
		}
		criteria.andCreateTimeBetween(billsVo.getStart(), billsVo.getEnd());
		
		//按时间倒序排列
		example.setOrderByClause("create_time DESC");
		if(billsVo.getTitle()!=null&&billsVo.getTitle()!="") {
			criteria.andTitleLike("%"+billsVo.getTitle()+"%");
		}
		PageHelper.startPage(billsVo.getPage(),billsVo.getLimit());
		List<Bills> billsList = billsMapper.selectByExample(example );
		//查询账单类型数据，将typeName补全
		List<BillsType> billsTypeList = billsTypeService.getAll();
		for (Bills bills : billsList) {
			for(BillsType billsType : billsTypeList) {
				if(bills.getTypeId().equals(billsType.getId())) {
					bills.setTypeName(billsType.getName());
				}
			}
		}
		PageInfo pageInfo = new PageInfo(billsList);
		long total = pageInfo.getTotal();
		//返回layui所需要的json对象
		LayuiData  layuiData = new LayuiData(total,billsList);
		
	
		return layuiData;
	}
	@Override
	public Result addBill(Bills bills) {
		int row = billsMapper.insert(bills);
		if(row>0) {
			return Result.ok();
		}
		return Result.build(403, "添加账单失败");
	}
	@Override
	public Result deleteBill(Integer id) {
		int row = billsMapper.deleteByPrimaryKey(id);
		if(row>0) {
			return Result.ok();
		}
		return Result.build(406, "删除失败！");
	}
	@Override
	public int selectById(Bills bills) {
		BillsExample example = new BillsExample();
		Criteria criteria = example.createCriteria();
		//根据用户id和账单id查询账单
		criteria.andUserIdEqualTo(bills.getUserId());
		criteria.andIdEqualTo(bills.getId());
		List<Bills> selectByExample = billsMapper.selectByExample(example );
		if(selectByExample!=null&&selectByExample.size()>0) {
			return selectByExample.size();
		}
		return 0;
	}
	@Override
	public Result updateBill(Bills bills) {
		BillsExample example = new BillsExample();
		Criteria criteria = example.createCriteria();
		//根据用户id和账单id更新账单
		criteria.andUserIdEqualTo(bills.getUserId());
		criteria.andIdEqualTo(bills.getId());
		int row = billsMapper.updateByExampleSelective(bills, example);
		if(row>0) {
			return Result.ok();
		}else {
			return Result.build(407, "更新失败！");
		}
		
	}
	@Override
	public List<Bills> getAllBIllsExcel(BillsVo billsVo, Integer userId) {
		BillsExample example = new BillsExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(billsVo.getStart()==null) {
			try {
				billsVo.setStart(sdf.parse("1970-1-1 08:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(billsVo.getEnd()==null) {
			//设置查询时间范围的条件
			billsVo.setEnd(new Date());
			
		}
		criteria.andCreateTimeBetween(billsVo.getStart(), billsVo.getEnd());
		
		//按时间倒序排列
		example.setOrderByClause("create_time DESC");
		if(billsVo.getTitle()!=null&&billsVo.getTitle()!="") {
			criteria.andTitleLike("%"+billsVo.getTitle()+"%");
		}
		List<Bills> billsList = billsMapper.selectByExample(example );
		//查询账单类型数据，将typeName补全
		List<BillsType> billsTypeList = billsTypeService.getAll();
		for (Bills bills : billsList) {
			for(BillsType billsType : billsTypeList) {
				if(bills.getTypeId().equals(billsType.getId())) {
					bills.setTypeName(billsType.getName());
				}
			}
		}
		return billsList;
	}

}
