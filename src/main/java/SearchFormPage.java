import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFormPage extends BaseMethods {

    private final By searchBoxLocator = By.id("ooui-php-1");
    private final By searchButtonLocator = By.xpath("//*[@id=\"mw-search-top-table\"]/div/div/div/span/span");
    private final By searchResultTextLocator = By.xpath("//*[@id=\"mw-content-text\"]/div[3]/div[1]/p");
    private final By searchInComponenetLocator = By.xpath("//*[@id=\"search\"]/div[4]/div[2]/span/a/span[3]");
    private final By searchInAllLocator = By.xpath("//*[@id=\"mw-advancedSearch-expandable-namespaces\"]/div/div[2]/div/div/label[4]/span[1]");

    public  SearchFormPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void setSearchKey(String searchKey){
        waitForElement(searchButtonLocator,10);
        sendKeys(searchBoxLocator,searchKey);
    }

    public String getName(){
       return find(searchBoxLocator).getAttribute("value");
    }

    public void clickSearchButton(){
        waitForElement(searchButtonLocator,5);
        click(searchButtonLocator);
    }

    public void checkSearchResultPage(){
        Assertions.assertTrue(isElementPresent(searchResultTextLocator,10));
    }

    public void clickSearchInButton(){
        waitForElement(searchInComponenetLocator,5);
        click(searchInComponenetLocator);
    }

    public void selectAllButton(){
        waitForElement(searchInAllLocator,5);
        click(searchInAllLocator);
    }

}
