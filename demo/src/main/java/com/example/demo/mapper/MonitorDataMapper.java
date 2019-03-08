package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MonitorData;

@Repository
@Mapper
public interface MonitorDataMapper {
	
	//public void saveMonitorData(MonitorData monitorData);
	
    /**
     * 根据id查找
     * @param id 主键唯一
     * @return
     */
	//    @Select("SELECT id,monitor_id as monitorid,dbms_lob.substr(datas) as datas,template_id as templateid,to_char(createtm) as createtm,to_char(proctm) as proctm FROM t_monitor_data WHERE id = #{id}")
    @Select("SELECT * FROM t_monitor_data WHERE id = #{id}")
    MonitorData findById(@Param("id")String id);
    
  //  MonitorData findByIdByXML(@Param("id")String id);
    
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    @Delete("delete from t_monitor_data where id = #{id}")
    Integer deleteById(@Param("id")String id);
    
    /**
     * 保存
     * @param monitorData
     * @return
     */
    Integer saveMonitorData(@Param("monitorData")MonitorData monitorData);
    
    /**
     * 修改
     * @param monitorData
     * @return
     */
    Integer updateMonitorData(@Param("monitorData")MonitorData monitorData);
   
}
