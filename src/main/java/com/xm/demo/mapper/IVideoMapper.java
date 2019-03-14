package com.xm.demo.mapper;

import com.xm.demo.domain.Video;
import com.xm.demo.provider.VideoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * video数据访问层
 */
public interface IVideoMapper {

    @Select("select * from video")
    /*@Results({ //字段映射，这种写太麻烦，直接加配置文件
            @Result(column = "cover_img",property = "coverImg"),
            @Result(column = "create_time",property = "createTime")
    })*/
    List<Video> findAll();

    @Select("SELECT * FROM video WHERE id = #{id}")
    Video findById(int id);

   // @Update("UPDATE video SET title=#{title},SET summary=#{summary},SET cover_img=#{coverImg},SET view_num=#{viewNum},SET price=#{price},SET create_time=#{createTime},SET online=#{online},SET point=#{point}  WHERE id =#{id}")
    @UpdateProvider(type=VideoProvider.class,method = "updeteVideo")
    int update(Video Video);

    @Delete("DELETE FROM video WHERE id =#{id}")
    int delete(int id);

    @Insert("INSERT INTO `video` ( `title`, `summary`, " +
            "`cover_img`, `view_num`, `price`, `create_time`," +
            " `online`, `point`)" +
            "VALUES" +
            "(#{title}, #{summary}, #{coverImg}, #{viewNum}, #{price},#{createTime}" +
            ",#{online},#{point});")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int save(Video video);
}
