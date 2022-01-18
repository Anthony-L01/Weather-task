package com.lxc.west2.Mapper;

import com.lxc.west2.Bean.Weather;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

@Mapper
public interface WeatherMapper {

    //根据方法传入的weather对象，插入天气信息
    @Insert("insert into weather(fxDate,CityID,tempMax,tempMin,textDay) values (#{fxDate},#{CityID},#{tempMax},#{tempMin},#{textDay})")
    public int insertWeather(Weather weather);

    //根据城市的ID和日期查询天气
    @Select("select * from weather where CityID=#{arg0} and fxDate=#{arg1}")
    public Weather checkWeather(String CityID,String fxDate);

    //根据天气的城市ID和日期，查询该天气是否存在
    @Select("select * from weather where CityID=#{CityID} and fxDate=#{fxDate}")
    public Weather selectWeather(Weather weather);


    //根据传入的weather对象，更新天气信息
    @Update("update weather set tempMax=#{tempMax},tempMin=#{tempMin},textDay=#{textDay} where CityID=#{CityID} and fxDate=#{fxDate}   ")
    public int updateWeather(Weather weather);
}
