import com.fhit.test.microcity3.MicroCity3Application;
import com.fhit.test.microcity3.dao.CityDao;
import com.fhit.test.microcity3.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wty
 * @create 2020-03-18 14:58
 */
@SpringBootTest(classes = MicroCity3Application.class)
@RunWith(SpringRunner.class)
public class micro_city3_test {
    @Autowired
    ApplicationContext context; // 获取ioc容器

    @Test
    public void testIoc() {
        CityService cityService = (CityService) context.getBean("cityService");
        CityDao cityDao = cityService.getCityDao();

        System.out.println("cityDao=" + cityDao);
    }
}
