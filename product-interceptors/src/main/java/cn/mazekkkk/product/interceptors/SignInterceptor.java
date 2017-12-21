package cn.mazekkkk.product.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by maze on 17/6/23.
 */
public class SignInterceptor extends HandlerInterceptorAdapter implements EnvironmentAware {
    private RelaxedPropertyResolver propertyResolver;
    public static String SECRET_KEY = "MiaoMiaoCloud";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 预处理回调方法
     * @param request 请求
     * @param response 响应
     * @param handler 处理者
     * @return 返回true流程继续|返回false流程中断通过response响应
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
//        Map<String, String[]> parameterMap  = request.getParameterMap();
//        Boolean flag;
//        String sign;
//        String requestSign = "";
//        /**
//         * 检查请求时间是否超时
//         */
//        flag = this.checkRequestTime(parameterMap,sdf);
//
//        /**
//         * 如果时间超时直接返回
//         */
//        if(flag==false){
//            return flag;
//        }
//
//        if(parameterMap.containsKey("sign")){
//            requestSign = parameterMap.get("sign").toString();
//            parameterMap.remove("sign");
//        }
//
//        List keyList = MapUtils.sortKeyAsc(parameterMap);
//        String key = "";
//        for (int i = 0; i < keyList.size(); i++) {
//            key += keyList.get(i).toString();
//        }
//
//        sign = MD5Util.MD5Encode(key+SECRET_KEY,"UTF8");
//
//        /**
//         * 检查签名算法
//         */
//        if(sign.equals(requestSign)){
//            flag = true;
//        }else{
//            flag = false;
//        }

//        return flag;
        return true;
    }

    /**
     * Controller 方法调用之后执行，视图渲染之前调用，可以使用ModelAndView 进行视图处理
     * @param request 请求
     * @param response 响应
     * @param handler 处理者
     * @param modelAndView 视图模型控制器
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 方法将在整个请求结束之后，在渲染了对应的视图之后执行。这个方法的主要作用是资源清理
     * @param request 请求
     * @param response 响应
     * @param handler 处理者
     * @param ex 异常
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 检查时间超时
     * @param parameterMap 请求参数
     */
    public Boolean checkRequestTime(Map parameterMap,SimpleDateFormat sdf) throws ParseException {
        Date now = new Date();
        Date requestDate;

        if(parameterMap.containsKey("time_stamp")){
            requestDate = sdf.parse(parameterMap.get("time_stamp").toString());
        }else{
            return false;
        }

        if(Math.abs(now.getTime()-requestDate.getTime())>Long.parseLong(propertyResolver.getProperty("request-time-out"))){
            return false;
        }

        return true;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment,"custom.");
    }
}
