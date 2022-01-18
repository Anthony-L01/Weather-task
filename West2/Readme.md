# Weather   

 

####                                                            一个基于springboot与mybaits的纯后端练习项目


## 介绍
此项目是基于<和风天气api>开发的一个简单练手项目


## 简单功能介绍
<p> 启动该项目后，可以通过两个接口分别进行某城市的天气查询与某城市天气信息的更新.</p>


## 如何操作
<p>首先执行我的sql文件，进行建表操作.</p>
<p>然后打开项目，找到resources文件中的application.properties配置文件.</p>
<p>修改该文件中的spring.datasource.url  配置项，将bjpowernode改成你执行sql文件的数据库名即可</p>
<p>然后应该就可以正常运行了</p>

## 功能说明
 运行项目

<br>

 1.查询某城市的天气（此处以福州为例）

 <p>访问接口http://localhost:8080/askWeather/福州   （福州可以改成你想要查询的任何城市）
</p>
<br>

 <p>（1）如果这个城市的天气已经存在于数据库中，则能在控制台看到以下返回</p>

 ![天气查询返回](https://github.com/Anthony-L01/Picture1/raw/cedfe9cdc79c04682f11577e0674d7897c636372/Weather/OldWeather.png)

<br>

 <p>（2）如果这个城市不存在天气于数据库中，则能在控制台看到以下返回</p>
<<<<<<< HEAD
 
=======
>>>>>>> 345f571 (.)
 ![城市不存在](https://github.com/Anthony-L01/Picture1/raw/cedfe9cdc79c04682f11577e0674d7897c636372/Weather/NoData.png)

<br>

 2.更新某城市今明后三天的天气（此处以福州为例）
 <p>访问接口http://localhost:8080/UpdateWeather/福州   （ 福州可以改成你想要查询的任何城市）</p>
<br>

 <p>（1）如果更新成功，则能在控制台看到以下返回</p>

 ![更新天气成功](https://github.com/Anthony-L01/Picture1/raw/cedfe9cdc79c04682f11577e0674d7897c636372/Weather/UpdateSuccess.png)

<br>

 <p>（2）如果更新失败，则能在控制台看到返回："天气接口获取失败！"</p>

<br>

 <p>注：此接口可以把数据库的数据更新为最新的数据，且不会存留过期的旧数据</p>
 <p>测试如下：</p>
<br>

 <p>在1.17日测试的数据</p>

![OldData](https://github.com/Anthony-L01/Picture1/raw/cedfe9cdc79c04682f11577e0674d7897c636372/Weather/OldData.png)
 <p>在1.18日测试的数据</p>
<<<<<<< HEAD
 
![NewData1](https://github.com/Anthony-L01/Picture1/raw/cedfe9cdc79c04682f11577e0674d7897c636372/Weather/NewData1.png)

![NewData2](https://github.com/Anthony-L01/Picture1/raw/cedfe9cdc79c04682f11577e0674d7897c636372/Weather/NewData2.png)

 <p>在获取旧数据后进行天气更新，再获取新数据</p>
 
=======
![NewData1](https://github.com/Anthony-L01/Picture1/raw/cedfe9cdc79c04682f11577e0674d7897c636372/Weather/NewData1.png)
![NewData2](https://github.com/Anthony-L01/Picture1/raw/cedfe9cdc79c04682f11577e0674d7897c636372/Weather/NewData2.png)

 <p>在获取旧数据后进行天气更新，再获取新数据</p>
>>>>>>> 345f571 (.)
![更新前后](https://github.com/Anthony-L01/Picture1/raw/cedfe9cdc79c04682f11577e0674d7897c636372/Weather/UpdateWeather.png)

