package com.pw.bills.mapper;

import com.pw.bills.pojo.Bills;
import com.pw.bills.pojo.BillsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillsMapper {
    long countByExample(BillsExample example);

    int deleteByExample(BillsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bills record);

    int insertSelective(Bills record);

    List<Bills> selectByExample(BillsExample example);

    Bills selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bills record, @Param("example") BillsExample example);

    int updateByExample(@Param("record") Bills record, @Param("example") BillsExample example);

    int updateByPrimaryKeySelective(Bills record);

    int updateByPrimaryKey(Bills record);
}