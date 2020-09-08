package com.pw.bills.mapper;

import com.pw.bills.pojo.BillsFile;
import com.pw.bills.pojo.BillsFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillsFileMapper {
    long countByExample(BillsFileExample example);

    int deleteByExample(BillsFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BillsFile record);

    int insertSelective(BillsFile record);

    List<BillsFile> selectByExample(BillsFileExample example);

    BillsFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BillsFile record, @Param("example") BillsFileExample example);

    int updateByExample(@Param("record") BillsFile record, @Param("example") BillsFileExample example);

    int updateByPrimaryKeySelective(BillsFile record);

    int updateByPrimaryKey(BillsFile record);
}