package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsListPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'product-info']/h3[@class = 'product-name p-font']/a")
    private List<WebElement> searchList;

    public ProductsListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage clickElement(){
        searchList.get(0).click();
        return new ProductPage(driver);
    }

    public String getUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

}