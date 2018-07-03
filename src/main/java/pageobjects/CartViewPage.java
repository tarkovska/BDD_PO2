/**
 * Created by Nataliya_Tarkovska on 3/28/2018.
 */

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartViewPage {

    private WebDriver driver;

    @FindBy(xpath = "//table[@class = 'shop_table shop_table_responsive cart woocommerce-cart-form__contents']/tbody/tr[2]/td/a")
    private WebElement order;

    public CartViewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderPage clickOrder() {
        order.click();
        return new OrderPage(driver);
    }

}
