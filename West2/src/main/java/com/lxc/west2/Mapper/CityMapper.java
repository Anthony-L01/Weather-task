package com.lxc.west2.Mapper;

import com.lxc.west2.Bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    //    通过城市的id，搜索城市是否在数据库中
    //    如果返回null说明不存在
    @Select("select * from city where name=#{name}")
    public City selectCity(String name);

    //根据传入的City对象，插入城市的信息
    //返回1插入成功，返回0插入失败
    @Insert("insert into city (name,id,latitude,longitude)values( #{name},#{id},#{latitude},#{longitude} )")
    public int InsertCity(City city);



}
