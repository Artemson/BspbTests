package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    private WebElement monthlyPayment;

    public void inputCreditData(String amount, String time){
        actions.moveToElement(tabCredit).click().perform();

        oldValue = monthlyPayment.getText();
        sendData(amountCredit, amount);
        waitForTextChange(monthlyPayment, oldValue);

        oldValue = monthlyPayment.getText();
        sendData(timeCredit, time);
        waitForTextChange(monthlyPayment, oldValue);
    }

    public String getActualResult(){
        return monthlyPayment.getText();
    }

}
