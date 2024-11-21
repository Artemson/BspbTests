package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CityChoosePage extends BasePage {

    public CityChoosePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@id, 'menu-button')][preceding-sibling::a[contains(@href, 'offices')]]")
    private WebElement citiesMenu;

    public void chooseCity(String city) {
        clickElement(citiesMenu);
        clickElement(driver.findElement(By.xpath(String.format("//button[text()='%s']", city)))); //String.format()
        waitTextInElement(citiesMenu, city);
    }

    public String getSelectedCity() {
        return citiesMenu.getText();
    }

}
