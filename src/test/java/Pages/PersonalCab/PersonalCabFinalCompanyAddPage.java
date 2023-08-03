package Pages.PersonalCab;

import BaseSteps.BaseSteps;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalCabFinalCompanyAddPage extends BaseSteps {

  public PersonalCabFinalCompanyAddPage(WebDriver driver) {
    super(driver);

  }

  @FindBy(xpath = "//input[@value = 'Подключить']")
  private WebElement finalAddCompanyButton;

  public void ClickOnFinalAddCompanyButton() {
    try {
      clickOnButton(finalAddCompanyButton);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
  }
}