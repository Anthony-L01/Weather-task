package com.lxc.west2.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxc.west2.Bean.City;
import com.lxc.west2.Mapper.CityMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class CityService {
    @Autowired
    CityMapper cityMapper ;

    @Autowired
    CloseableHttpClient httpclient;

    //查找ID对应的城市
    //返回null说明找不到城市
    public City selectCity(String name)
    {
      City city=  cityMapper.selectCity(name);
      return city;
    }

    //通过城市名（name）插入城市信息
    public City insertCity(String name) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://geoapi.qweather.com/v2/city/lookup?key=e3591e3860de446d81050282714a393e&location=").append(name);
        // 组合出url
        String url = stringBuilder.toString();
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(url);
        //response 对象
        CloseableHttpResponse response = null;
        String resultString="0";
        try {
            // 执行http get请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                //获取收到的数据，并且转为string
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
                //将String转为json对象
                JSONObject s = (JSONObject) JSONObject.parseObject(resultString);
                //从json对象中提取json数组
                JSONArray jsonArray = s.getJSONArray("location");
                //从json数组中获取自己需要的数据
                String city=jsonArray.getJSONObject(0).getString("name");
                Double latitude=jsonArray.getJSONObject(0).getDouble("lat");
                Double longitude=jsonArray.getJSONObject(0).getDouble("lon");
                String ID=jsonArray.getJSONObject(0).getString("id");
                City city1=new City(city,ID,latitude,longitude);
                //输出城市信息
                System.out.println(city+" "+ID+" "+latitude+" "+longitude);
                //向数据库中插入
                cityMapper.InsertCity(city1);
                System.out.println("城市信息插入成功");
              return city1;
            } else {
                System.out.println("获取城市信息失败");
                throw new Exception("城市接口获取失败！");
            }
        } catch (ClientProtocolException e) {
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
        return null;
    }
}
