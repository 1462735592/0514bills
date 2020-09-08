package com.pw.bills.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.bills.mapper.BillsMapper;
import com.pw.bills.mapper.BillsTypeMapper;
import com.pw.bills.pojo.Bills;
import com.pw.bills.pojo.BillsExample;
import com.pw.bills.pojo.BillsExample.Criteria;
import com.pw.bills.pojo.BillsType;
import com.pw.bills.service.BillsService;
import com.pw.bills.service.BillsTypeService;
import com.pw.bills.service.PieService;
import com.pw.bills.utils.PieTools;

@Service
public class PieServiceImpl implements PieService {
	@Autowired
	private BillsService billsService;
	@Autowired
	private BillsTypeService billsTypeService;
	@Autowired
	private BillsMapper billsMapper;
	/**
	 * 从饼状图工具类里面获取创建的Columnar柱状图
	 */
	public JFreeChart createPieTools(Integer userId) {
	    // TODO Auto-generated method stub
	    // 获取饼状图的数据集
	    DefaultPieDataset dataset = getDataSet(userId);
	    // 获取饼状图工具类创建的饼状图
	    JFreeChart chart = PieTools.createPie(dataset);
	    return chart;
	}

	/**
	 * 添加饼状图的数据
	 * 
	 * @return
	 */
	public DefaultPieDataset getDataSet(Integer userId) {
	    // 数据可以从数据库中得到
	    DefaultPieDataset dataset = new DefaultPieDataset();
	    // 添加数据
	    Map<String, Double> map = new HashMap<String, Double>();
	    List<BillsType> all = billsTypeService.getAll();
	    
	    for (BillsType billsType : all) {
	    	//将改用户的各类账单金额进行统计
			BillsExample example = new BillsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(userId);
			criteria.andTypeIdEqualTo(billsType.getId());
			List<Bills> billsList = billsMapper.selectByExample(example );
			Double sum = 0.0;
			for (Bills bills : billsList) {
				sum  = sum + ((double)bills.getPrice())/100;
			}
			map.put(billsType.getName(), sum);
			dataset.setValue(billsType.getName(), sum);
		}
	
	    return dataset;
	
		}
}
