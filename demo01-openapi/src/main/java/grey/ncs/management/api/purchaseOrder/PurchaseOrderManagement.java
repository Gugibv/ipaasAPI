package grey.ncs.management.api.purchaseOrder;

import java.util.*;

import com.clickpaas.ipaas.mapper.BaseMapper;
import com.clickpaas.ipaas.model.DataResponse;
import grey.ncs.management.api.entity.IPaasobject_u5n7rlm7;

public class PurchaseOrderManagement {
    public static void main(String[] args) {
        findById();
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
        BaseMapper<IPaasobject_u5n7rlm7> baseMapper = new BaseMapper<IPaasobject_u5n7rlm7>() {};
        DataResponse<List<IPaasobject_u5n7rlm7>> byIds = baseMapper.findByIds(Arrays.asList("HW6954990"));
        String purchaseOrderName = byIds.getData().get(0).getName().toString();
        System.out.println(purchaseOrderName);
        return  purchaseOrderName;
    }

}
