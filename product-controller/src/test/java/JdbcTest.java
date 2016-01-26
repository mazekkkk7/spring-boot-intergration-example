import cn.mazekkkk.product.controller.MazekkkkApplication;
import cn.mazekkkk.product.dao.JdbcTemplateDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by mazekkkk on 16/1/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MazekkkkApplication.class)
public class JdbcTest {

    @Autowired
    private JdbcTemplateDao jdbcTemplateDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    @Test
    public void testJdbc(){
        Object object = jdbcTemplateDao.selectAllAddress();
        this.prinltResult(object);
    }

    private void prinltResult(Object object){
        logger.info(gson.toJson(object));
    }

}
