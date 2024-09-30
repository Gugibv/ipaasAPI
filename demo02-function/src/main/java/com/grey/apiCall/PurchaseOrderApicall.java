package com.grey.apiCall;


import com.alibaba.fastjson.JSON;
import com.clickpaas.ipaas.mapper.BaseMapper;
import com.clickpaas.ipaas.model.DataResponse;
import com.grey.utils.IpaasAccessToken;
import com.ncs.management.api.entity.IPaasobject_u5n7rlm7;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;


public class PurchaseOrderApicall {
    public static void main(String[] args) {
   //     findById();
             test();
/*
        findFilterBox();
        saveOrUpdate();
        saveOrUpdateBatch();
        saveOrUpdateBatchAsync();
        direct();
        updateByCondition();
        delete();
        deleteBatch();
        findPageInfo();
*/

    }

    public static String findById() {
        String ID = "HW6954990"; //进货单ID
        BaseMapper<IPaasobject_u5n7rlm7> baseMapper = new BaseMapper<IPaasobject_u5n7rlm7>() {};
        DataResponse<List<IPaasobject_u5n7rlm7>> byIds = baseMapper.findByIds(Arrays.asList(ID));

         byIds.getData().get(0).getT_field_ffsc77i5();
        System.out.println(byIds.getData().get(0).getT_field_ffsc77i5());
        return  null;

    }

    public static  void test() {
        String ID = "HW6954990"; //进货单ID

        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 兑换token
        String ipaasAccessToken = IpaasAccessToken.getToken(httpClient);

        // 自定义查询条件
        String findPage = "https://apaas-openapi-web.clickpaas.com/api/open/v3/t_object_x7x3163y/findPageInfo";

        // 构建查询条件
        Map<String, Object> queryR01 = new HashMap<>();
        queryR01.put("t_field_smdqjgddnc", ID);

        Map<String, Object> bodyMapR01 = new HashMap<>();
        bodyMapR01.put("query", queryR01);

        Map<String, Object> $specialCommandR01 = new HashMap<>();
        $specialCommandR01.put("$respFields", JSON.toJSONString(Arrays.asList("t_field_jiflrh7rhc")));//  商品 ID


        Map<String, Object> $extendFieldsR01 = new HashMap<>();
        $specialCommandR01.put("$extendFields", JSON.toJSONString($extendFieldsR01));

        $specialCommandR01.put("$pageNum", 1);
        $specialCommandR01.put("$pageSize", 15);
        bodyMapR01.put("$specialCommand", $specialCommandR01);

        HttpPost requestR01 = new HttpPost(findPage);
        requestR01.setEntity(new StringEntity(JSON.toJSONString(bodyMapR01), "UTF-8"));
        requestR01.setHeader("Content-Type", "application/json");
        requestR01.setHeader("Ipaas-Access-Token", ipaasAccessToken);
        requestR01.setHeader("sandBoxId", "");

        try {
            CloseableHttpResponse respR01 = httpClient.execute(requestR01);
            HttpEntity entityR01 = respR01.getEntity();
            if (entityR01 != null) {

                String resultR01 = EntityUtils.toString(entityR01);
                EntityUtils.consume(respR01.getEntity());

                System.out.println(resultR01);

                JSONObject jsonObject = new JSONObject(resultR01);
                JSONObject dataObject = jsonObject.getJSONObject("data");
                JSONArray dataList = dataObject.getJSONArray("dataList");

                for(int i= 0;i<dataList.length();i++){
                    JSONObject  item = (JSONObject) dataList.get(i);

                    // 获取 t_field_jiflrh7rhc 的值
                    if (item.has("t_field_jiflrh7rhc")) {
                        String value = item.getString("t_field_jiflrh7rhc");
                        System.out.println("商品ID: " + value);
                    } else {
                        System.out.println("t_field_jiflrh7rhc 字段不存在");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
