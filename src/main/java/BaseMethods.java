import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseMethods {

    protected WebDriver driver;

    public BaseMethods(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void sendKeys(By locator, String text){
        WebElement me = find(locator);
        if (me != null) {
            me.sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator, int timiOut) {
        try {
            waitForElement(locator, timiOut);
            return true;
        } catch (WebDriverException wde) {
            return false;
        }
    }

    public WebElement waitForElement(By by, int timeOut) {
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }
}
