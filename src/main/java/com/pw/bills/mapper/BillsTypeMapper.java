package com.pw.bills.mapper;

import com.pw.bills.pojo.BillsType;
import com.pw.bills.pojo.BillsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillsTypeMapper {
    long countByExample(BillsTypeExample example);

    int deleteByExample(BillsTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BillsType record);

    int insertSelective(BillsType record);

    List<BillsType> selectByExample(BillsTypeExample example);

    BillsType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BillsType record, @Param("example") BillsTypeExample example);

    int updateByExample(@Param("record") BillsType record, @Param("example") BillsTypeExample example);

    int updateByPrimaryKeySelective(BillsType record);

    int updateByPrimaryKey(BillsType record);
}