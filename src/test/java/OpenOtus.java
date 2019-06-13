import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.concurrent.TimeUnit;

public class OpenOtus {

    String url = "https://otus.ru/";
    WebDriver driver = null;
    static final Logger rootLogger = LogManager.getRootLogger();

    @Before
    public void begin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void OpenPageCheckTitle() {

        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        try {
            Assert.assertTrue(driver.getTitle().equals("OTUS - Онлайн-образование!!!"));
            rootLogger.info("Успех! Страница открылась верно! ");
        }catch (Throwable e) {
            rootLogger.error("Ошибка! не верный тайтл страницы");
        }
    }

    @Test
    public void OpenPageCheckURL() {

        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        try {
            Assert.assertTrue(driver.getCurrentUrl().equals(url));
            rootLogger.info("Успех! Страница открылась верно! ");
        }catch (Throwable e) {
            rootLogger.error("Ошибка! не верный url страницы");
        }
    }
    @After
    public void End() {
        driver.quit();
    }
}




