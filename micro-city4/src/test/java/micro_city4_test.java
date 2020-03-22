import com.fhit.test.microcity4.MicroCity4Application;
import com.fhit.test.microcity4.MyConfiguration;
import com.fhit.test.microcity4.dao.CityDao;
import com.fhit.test.microcity4.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wty
 * @create 2020-03-18 14:58
 */
@SpringBootTest(classes = MicroCity4Application.class)
@RunWith(SpringRunner.class)
public class micro_city4_test {
    @Autowired
    ApplicationContext context; // 获取ioc容器

    @Test
    public void testIoc() {
        CityService cityService = (CityService) context.getBean("cityService");
        CityDao cityDao = cityService.getCityDao();

        System.out.println("cityDao=" + cityDao);
    }

    @Test
    public void testIoc2() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MyConfiguration.class);

        CityService cityService = annotationConfigApplicationContext.getBean(CityService.class);

        System.out.println("cityService=" + cityService);
    }
}
