package Pages.PersonalCabVip;

import BaseSteps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VipSettingsOfCompany extends BaseSteps {
  public VipSettingsOfCompany(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//a[@class='navigation__link '][1]")
  private WebElement settingsOfVipUsersLink;

  public void clickOnVipUsersLink() {
    clickOnButton(settingsOfVipUsersLink);
  }
}
