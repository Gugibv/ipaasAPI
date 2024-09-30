package com.grey.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class IpaasAccessToken {

    public static String getToken( CloseableHttpClient httpClient){
         String ipaasAccessToken;
        {
            Map<String, String> bodyMap = new HashMap<>();
            bodyMap.put("appCode", "5876fddf-ee7c-4289-985a-a1bd1a0c5627");
            bodyMap.put("tenantId", "HW47");

            HttpPost request = new HttpPost("https://apaas-openapi-web.clickpaas.com/api/open/v3/auth/token");
            request.setEntity(new StringEntity(JSON.toJSONString(bodyMap), "UTF-8"));
            request.setHeader("Content-Type", "application/json");

            try {
                CloseableHttpResponse resp = httpClient.execute(request);
                HttpEntity entity = resp.getEntity();
                String result = EntityUtils.toString(entity);
                EntityUtils.consume(resp.getEntity());
                resp.close();
                JSONObject jsonObj = JSON.parseObject(result);
                Integer code = jsonObj.getInteger("code");
                if (code != 0) {
                    throw new RuntimeException("Exchange token exception! " + jsonObj.getString("message"));
                }
                ipaasAccessToken = jsonObj.getString("data");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

         return ipaasAccessToken;

    }
}
