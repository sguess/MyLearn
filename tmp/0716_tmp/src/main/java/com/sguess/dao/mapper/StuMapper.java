package com.sguess.dao.mapper;

import com.sguess.dao.entity.StuEntity;
import org.apache.ibatis.annotations.*;
import sun.plugin2.message.Message;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Mapper
public interface StuMapper {

    @Select("select * from student")
    public List<StuEntity> selectAllStudent();

    @Select("show tables")
    public List<String> showTables();

    @Update("create table stuTest01(id int, name varchar(20),age int)")
    public int createTable();

    //    @Update("create table ${tableName} (id int, name varchar(20),time date)")
//    CREATE TABLE `student` (id bigint(20) NOT NULL,name varchar(255) DEFAULT NULL,time datetime DEFAULT NULL, PRIMARY KEY (id))
    @Update("CREATE TABLE ${tableName} (id bigint(20) NOT NULL AUTO_INCREMENT,name varchar(255) DEFAULT NULL,time datetime DEFAULT NULL, PRIMARY KEY (id))")
    public int createTableWithParp(@Param("tableName") String tableName);

    @Insert("insert into ${tableName}(name, time) values(#{stu.name},#{stu.time})")
    public int insert(@Param("tableName") String tableName, @Param("stu") StuEntity stu);

    @Select("select * from ${tableName}")
    public List<StuEntity> selectAllWithTableName(@Param("tableName") String tableName);

    @InsertProvider(type = StuMapperProvider.class, method = "insertBatch")
    int insertBatch(@Param("tableName") String tableName, @Param("list") List<StuEntity> list);

    class StuMapperProvider {
        public String insertBatch(Map<String, Object> map) {
            String tableName = (String) map.get("tableName");
            List<StuEntity> list = (List<StuEntity>) map.get("list");
            StringBuffer sb = new StringBuffer("insert into " + tableName + " (name,time) values ");

            for (int i = 0; i < list.size(); i++) {
                sb.append("(#{list[" + i + "].name},#{list[" + i + "].time})");
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }

            //insert into stu001 (name,time) values (list[0].name,list[0].time),(list[1].name,list[1].time),(list[2].name,list[2].time),(list[3].name,list[3].time),(list[4].name,list[4].time)

//            MessageFormat messageFormat = new MessageFormat("(#'{'list[{0}].name},#'{'list[{0}].time})");
//            for (int i = 0; i < list.size(); i++) {
//                sb.append(messageFormat.format(new Object[]{i}));
//                if (i < list.size() - 1) {
//                    sb.append(",");
//                }
//            }
            //insert into stu001 (name,time) values (#{list[0].name},#{list[0].time}),(#{list[1].name},#{list[1].time}),(#{list[2].name},#{list[2].time}),(#{list[3].name},#{list[3].time}),(#{list[4].name},#{list[4].time})
            System.out.println("sb.toString():" + sb.toString());
            return sb.toString();
        }
    }
}
