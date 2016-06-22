package cn.mazekkkk.product.common.result;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mazekkkk on 16/6/21.
 */
public class BaseResultMap {

    private String result;

    private String message;

    private String errorMessage;

    private Object data;

    private Map<String,Object> baseResultMap;


    public BaseResultMap(String result, String message, String errorMessage, Object data) {
        this.result = result;
        this.message = message;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public Map<String,Object> getResultMap(){
        baseResultMap.put("result",result);
        baseResultMap.put("message",getMessageMap(message,errorMessage));
        baseResultMap.put("data",data);
        return baseResultMap;
    }

    private Map<String,Object> getMessageMap(String message,String errorMessage){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("message","SUCCESS");
        resultMap.put("errorMessage","EMPTY");
        return resultMap;
    }



}
