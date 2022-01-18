package com.lxc.west2.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxc.west2.Bean.Weather;
import com.lxc.west2.Mapper.WeatherMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class WeatherService {
    @Autowired
    WeatherMapper weatherMapper;

    @Autowired
    CloseableHttpClient httpclient;



    //根据城市ID更新天气信息
    public void  insertWeather(String ID) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://devapi.qweather.com/v7/weather/3d?key=e3591e3860de446d81050282714a393e&location=").append(ID);
        String url=stringBuilder.toString();
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(url);
        //response 对象
        CloseableHttpResponse response = null;
        String resultString="0";
        try {
            // 执行http get请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200)
            {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
               JSONObject s = (JSONObject) JSONObject.parseObject(resultString);
                JSONArray jsonArray = s.getJSONArray("daily");
                //今天的天气信息
              String date1 =  jsonArray.getJSONObject(0).getString("fxDate");
              Integer tempMax1=jsonArray.getJSONObject(0).getInteger("tempMax");
                Integer tempMin1=jsonArray.getJSONObject(0).getInteger("tempMin");
                String CityID1=ID;
                String textDay1=jsonArray.getJSONObject(0).getString("textDay");
                Weather weather1 = new Weather(date1,CityID1,tempMax1,tempMin1,textDay1);
                //明天的天气信息
                String date2 =  jsonArray.getJSONObject(1).getString("fxDate");
                Integer tempMax2=jsonArray.getJSONObject(1).getInteger("tempMax");
                Integer tempMin2=jsonArray.getJSONObject(1).getInteger("tempMin");
                String CityID2=ID;
                String textDay2=jsonArray.getJSONObject(1).getString("textDay");
                Weather weather2 = new Weather(date2,CityID2,tempMax2,tempMin2,textDay2);
                //后天的天气
                String date3 =   jsonArray.getJSONObject(2).getString("fxDate");
                Integer tempMax3=jsonArray.getJSONObject(2).getInteger("tempMax");
                Integer tempMin3=jsonArray.getJSONObject(2).getInteger("tempMin");
                String CityID3=ID;
                String textDay3=jsonArray.getJSONObject(2).getString("textDay");
                Weather weather3 = new Weather(date3,CityID3,tempMax3,tempMin3,textDay3);

                if(weatherMapper.selectWeather(weather1)==null)weatherMapper.insertWeather(weather1);
                else {
                   weatherMapper.updateWeather(weather1);
                }
                if(weatherMapper.selectWeather(weather2)==null)weatherMapper.insertWeather(weather2);
                else {
                    weatherMapper.updateWeather(weather2);
                }
                if(weatherMapper.selectWeather(weather3)==null)weatherMapper.insertWeather(weather3);
                else {
                     weatherMapper.updateWeather(weather3);
                }
                System.out.println("该城市这三天的天气已经更新成功");

            }
            else
            {
                throw new Exception("天气接口获取失败！");
            }
}
        catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }

        }

    }

    //根据城市ID与日期查询天气信息
    public Weather selectWeather(String CityID,String fxDate)
    {
        return weatherMapper.checkWeather(CityID,fxDate);

    }
}

