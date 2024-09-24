package grey.ncs.management.api.product;

import java.util.*;

import com.clickpaas.ipaas.mapper.BaseMapper;
import com.clickpaas.ipaas.model.DataResponse;
import grey.ncs.management.api.entity.IPaasobject_u5n7rlm7;

public class ApiTest {
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

    public static void findById() {
        BaseMapper<IPaasobject_u5n7rlm7> baseMapper = new BaseMapper<IPaasobject_u5n7rlm7>() {
        };

        DataResponse<List<IPaasobject_u5n7rlm7>> byIds = baseMapper.findByIds(Arrays.asList("HW6954990"));

        System.out.println(byIds.getData().get(0).getName());
    }

}
