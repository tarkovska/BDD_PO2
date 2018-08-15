package stepdefs;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepDefinitions {

    private static WebDriver driver;

    @Given("^I am on the \\\"([^\\\"]*)\\\" page on URL \\\"([^\\\"]*)\\\"$")
    public void i_am_on_the_page_on_URL(String arg1, String arg2) throws Throwable {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(arg2);
    }

    @When("^I fill in with \"([^\"]*)\"$")
        public void i_fill_in_with(String arg2) throws Throwable {
            HomePage homePage = new HomePage(driver);
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            homePage.search(arg2);
        }

        @Then("^I am on the \"([^\"]*)\" page$")
        public void iAmOnThePage(String arg1) throws Throwable {
            ProductsListPage productPage = new ProductsListPage(driver);
            String searchResult = productPage.getUrl(driver);
        }

        @And("^I click on the first product$")
        public void i_click_on_first_product() throws Throwable {
            ProductsListPage productsListPage = new ProductsListPage(driver);
            productsListPage.clickElement();
        }

        @And("^I put it to cart$")
        public void i_put_it_to_cart() throws Throwable {
            ProductPage productPage = new ProductPage(driver);
            productPage.clickAddToCart();
        }
        @Then("^I go to my cart$")
        public void i_go_to_cart() throws Throwable {
            ProductPage productPage = new ProductPage(driver);
            productPage.clickGoToCart();
        }

        @Then("^I proceed to checkout$")
        public void i_proceed_to_checkout() throws Throwable {
            CartViewPage cartViewPage = new CartViewPage(driver);
            cartViewPage.clickOrder();
        }

        @And("^Fill customer's name \"([^\"]*)\"$")
        public void fill_customer_name(String arg1) throws Throwable {
            OrderPage orderPage = new OrderPage(driver);
            orderPage.fillFieldName(arg1);
        }
        @And("^Fill customer's surname \"([^\"]*)\"$")
        public void fill_customer_surname(String arg1) throws Throwable {
            OrderPage orderPage = new OrderPage(driver);
            orderPage.fillFieldSurname(arg1);
        }

        @And("^Fill customer's email \"([^\"]*)\"$")
        public void fill_customer_email(String arg1) throws Throwable {
            OrderPage orderPage = new OrderPage(driver);
            orderPage.fillFieldEmail(arg1);
        }

        @And("^Fill customer's phone \"([^\"]*)\"$")
        public void fill_customer_phone(String arg1) throws Throwable {
            OrderPage orderPage = new OrderPage(driver);
            orderPage.fillFieldPhone(arg1);
        }

        @And("^Click terms$")
        public void click_terms() throws Throwable {
            OrderPage orderPage = new OrderPage(driver);
            orderPage.clickTerms();
        }

        @Then("^I can see succesful checkout page with message \"([^\"]*)\"$")
        public void i_checkout(String message) throws Throwable {
            OrderPage orderPage = new OrderPage(driver);
            orderPage.clickPlaceOrder();
            CheckInPage checkInPage = new CheckInPage(driver);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Assert.assertEquals(checkInPage.getNotification(), message);

        }
        @Then("^I can see unsuccesful checkout page with message \"([^\"]*)\"$")
        public void i_uncheckout(String message) throws Throwable {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickPlaceOrder();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(orderPage.getNotification(), message);

    }
}