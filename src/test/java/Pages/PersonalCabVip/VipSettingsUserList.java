package Pages.PersonalCabVip;

import BaseSteps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VipSettingsUserList extends BaseSteps {

  public VipSettingsUserList(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//a[@class='b-btn b-btn--red qa-users-add']")
  private WebElement vipUsersAddButton;

  public void clickOnVipUsersAdd() {
    clickOnButton(vipUsersAddButton);
  }
}
