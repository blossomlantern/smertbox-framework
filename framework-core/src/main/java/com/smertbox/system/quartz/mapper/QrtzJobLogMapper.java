package com.smertbox.system.quartz.mapper;

import com.smertbox.system.quartz.model.QrtzJobLog;
import com.smertbox.system.quartz.model.QrtzJobLogExample;
import com.smertbox.util.mapper.MyBatisRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface QrtzJobLogMapper {
    int countByExample(QrtzJobLogExample example);

    int deleteByExample(QrtzJobLogExample example);

    int insert(QrtzJobLog record);

    int insertSelective(QrtzJobLog record);

    List<QrtzJobLog> selectByExample(QrtzJobLogExample example);

    int updateByExampleSelective(@Param("record") QrtzJobLog record, @Param("example") QrtzJobLogExample example);

    int updateByExample(@Param("record") QrtzJobLog record, @Param("example") QrtzJobLogExample example);

	List<QrtzJobLog> selectLastFiveRow(String jobId);
}