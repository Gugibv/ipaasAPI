package com.ncs.management.api.product;

import com.clickpaas.ipaas.mapper.BaseMapper;
import com.clickpaas.ipaas.model.DataResponse;
import com.example.demo.sdk.IPaasobject_9f06tf0g;

import java.util.Arrays;
import java.util.List;

public class productManagemet_new {

    public static void main(String[] args) {
        findById();


    }

    public static void findById() {
        BaseMapper<IPaasobject_9f06tf0g> baseMapper = new BaseMapper<IPaasobject_9f06tf0g>() {
        };

        DataResponse<List<IPaasobject_9f06tf0g>> byIds = baseMapper.findByIds(Arrays.asList("HW3132465"));

        System.out.println(byIds.getData().get(0).getT_field_a8hijbgb());
    }
}
WWW