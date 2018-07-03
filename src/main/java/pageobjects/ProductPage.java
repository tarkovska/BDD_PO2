package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    @FindBy(name = "add-to-cart")
    private WebElement addToCart;

    @FindBy(xpath = "//div[@class = 'woocommerce-message']/a[@href = 'http://tartka.com.ua/en/cart-2/']")
    private WebElement goToCart;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage clickAddToCart(){
        addToCart.click();
        return new ProductPage(driver);
    }

    public CartViewPage clickGoToCart(){
        goToCart.click();
        return new CartViewPage(driver);
    }
}