import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver;
    SearchFormPage searchFormPage ;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://en.wikipedia.org/w/index.php?search");
        searchFormPage = new SearchFormPage(driver);
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}
