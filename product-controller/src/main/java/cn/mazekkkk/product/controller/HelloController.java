package cn.mazekkkk.product.controller;

import cn.mazekkkk.product.dao.common.Gametrade;
import cn.mazekkkk.product.dao.common.TblDoctorVerify;
import cn.mazekkkk.product.redis.service.IRedisService;
import cn.mazekkkk.product.scheduler.ScheduleTaskService;
import cn.mazekkkk.product.service.CacheReloadService;
import cn.mazekkkk.product.service.DoctorVerifyService;
import cn.mazekkkk.product.service.GameTradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    private IRedisService redisService;
    @Autowired
    private GameTradeService gameTradeService;
    @Autowired
    private DoctorVerifyService doctorVerifyService;
    @Autowired
    private CacheReloadService cacheReloadService;

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
        return "hello";
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
     * thymeleaf 推送html数据
     * @param name 参数名称
     * @param model 视图模型
     * @return
     */
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false,defaultValue = "world") String name, Model model){
        model.addAttribute("name",name);
        return "greeting";
    }

    /**
     * thymeleaf 推送html数据
     * @param name 参数名称
     * @param model 视图模型
     * @return
     */
    @RequestMapping("/extjs")
    public String extjs(@RequestParam(value = "name", required = false,defaultValue = "world") String name, Model model){
        model.addAttribute("name",name);
        return "extjs";
    }

    @RequestMapping("/redis/redisSet")
    @ResponseBody
    public Object redisSet(@RequestParam("value")String value){
        redisService.set("name", value);
        return value;
    }

    @RequestMapping("/redis/redisGet")
    @ResponseBody
    public Object redisGet(){
        String name = redisService.get("name");
        return name;
    }

    @RequestMapping("/GameTrade/saveGameTrade")
    @ResponseBody
    public void saveGameTrade(Gametrade gametrade){
        gameTradeService.saveGameTrade(gametrade);
    }

    @RequestMapping("/GameTrade/getGameTradePage")
    @ResponseBody
    public Object getGameTradePage(Integer page){
        return gameTradeService.getGameTrdePage(page);
    }

    @RequestMapping("/doctor/DoctorVerify")
    @ResponseBody
    public Object getDoctorVerify(Integer id){
        return doctorVerifyService.getDoctorVerify(id);
    }

    @RequestMapping(value = "/doctor/DoctorVerify/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void getDoctorVerify(@RequestBody @Valid TblDoctorVerify tblDoctorVerify) {
        doctorVerifyService.updateDoctorVerify(tblDoctorVerify);
    }

    @RequestMapping(value = "/doctor/DoctorVerify/cacheReload", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void doctorVerifyCacheReload(@RequestBody @Valid TblDoctorVerify tblDoctorVerify) {
        cacheReloadService.doctorVerifyCacheReload(tblDoctorVerify.getId());
    }

    @RequestMapping(value = "/doctor/DoctorVerify/cacheEvictReload", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void doctorVerifyCacheEvictReload(@RequestBody @Valid TblDoctorVerify tblDoctorVerify) {
        cacheReloadService.doctorVerifyCacheEvictReload(tblDoctorVerify.getId());
    }

}