package com.smertbox.system.param.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.system.param.model.CmParameter;
import com.smertbox.system.param.model.CmParameterExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface CmParameterMapper {
    int countByExample(CmParameterExample example);

    int deleteByExample(CmParameterExample example);

    int deleteByPrimaryKey(String parId);

    int insert(CmParameter record);

    int insertSelective(CmParameter record);

    List<CmParameter> selectByExample(CmParameterExample example);

    CmParameter selectByPrimaryKey(String parId);

    int updateByExampleSelective(@Param("record") CmParameter record, @Param("example") CmParameterExample example);

    int updateByExample(@Param("record") CmParameter record, @Param("example") CmParameterExample example);

    int updateByPrimaryKeySelective(CmParameter record);

    int updateByPrimaryKey(CmParameter record);

	List<CmParameter> selectAll();

	List<CmParameter> selectParamTree();

	List<CmParameter> selectPage(CmParameter cmParameter);

	int selectPageSize(CmParameter cmParameter);

	void deleteCascade(String parId);
}