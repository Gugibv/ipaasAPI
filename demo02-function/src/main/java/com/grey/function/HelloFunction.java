package com.grey.function;
import com.clickpaas.ipaas.function.core.FunctionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class HelloFunction implements FunctionHandler<InputModel, OutputModel> {
    private static final Logger logger = LoggerFactory.getLogger(HelloFunction.class);


    /**
     * 业务处理接口，输入对象和输出对象用户可以自定义，根据业务需求来，这里的实例定义了个入参对象InputModel，和出参对象OutputMode
     *
     * @param input
     * @param context
     * @return
     */
    @Override
    public OutputModel handle(InputModel input, Map<String, String> context) {
        String name = input.getName();
        logger.info("hello,clickpaas");
        OutputModel outputModel = new OutputModel();
        outputModel.setValue(name+" build unlimited possibilities");
        return outputModel;
    }
}
