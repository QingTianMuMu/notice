package com.ppyuan.club.notice.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class SendMsgService {

    private static final String ACCOUNT = "13751845348";
    private static final String PWD = "b33fb7b1d0c28d35eb51c7fd9";
    private static final String SIGNID = "266888";
    private static final String URL_API = "http://api.feige.ee/SmsService/Send";

    public static void main(String[] args) {
       new SendMsgService().send("13751845348","我是接口测试");
    }

    public void send(String phone, String msg){
        String result = realSend(phone,msg);
        System.out.println(result);
    }

     private String realSend(String phone,String msg){
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                List<BasicNameValuePair> formparams = new ArrayList<>();
                formparams.add(new BasicNameValuePair("Account",ACCOUNT));
                formparams.add(new BasicNameValuePair("Pwd",PWD));//登录后台 首页显示
                formparams.add(new BasicNameValuePair("Content",msg));
                formparams.add(new BasicNameValuePair("Mobile",phone));
                formparams.add(new BasicNameValuePair("SignId",SIGNID));//登录后台 添加签名获取id

                HttpPost httpPost = new HttpPost(URL_API);
                httpPost.setEntity(new UrlEncodedFormEntity(formparams,"UTF-8"));
                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                System.out.println(result);
                return result;
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
