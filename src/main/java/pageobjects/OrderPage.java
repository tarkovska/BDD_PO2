package pageobjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    private WebDriver driver;

    @FindBy(id = "billing_first_name")
    private WebElement name;

    @FindBy(id = "billing_last_name")
    private WebElement surname;

    @FindBy(id = "billing_email")
    private WebElement email;

    @FindBy(id = "billing_phone")
    private WebElement phone;

    @FindBy(id = "terms")
    private WebElement terms;

    @FindBy(id = "place_order")
    private WebElement placeOrder;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    private WebElement notification;

    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderPage fillFieldName(String fieldValue) {
        name.click();
        name.sendKeys(fieldValue);
        return new OrderPage(driver);
    }
    public OrderPage fillFieldSurname(String fieldValue) {
        surname.click();
        surname.sendKeys(fieldValue);
        return new OrderPage(driver);
    }
    public OrderPage fillFieldEmail(String fieldValue) {
        email.click();
        email.sendKeys(fieldValue);
        return new OrderPage(driver);
    }
    public OrderPage fillFieldPhone(String fieldValue) {
        phone.click();
        phone.sendKeys(fieldValue);
        return new OrderPage(driver);
    }
    public OrderPage clickTerms() {
        terms.sendKeys(Keys.SPACE);
        return new OrderPage(driver);
    }
    public CheckInPage clickPlaceOrder() {
        placeOrder.sendKeys(Keys.ENTER);
        return new CheckInPage(driver);
    }
    public String getNotification(){
        return notification.getText();
    }
}