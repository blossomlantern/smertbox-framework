package com.smertbox.security.pvggroup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.pvggroup.model.SysPvggroup;
import com.smertbox.security.pvggroup.model.SysPvggroupExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysPvggroupMapper {
    int countByExample(SysPvggroupExample example);

    int deleteByExample(SysPvggroupExample example);

    int deleteByPrimaryKey(String pgId);

    int insert(SysPvggroup record);

    int insertSelective(SysPvggroup record);

    List<SysPvggroup> selectByExample(SysPvggroupExample example);

    SysPvggroup selectByPrimaryKey(String pgId);

    int updateByExampleSelective(@Param("record") SysPvggroup record, @Param("example") SysPvggroupExample example);

    int updateByExample(@Param("record") SysPvggroup record, @Param("example") SysPvggroupExample example);

    int updateByPrimaryKeySelective(SysPvggroup record);

    int updateByPrimaryKey(SysPvggroup record);
    
    List<SysPvggroup> selectPage(SysPvggroup sysPrivilegeGroup);
    
    int selectPageSize(SysPvggroup sysPrivilegeGroup);
}