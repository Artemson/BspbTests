package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    final private String MAIN_LINK_SITE = "https://www.bspb.ru/";

    public BasePage(WebDriver driver){
       this.driver = driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       this.actions = new Actions(driver);
    }

    public void openSite(WebDriver driver){
        driver.get(MAIN_LINK_SITE);
    }
}
