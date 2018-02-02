package com.sguess.learn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TableMapper {
	
	
	@Update("CREATE TABLE IF NOT EXISTS tmp.${tableName}\r\n" + 
			"(\r\n" + 
			"  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\r\n" + 
			"  userId INT,\r\n" + 
			"  name VARCHAR(15) DEFAULT \"AddrName\",\r\n" + 
			"  addr VARCHAR(255) DEFAULT \"AddrDetails\"\r\n" + 
			");")
	int createTmpTable(@Param("tableName") String tableName);
	
	
	@Select("show tables")
	List<String> showTables();
	
	@Select("drop table ${tableName}")
	List<String> dropTable(@Param("tableName") String tableName);
}
