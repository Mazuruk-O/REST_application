package com.gemicle.REST_Application.controller;

import com.gemicle.REST_application.model.House;
import com.gemicle.REST_application.model.HouseImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.hamcrest.core.IsEqual.equalTo;

public class HouseControllerTest {
    CloseableHttpClient client = HttpClients.createDefault();
    private final static Gson gsonBuilder = new GsonBuilder().create();

    @Test
    public void testGet() throws ClientProtocolException, IOException {
        HttpGet request = new HttpGet("http://localhost:8080/houses");

        HttpResponse response = HttpClientBuilder.create().build().execute( request );

        Assert.assertThat(
                response.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void testPOST() throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost("http://localhost:8080/houses");

        House house = new HouseImpl("addre345345ss",10,15,49,2000);

        String json = gsonBuilder.toJson(house);

        StringEntity entity = new StringEntity(json);

        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void testPUT() throws ClientProtocolException, IOException {
        HttpPut httpPut = new HttpPut("http://localhost:8080/houses/Soborna");

        House house = new HouseImpl("Soborna",1045,156,495,2000);

        String json = gsonBuilder.toJson(house);

        StringEntity entity = new StringEntity(json);

        httpPut.setEntity(entity);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPut);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void testDELETE() throws ClientProtocolException, IOException {
        HttpDelete httpDelete = new HttpDelete("http://localhost:8080/houses/Kyivska");

        httpDelete.setHeader("Accept", "application/json");
        httpDelete.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpDelete);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void testDELETE_404() throws ClientProtocolException, IOException {
        HttpDelete httpDelete = new HttpDelete("http://localhost:8080/houses/Kyivska900");

        httpDelete.setHeader("Accept", "application/json");
        httpDelete.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpDelete);
        Assert.assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
    }
}
