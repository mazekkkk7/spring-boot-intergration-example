package cn.mazekkkk.product.plugin.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mazekkkk on 16/1/18.
 */
@Component
public class PropertiesReader {
    /**
     * 获取配置文件
     * @param prop 属性
     * @return
     */
    public String getPropValue(String prop,String fileName){
        Properties properties = new Properties();
        String result = "";
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            properties.load(inputStream);
            return properties.getProperty(prop);
        } catch(IOException e) {
            e.printStackTrace();
            return result;
        }

    }
}
