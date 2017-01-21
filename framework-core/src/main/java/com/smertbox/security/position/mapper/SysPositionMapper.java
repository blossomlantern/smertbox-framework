package com.smertbox.security.position.mapper;

import com.smertbox.security.position.model.SysPosition;
import com.smertbox.security.position.model.SysPositionExample;
import com.smertbox.util.mapper.MyBatisRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysPositionMapper {
    int countByExample(SysPositionExample example);

    int deleteByExample(SysPositionExample example);

    int deleteByPrimaryKey(String positionId);

    int insert(SysPosition record);

    int insertSelective(SysPosition record);

    List<SysPosition> selectByExample(SysPositionExample example);

    SysPosition selectByPrimaryKey(String positionId);

    int updateByExampleSelective(@Param("record") SysPosition record, @Param("example") SysPositionExample example);

    int updateByExample(@Param("record") SysPosition record, @Param("example") SysPositionExample example);

    int updateByPrimaryKeySelective(SysPosition record);

    int updateByPrimaryKey(SysPosition record);
    
    int selectPageSize(SysPosition sysPosition);
    
    List<SysPosition> selectPage(SysPosition sysPosition);

	List<SysPosition> selectAll();
	
	List<SysPosition> selectAllHaveParam();
	
	List<String> selectAllPositionType();

	List<SysPosition> selectPageByUserId(String userId);

	List<SysPosition> selectByLoginAccount(String loginAccount);
}