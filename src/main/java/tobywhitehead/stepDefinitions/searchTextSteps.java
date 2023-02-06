package tobywhitehead.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import tobywhitehead.pageobjects.HomePage;

public class searchTextSteps {

    WebDriver driver;
    String baseUrl = "https://www.google.co.uk";

    @BeforeTest
    public void beforeSteps() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);

    }

    @AfterTest
    public void afterSteps() {
        driver.close();
    }


    @Given("On the google engine base page")
    public void on_the_google_engine_base_page() {
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl, "Not on the google engine base page");
    }

    @When("I enter (.+) and press return")
    public void i_enter_text_and_press_return (String string) {
        HomePage homePage = new HomePage(driver);
        homePage.searchBoxEnterTextAndReturn(string);
    }

    @Then("Search page is loaded with text in search box")
    public void search_page_is_loaded_with_text_in_search_box() {
        //Implement this
    }

}
