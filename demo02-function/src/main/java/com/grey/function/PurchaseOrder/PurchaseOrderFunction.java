package com.grey.function.PurchaseOrder;

import com.clickpaas.ipaas.function.core.FunctionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class PurchaseOrderFunction implements FunctionHandler<InputModel, OutputModel> {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderFunction.class);

    @Override
    public OutputModel handle(InputModel inputModel, Map<String, String> context) {
        String id = inputModel.getT_object_u5n7rlm7().getId();
        logger.info("--------------------------------------PurchaseOrder ID is :{}" , id);
        OutputModel outputModel = new OutputModel();
        outputModel.setValue("I get the input value:"+ id);
        return outputModel;
    }
}
