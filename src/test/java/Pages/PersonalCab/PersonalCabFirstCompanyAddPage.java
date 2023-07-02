package Pages.PersonalCab;

import BaseSteps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PersonalCabFirstCompanyAddPage extends BaseSteps {
  public PersonalCabFirstCompanyAddPage(WebDriver driver) {
    super(driver);

  }
  @FindBy(xpath = "//button[@value='yes']")
  private WebElement companyAddButton;

  public void ClickOnCompanyYesButton() {
    try {
      WaitElementShouldBeClick(companyAddButton);
      clickOnButton(companyAddButton);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}