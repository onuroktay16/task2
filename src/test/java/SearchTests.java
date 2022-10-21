import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTests extends BaseTest{

    @Test
    public void searchWithText(){
        searchFormPage.setSearchKey("berlin");
        Assertions.assertEquals("berlin",searchFormPage.getName(),"searchValue is not correct.");
        searchFormPage.clickSearchButton();
        searchFormPage.checkSearchResultPage();
    }

    @Test
    public void searchWithSearchIn(){
        searchFormPage.clickSearchInButton();
        searchFormPage.selectAllButton();
        searchFormPage.setSearchKey("berlin");
        Assertions.assertEquals("berlin",searchFormPage.getName(),"searchValue is not correct.");
        searchFormPage.clickSearchButton();
        searchFormPage.checkSearchResultPage();
    }
}
