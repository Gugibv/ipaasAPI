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

        String warehouseId =  getWarehouseIdByPurchaseOrderId(ID); // 从进货单中得到相关仓库ID
        String goodsInPurchaseOrderString = getGoodsListByPurchaseOrderId(ID); // 根据进货单ID从商品-进货单中间表获取商品列表
        String goodsInWarehoseString = getGoodListByWarehouseId(warehouseId); // 根据相关仓库ID从商品-仓库中间表获取商品列表
        handleGoodsToWarehouse(goodsInPurchaseOrderString,goodsInWarehoseString); // 商品入库

        updateGoodsToWarehouse();
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
     * 根据进货单ID从商品-进货单中间表获取商品列表
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
     * 根据相关仓库ID从商品-仓库中间表获取商品列表
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


    public static void handleGoodsToWarehouse(String goodsInPurchaseOrderString ,String goodsInWarehoseString ){

        JSONObject jsonObject = new JSONObject(goodsInPurchaseOrderString);
        JSONObject dataObject = jsonObject.getJSONObject("data");
        JSONArray dataList = dataObject.getJSONArray("dataList");

        HashMap<String,BigDecimal> goodsInpurchaseMap = new HashMap<>();
        for(int i= 0;i<dataList.length();i++){
             JSONObject  item = (JSONObject) dataList.get(i);
            if (item.has("t_field_jiflrh7rhc")) {
                String productId = item.getString("t_field_jiflrh7rhc");
                BigDecimal productNum = item.getBigDecimal("t_field_uxggln4z");
                if(goodsInpurchaseMap.containsKey(productId)){
                    goodsInpurchaseMap.put(productId,goodsInpurchaseMap.get(productId).add(productNum));
                }else{
                    goodsInpurchaseMap.put(productId, productNum);
                }
                System.out.println("进货商品ID: " + productId +" 进货数量：" +productNum );
            } else {
                System.out.println("t_field_jiflrh7rhc 字段不存在");
            }
        }
        System.out.println("----------------------------------");

        HashMap<String,BigDecimal> goodsInWarehouse = new HashMap<>();
        JSONObject jsonObject2 = new JSONObject(goodsInWarehoseString);
        JSONObject dataObject2 = jsonObject2.getJSONObject("data");
        JSONArray dataList2 = dataObject2.getJSONArray("dataList");
        for(int i= 0;i<dataList2.length();i++){
            JSONObject  item = (JSONObject) dataList2.get(i);
            if (item.has("t_item_name")) {
                String productId = item.getString("t_item_name");
                BigDecimal productNum = item.getBigDecimal("t_number");
                goodsInWarehouse.put(productId,productNum);
                System.out.println("库存商品ID: " + productId +" 库存数量：" +productNum );
            } else {
                System.out.println("t_item_name 字段不存在");
            }
        }

        for(String key: goodsInpurchaseMap.keySet()){
            if(goodsInWarehouse.containsKey(key)){ // 仓库中存在该商品

            }else{ //仓库中不存在该商品

            }
        }
    }


    public static void updateGoodsToWarehouse(){

        System.out.println("开始操作库存数量。。。。。。。。");
        String ID ="HW6518361";//  入库仓库ID

        String t_item_name ="HW6190950";// 关联京东商品
        int t_number = 1;//库存数量
        String t_sumnumber ="";// 占用空间
        String t_field_mtcfzpugav ="";// 单位体积

        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 兑换token
        String ipaasAccessToken = IpaasAccessToken.getToken(httpClient);

        // 根据ID新增或更新数据(直接入库)
        String saveOrUpdateOneBatchDirect = "https://apaas-openapi-web.clickpaas.com/api/open/v3/t_object_y7w6twi0/saveOrUpdateBatch/direct";

        // 构建请求体(批量新增/更新)
        List<Map<String, Object>> saveOrUpdateDataListW04 = new ArrayList<>();
        Map<String, Object> saveOrUpdateDataW04 = new HashMap<>();

        // 构建查询条件
        Map<String, Object> queryW04 = new HashMap<>();
        queryW04.put("t_treewarehouse", ID); // 入库仓库ID
        queryW04.put("t_item_name", t_item_name);

        // 构建更新条件
        Map<String, Object> updateW04 = new HashMap<>();
        updateW04.put("t_item_name", t_item_name);
        updateW04.put("t_treewarehouse",ID);
        updateW04.put("t_number", t_number);
       // updateW04.put("t_sumnumber", "$placeholder");
       //  updateW04.put("t_field_mtcfzpugav", "$placeholder");
    //    updateW04.put("id",ID);

        saveOrUpdateDataW04.put("query", queryW04);
        saveOrUpdateDataW04.put("update", updateW04);
        saveOrUpdateDataListW04.add(saveOrUpdateDataW04);

        Map<String, Object> bodyMapW04 = new HashMap<>();
        bodyMapW04.put("payload", saveOrUpdateDataListW04);

        HttpPost requestW04 = new HttpPost(saveOrUpdateOneBatchDirect);
        requestW04.setEntity(new StringEntity(JSON.toJSONString(bodyMapW04), "UTF-8"));
        requestW04.setHeader("Content-Type", "application/json");
        requestW04.setHeader("Ipaas-Access-Token", ipaasAccessToken);
        requestW04.setHeader("sandBoxId", "");

        try {
            CloseableHttpResponse respW04 = httpClient.execute(requestW04);
            HttpEntity entityW04 = respW04.getEntity();
            if (entityW04 != null) {
                String resultW04 = EntityUtils.toString(entityW04);
                EntityUtils.consume(respW04.getEntity());
                System.out.println(resultW04);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
