package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class DepositPage extends BasePage {

    @FindBy(xpath = "//button[text()='Вклад']")
    private WebElement tabDeposit;
    @FindBy(xpath = "//input[preceding-sibling::p[text()='Сумма вклада']]")
    private WebElement amountDeposit;
    @FindBy(xpath = "//h2[preceding-sibling::p[text()='Доход']]")
    private WebElement wageDeposit;
    @FindBy(xpath = "//div[@role='tabpanel' and not (@hidden)]//h2[preceding-sibling::p[text()='Ставка']]")
    private WebElement rateDeposit;

    public DepositPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void inputDepositData(String amount, String period) {
        actions.moveToElement(tabDeposit).click().perform();
        waitElementBeClicable(amountDeposit);
        refreshOldValue(wageDeposit);
        sendData(amountDeposit, amount);
        waitResultField(wageDeposit);
        WebElement periodDeposit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//span[contains(@class, 'chakra-radio__label')][preceding-sibling::input[@value='%s']]", period))));
        refreshOldValue(wageDeposit);
        actions.moveToElement(periodDeposit).click().perform();
        waitResultField(wageDeposit);
    }


    public Map<String, String> getActualResults() {
        return Map.of("wageDeposit", wageDeposit.getText(), "rateDeposit", rateDeposit.getText());
    }

}
