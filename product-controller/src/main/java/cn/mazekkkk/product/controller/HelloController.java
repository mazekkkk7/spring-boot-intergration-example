package cn.mazekkkk.product.controller;

import cn.mazekkkk.product.scheduler.ScheduleTaskService;
import cn.mazekkkk.product.service.XncAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by mazekkkk on 16/1/12.
 */
@Controller
@RequestMapping(value = "/index")
public class HelloController {

    @Autowired
    private ScheduleTaskService scheduleTaskImpl;

    @Autowired
    private XncAddressService xncAddressService;

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private  Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 测试方法
     * @return
     */
    @RequestMapping(value = "/hello")
    @ResponseBody
    public Object hello() {
        logger.info("test insert----------------------");
        return "build Spring boot Success!";
    }

    /**
     * 生成任务根据时间定时执行
     * @param date
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/generateTask")
    @ResponseBody
    public Object generateTask(@RequestParam(value = "startDate",required = false) String date) throws ParseException {
        logger.info("startSchedulerTask----------------------");
        scheduleTaskImpl.schedulerGenerate(sdf.parse(date));
        return "generate task Success!";
    }

    /**
     * 获取所有地址
     * @return
     */
    @RequestMapping(value = "/getAllAddress")
    @ResponseBody
    public Object getAllAddress(){
        logger.info("selectAllAddress-----------------------");
        return xncAddressService.getAllAddress();
    }

    /**
     * thymeleaf 推送html数据
     * @param name 参数名称
     * @param model 视图模型
     * @return
     */
    @RequestMapping("/greetingView")
    public String greeting(@RequestParam(value = "name", required = false,defaultValue = "world") String name, Model model){
        model.addAttribute("name",name);
        return "greeting";
    }

}