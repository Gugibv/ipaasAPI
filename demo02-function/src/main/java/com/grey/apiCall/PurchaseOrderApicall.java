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
import java.math.BigDecimal;
import java.util.*;


public class PurchaseOrderApicall {
    public static void main(String[] args) {

        String ID = "HW6954990"; //进货单ID

        String warehouseId =  getWarehouseIdByPurchaseOrderId(ID);
        String goodsInPurchaseOrderString = getGoodsListByPurchaseOrderId(ID);
        String goodsInWarehoseString = getGoodListByWarehouseId(warehouseId);
        HashSet<String> goodInWareHouseSet = checkGoodsIfInWarehouse(goodsInPurchaseOrderString,goodsInWarehoseString);



    }

    /**
     * 根据进货单ID获取入库仓库
     * @param ID
     * @return
     */
    public static String getWarehouseIdByPurchaseOrderId(String ID) {

        BaseMapper<IPaasobject_u5n7rlm7> baseMapper = new BaseMapper<IPaasobject_u5n7rlm7>() {};
        DataResponse<List<IPaasobject_u5n7rlm7>> byIds = baseMapper.findByIds(Arrays.asList(ID));

        return byIds.getData().get(0).getT_field_ffsc77i5().toString();

    }

    /**
     * 根据进货单ID获取商品列表
     * @param ID
     */
    public static String getGoodsListByPurchaseOrderId(String ID) {
        String resultR01 = "";

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

        Map<String, Object> $specialCommandR02 = new HashMap<>();
        $specialCommandR02.put("$respFields", JSON.toJSONString(Arrays.asList("t_field_jiflrh7rhc", "t_field_uxggln4z")));


        Map<String, Object> $extendFieldsR01 = new HashMap<>();
        $specialCommandR02.put("$extendFields", JSON.toJSONString($extendFieldsR01));

        $specialCommandR02.put("$pageNum", 1);
        $specialCommandR02.put("$pageSize", 15);
        bodyMapR01.put("$specialCommand", $specialCommandR02);

        HttpPost requestR01 = new HttpPost(findPage);
        requestR01.setEntity(new StringEntity(JSON.toJSONString(bodyMapR01), "UTF-8"));
        requestR01.setHeader("Content-Type", "application/json");
        requestR01.setHeader("Ipaas-Access-Token", ipaasAccessToken);
        requestR01.setHeader("sandBoxId", "");

        try {
            CloseableHttpResponse respR01 = httpClient.execute(requestR01);
            HttpEntity entityR01 = respR01.getEntity();
            if (entityR01 != null) {

                resultR01 = EntityUtils.toString(entityR01);
                EntityUtils.consume(respR01.getEntity());
                System.out.println(resultR01);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return  resultR01;
    }

    /**
     * 根据仓库ID获取库存商品ID
     * @param warehouseId
     * @return
     */
    public static String getGoodListByWarehouseId(String warehouseId){
        System.out.println("入库仓库ID:" + warehouseId);
        String resultR01 = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 兑换token
        String ipaasAccessToken = IpaasAccessToken.getToken(httpClient);

        // 自定义查询条件
        String findPage = "https://apaas-openapi-web.clickpaas.com/api/open/v3/t_object_y7w6twi0/findPageInfo";

        // 构建查询条件
        Map<String, Object> queryR01 = new HashMap<>();
        queryR01.put("t_treewarehouse", warehouseId);

        Map<String, Object> bodyMapR01 = new HashMap<>();
        bodyMapR01.put("query", queryR01);

        Map<String, Object> $specialCommandR01 = new HashMap<>();
        $specialCommandR01.put("$respFields", JSON.toJSONString(Arrays.asList("t_item_name", "t_number")));

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
                resultR01 = EntityUtils.toString(entityR01);
                EntityUtils.consume(respR01.getEntity());
                System.out.println(resultR01);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return  resultR01;

    }


    public static HashSet<String> checkGoodsIfInWarehouse(String goodsInPurchaseOrderString ,String goodsInWarehoseString ){

        HashSet<String> goodInWareHouseSet = new HashSet<>();

        JSONObject jsonObject = new JSONObject(goodsInPurchaseOrderString);
        JSONObject dataObject = jsonObject.getJSONObject("data");
        JSONArray dataList = dataObject.getJSONArray("dataList");

        for(int i= 0;i<dataList.length();i++){
             JSONObject  item = (JSONObject) dataList.get(i);

            // 获取 t_field_jiflrh7rhc 的值
            if (item.has("t_field_jiflrh7rhc")) {
                String productId = item.getString("t_field_jiflrh7rhc");
                BigDecimal productNum = item.getBigDecimal("t_field_uxggln4z");
                System.out.println("进货商品ID: " + productId +" 进货数量：" +productNum );
            } else {
                System.out.println("t_field_jiflrh7rhc 字段不存在");
            }
        }

        System.out.println("----------------------------------");

        JSONObject jsonObject2 = new JSONObject(goodsInWarehoseString);
        JSONObject dataObject2 = jsonObject2.getJSONObject("data");
        JSONArray dataList2 = dataObject2.getJSONArray("dataList");
        for(int i= 0;i<dataList2.length();i++){
            JSONObject  item = (JSONObject) dataList2.get(i);
            if (item.has("t_item_name")) {
                String productId = item.getString("t_item_name");
                BigDecimal productNum = item.getBigDecimal("t_number");
                System.out.println("库存商品ID: " + productId +" 库存数量：" +productNum );
            } else {
                System.out.println("t_item_name 字段不存在");
            }
        }



        return goodInWareHouseSet;
    }


}
