package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


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

    protected void clickElement(WebElement element) {
        waitElement(element);
        element.click();
    }

    protected void waitElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitTextInElement(WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected void inputData(WebElement element, String data){
        element.sendKeys(Keys.CONTROL + "a");  // ?????????????????? Почему вместе они не работают ?????????????????
        element.sendKeys(Keys.DELETE);
        element.sendKeys(data);
        element.sendKeys(Keys.ENTER);
    }
}
