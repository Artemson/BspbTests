package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class MortgagePage extends BasePage {

    public MortgagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Ипотека']")
    private WebElement tabMortgage;
    @FindBy(xpath = "//div[@role='tabpanel' and not (@hidden)]//*[preceding-sibling::p[text()='Ежемесячный платеж']]")
    private WebElement monthlyPaymentOfMortgage;
    @FindBy(xpath = "//div[@role='tabpanel' and not (@hidden)]//h2[preceding-sibling::p[text()='Ставка']]")
    private WebElement rateOfMortgage;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Стоимость недвижимости']]")
    private WebElement priceOfRealty;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Срок']]")
    private WebElement timeMortgage;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Первоначальный взнос']]")
    private WebElement initialPayment;

    public void inputData(String price, String time, String initial){
        actions.moveToElement(tabMortgage).click().perform();

        wait.until(ExpectedConditions.elementToBeClickable(priceOfRealty));
        priceOfRealty.sendKeys(Keys.CONTROL + "a");
        priceOfRealty.sendKeys(Keys.DELETE, price, Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(timeMortgage));
        timeMortgage.sendKeys(Keys.CONTROL + "a");
        timeMortgage.sendKeys(Keys.DELETE, time, Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(initialPayment));
        initialPayment.sendKeys(Keys.CONTROL + "a");
        initialPayment.sendKeys(Keys.DELETE, initial, Keys.ENTER);
    }

    public List<String> getResults(List<String> expectedResult){
        wait.until(ExpectedConditions.textToBePresentInElement(monthlyPaymentOfMortgage, expectedResult.get(0)));
        wait.until(ExpectedConditions.textToBePresentInElement(rateOfMortgage, expectedResult.get(1)));
        return Arrays.asList(monthlyPaymentOfMortgage.getText(),rateOfMortgage.getText());
    }


}
