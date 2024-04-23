package com.uy.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HttpUtils {
    private static final HttpClient httpClient = HttpClientBuilder.create().build();

    public static String sendGetRequest(String url) throws IOException {
        // 对参数进行编码
//        url = URLEncoder.encode(url, String.valueOf(StandardCharsets.UTF_8));

        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }

    public static String sendPostRequest(String url, String requestBody) throws IOException {
        HttpPost request = new HttpPost(url);
        StringEntity params = new StringEntity(requestBody);
        request.addHeader("content-type", "application/json");

        // 设置请求体参数及编码方式
        StringEntity stringEntity = new StringEntity(requestBody, StandardCharsets.UTF_8);
        request.setEntity(stringEntity);

        HttpResponse response = httpClient.execute(request);


        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }
}