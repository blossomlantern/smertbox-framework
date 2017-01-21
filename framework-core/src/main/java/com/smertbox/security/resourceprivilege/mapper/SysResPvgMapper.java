package com.smertbox.security.resourceprivilege.mapper;

import com.smertbox.security.resourceprivilege.model.SysResPvg;
import com.smertbox.security.resourceprivilege.model.SysResPvgExample;
import com.smertbox.util.mapper.MyBatisRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysResPvgMapper {
    int countByExample(SysResPvgExample example);

    int deleteByExample(SysResPvgExample example);

    int deleteByPrimaryKey(String resPvgId);

    int insert(SysResPvg record);

    int insertSelective(SysResPvg record);

    List<SysResPvg> selectByExample(SysResPvgExample example);

    SysResPvg selectByPrimaryKey(String resPvgId);

    int updateByExampleSelective(@Param("record") SysResPvg record, @Param("example") SysResPvgExample example);

    int updateByExample(@Param("record") SysResPvg record, @Param("example") SysResPvgExample example);

    int updateByPrimaryKeySelective(SysResPvg record);

    int updateByPrimaryKey(SysResPvg record);
    
    List<SysResPvg> selectPage(SysResPvg sysResPvg);
}