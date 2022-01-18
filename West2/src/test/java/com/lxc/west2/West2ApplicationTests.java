package com.lxc.west2;

import com.lxc.west2.Bean.City;

import com.lxc.west2.Mapper.WeatherMapper;
import com.lxc.west2.Service.CityService;
import com.lxc.west2.Service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class West2ApplicationTests {

    @Test
    void contextLoads() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
    }




}
