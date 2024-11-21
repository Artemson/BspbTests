package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class BasePage {

    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    protected String oldValue;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
    }

    public void openSite(WebDriver driver) {
        driver.get("https://www.bspb.ru/");
    }

    protected void clickElement(WebElement element) {
        waitElementBeClicable(element);
        element.click();
    }

    protected void waitElementBeClicable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitTextInElement(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected void waitResultField(WebElement element) {
        System.out.println(String.format("Oldvalue = %s", oldValue));
        System.out.println(String.format("text %s != %s", element.getText() ,oldValue));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, oldValue)));
    }


    protected void refreshOldValue(WebElement element){
        System.out.println(String.format("text in element = %s", element.getText()));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, "0 ₽")));
        oldValue = element.getText();
        System.out.println(String.format("Oldvalue = %s", oldValue));
    }

    protected void sendData(WebElement element, String data){
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(data);
        element.sendKeys(Keys.ENTER);
    }
}
