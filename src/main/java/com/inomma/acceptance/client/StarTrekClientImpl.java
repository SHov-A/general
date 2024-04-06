package com.inomma.acceptance.client;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StarTrekClientImpl implements StarTrekClient {

    @Override
    public HttpResponse getRequest(String path, Map<String, String> headers) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(path);
        headers.forEach(httpGet::addHeader);
        return httpClient.execute(httpGet);
    }

    @Override
    public HttpResponse postRequest(String path, Map<String, String> headers, Map<String, String> formParams) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(path);
        headers.forEach(httpPost::addHeader);
        List<NameValuePair> nameValuePair = new ArrayList<>();
        formParams.forEach((key,value) -> nameValuePair.add(new BasicNameValuePair(key,value)));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePair, Charset.defaultCharset());
        httpPost.setEntity(entity);
        return httpClient.execute(httpPost);
    }

}
