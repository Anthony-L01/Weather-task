package com.lxc.west2.Controller;

import com.lxc.west2.Bean.City;
import com.lxc.west2.Bean.Weather;
import com.lxc.west2.Service.CityService;
import com.lxc.west2.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class WeatherController {

 @Autowired
    WeatherService weatherService;
 @Autowired
    CityService cityService;

 //更新数据库天气
 @GetMapping("/UpdateWeather/{name}")
 public void insertWeather(@PathVariable("name") String name) throws IOException {
     String ID="";
     City city;
     //通过name获取到id
     if((city=cityService.selectCity(name))==null)ID=cityService.insertCity(name).getId();
    else ID=city.getId();
     weatherService.insertWeather(ID);
 }


 //查询天气
 @GetMapping("/askWeather/{name}")
    public Weather askWeather(@PathVariable("name") String name) throws ParseException {
     String ID="";
     City city;
     if((city=cityService.selectCity(name))==null) {
         System.out.println("不存在该城市信息，请更新该城市天气信息");
         return null;
     }
     else
     {
         ID=city.getId();
         SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
         Date date1 = new Date(System.currentTimeMillis());
         String date=formatter.format(date1);

       Weather weather=  weatherService.selectWeather(ID,date);
         System.out.println(name+" 今日天气");
         System.out.println("日期: "+weather.getFxDate());
         System.out.println("最高气温: "+weather.getTempMax());
         System.out.println("最低气温: "+weather.getTempMin());
         System.out.println("天气: "+weather.getTextDay());
         return weather;
     }
 }
}
