package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreditPage extends BasePage{

    public CreditPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[text()='Кредит']")
    private WebElement tabCredit;
    @FindBy(xpath="//input[preceding-sibling::p[text()='Сумма кредита']]")
    private WebElement amountCredit;
    @FindBy(xpath="//input[preceding-sibling::p[text()='Срок кредита']]")
    private WebElement timeCredit;
    @FindBy(xpath="//div[@role='tabpanel' and not (@hidden)]//*[preceding-sibling::p[text()='Ежемесячный платеж']]")
    private WebElement res;

    public void inputData(String amount, String time){
        actions.moveToElement(tabCredit).click().perform();
        amountCredit.sendKeys(Keys.CONTROL + "a");
        amountCredit.sendKeys(Keys.DELETE, amount, Keys.ENTER);
        timeCredit.sendKeys(Keys.CONTROL + "a");
        timeCredit.sendKeys(Keys.DELETE, time, Keys.ENTER);
    }

    public String getResult(String expectedResult){
        wait.until(ExpectedConditions.textToBePresentInElement(res, expectedResult));
        return res.getText();
    }

}
