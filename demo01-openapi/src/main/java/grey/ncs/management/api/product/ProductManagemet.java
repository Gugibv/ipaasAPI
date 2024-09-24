package grey.ncs.management.api.product;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.clickpaas.ipaas.mapper.BaseMapper;
import com.clickpaas.ipaas.model.DataResponse;
import grey.example.demo.sdk.IPaasobject_9f06tf0g;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 【天猫】商品
 */
public class ProductManagemet {
    public static void main(String []args){
        findById();
   //     updateProductById() ;
    }
    public static String findById() {
        BaseMapper<IPaasobject_9f06tf0g> baseMapper = new BaseMapper<IPaasobject_9f06tf0g>() {
        };

        DataResponse<List<IPaasobject_9f06tf0g>> byIds = baseMapper.findByIds(Arrays.asList("HW3132465"));
        String name =  byIds.getData().get(0).getT_field_s7z61rv8().toString();
        System.out.println(name);
        return  name;
    }

    public static void updateProductById(){
            CloseableHttpClient httpClient = HttpClients.createDefault();

              // 兑换token
            String ipaasAccessToken;
            {
                Map<String, String> bodyMap = new HashMap<>();
                bodyMap.put("appCode", "abfcfd89-71b1-4d20-af32-7e1d6fc856fd");
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
            // 根据条件新增/更新数据，如果根据条件过滤出多条数据，会返回错误信息
            String saveOrUpdateOne = "https://apaas-openapi-web.clickpaas.com/api/open/v3/t_object_9f06tf0g/saveOrUpdate";

            // 构建查询条件
            Map<String, Object> queryW01 = new HashMap<>();
            queryW01.put("name", "CE202407000002"); // 商品编号

            // 构建更新条件
            Map<String, Object> RetailPrice = new HashMap<>(); //零售价
            RetailPrice.put("code","CNY");
            RetailPrice.put("text","人民币");
            RetailPrice.put("symbol","￥");
            RetailPrice.put("value", "109");

            Map<String, Object> WholesalePrice = new HashMap<>(); //批发价
            WholesalePrice.put("code","CNY");
            WholesalePrice.put("text","人民币");
            WholesalePrice.put("symbol","￥");
            WholesalePrice.put("value", "89");


            Map<String, Object> PurchasePrice = new HashMap<>();//进货价
            PurchasePrice.put("code","CNY");
            PurchasePrice.put("text","人民币");
            PurchasePrice.put("symbol","￥");
            PurchasePrice.put("value", "69");


            Map<String, Object> updateW01 = new HashMap<>();
            updateW01.put("t_field_s7z61rv8", "男士外套 plus"); // 商品名称
            updateW01.put("t_field_pu1w2950", "0.22"); // 单位体积（m^3）
            updateW01.put("t_field_avabv026", RetailPrice); // 零售价
            updateW01.put("t_field_a8hijbgb", WholesalePrice); // 批发价
            updateW01.put("t_field_sz4f282p", PurchasePrice); // 进货价
            updateW01.put("t_field_wo9345j0", "商品详细信息22"); // 商品详细信息

        //    updateW01.put("t_field_i98ik104", "$placeholder"); // 商品图片
        //    updateW01.put("t_field_ef9rfdt8", "$placeholder"); // 商品主图
        //    updateW01.put("t_field_ugqbsy19", "$placeholder"); // 商品单位
        //    updateW01.put("t_field_yib6tu48", "$placeholder"); // 商品分类

            Map<String, Object> bodyMapW01 = new HashMap<>();
            bodyMapW01.put("query", queryW01);
            bodyMapW01.put("update", updateW01);

            HttpPost requestW01 = new HttpPost(saveOrUpdateOne);
            requestW01.setEntity(new StringEntity(JSON.toJSONString(bodyMapW01), "UTF-8"));
            requestW01.setHeader("Content-Type", "application/json");
            requestW01.setHeader("Ipaas-Access-Token", ipaasAccessToken);
            requestW01.setHeader("sandBoxId", "");

            try {
                CloseableHttpResponse respW01 = httpClient.execute(requestW01);
                HttpEntity entityW01 = respW01.getEntity();
                if (entityW01 != null) {
                    String resultW01 = EntityUtils.toString(entityW01);
                    EntityUtils.consume(respW01.getEntity());
                    System.out.println(resultW01);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
