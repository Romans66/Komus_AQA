package Pages.PersonalCabVip;

import BaseSteps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VipPersonalCabPage extends BaseSteps {

  public VipPersonalCabPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//div[@class='b-back__window qa-popup b-back__window--auto js-back__window']")
  private WebElement allertCompanyMessage;
  @FindBy(xpath = "//a[text()=' Настройки компании ']")
  private WebElement optionsOfCompanyLink;
  @FindBy(xpath = "//div[@class='b-back__window__wrapper js-back__remove i-display-initial']")
  private WebElement wrapperBackWindow;



  public void ClickOnOptionsOfCompanyLink() {
    clickOnButton(optionsOfCompanyLink);
  }
  public void CheckAndDeleteAlertCompanyMessage() {
    if (PresentElement(wrapperBackWindow)) {
      DeleteAlertCompanyMessage(wrapperBackWindow);
    }
  }


}

