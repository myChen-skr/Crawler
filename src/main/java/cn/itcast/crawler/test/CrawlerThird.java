package cn.itcast.crawler.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CrawlerThird {
    public static void main(String[] args) throws IOException {
        //1.打开浏览器，创建HttpClient对象
        CloseableHttpClient httpClient= HttpClients.createDefault();

        //2.输入网址,输入网址，发起Get请求创建HttpClient对象
        HttpGet httpGet=new HttpGet("https://music.douban.com/" );
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
        //3.按回车，发起请求，返回响应,使用httpClient对象发请求

        CloseableHttpResponse response =httpClient.execute(httpGet);
        //4.解析响应，获取数据
        //判断我们的状态码是否是200
        if(response.getStatusLine().getStatusCode() == 200){
            HttpEntity httpEntity=response.getEntity();
            String content= EntityUtils.toString(httpEntity,"utf8");
            System.out.println(content);

        }
    }
}


