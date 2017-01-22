package com.smertbox.security.pvgpvggroup.mapper;

import com.smertbox.security.pvgpvggroup.model.SysPvgPvggroup;
import com.smertbox.security.pvgpvggroup.model.SysPvgPvggroupExample;
import com.smertbox.util.mapper.MyBatisRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysPvgPvggroupMapper {
    int countByExample(SysPvgPvggroupExample example);

    int deleteByExample(SysPvgPvggroupExample example);

    int deleteByPrimaryKey(String id);
    
    int deleteByPgId(String pgId);

    int insert(SysPvgPvggroup record);

    int insertSelective(SysPvgPvggroup record);

    List<SysPvgPvggroup> selectByExample(SysPvgPvggroupExample example);

    SysPvgPvggroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysPvgPvggroup record, @Param("example") SysPvgPvggroupExample example);

    int updateByExample(@Param("record") SysPvgPvggroup record, @Param("example") SysPvgPvggroupExample example);

    int updateByPrimaryKeySelective(SysPvgPvggroup record);

    int updateByPrimaryKey(SysPvgPvggroup record);
    
    List<SysPvgPvggroup> selectAll(String pgId);
}