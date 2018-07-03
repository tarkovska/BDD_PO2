/**
 * Created by Nataliya_Tarkovska on 3/28/2018.
 */
package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'form-search-right']/input[@type = 'text']")
    private WebElement search;

    @FindBy(xpath = "//div[@class = 'search-view-more']/a[@href = 'http://tartka.com.ua?s=soutage&post_type=product']")
    private WebElement searchFinish;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductsListPage search(String keyWord) {
        search.click();
        search.sendKeys(keyWord);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchFinish.click();
        return new ProductsListPage(driver);
    }

}