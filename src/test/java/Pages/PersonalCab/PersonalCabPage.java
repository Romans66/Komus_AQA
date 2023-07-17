package Pages.PersonalCab;

import BaseSteps.BaseSteps;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class PersonalCabPage extends BaseSteps {
  public PersonalCabPage(WebDriver driver) {
    super(driver);
  }

  //Общие элементы
  @FindBy(xpath = "//div[@class = 'alert account-page__alert js-account-company-alert']")
  private WebElement succesAllertAddCompany;
  @FindBy(xpath = "//span[@class = 'qa-company-name ']")
  private WebElement headerCompanyLink;
  @FindBy(xpath = "//button[@class = 'button button--primary button--size-s js-next-onboard']")
  private WebElement popapButton1;
  @FindBy(xpath = "//button[@class = 'button button--primary button--size-s js-close-onboard']")
  private WebElement popapButton2;

  //Общий блок после добавления компании
  public void ClickOnPopupButtons() {
    try {
    clickOnButton(popapButton1);
    clickOnButton(popapButton2);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
  }
  // Проверяем что на странице присутствуют: Алерт и компания в хедере
  public boolean IsElementPresent() {
    try {
      assertTrue(PresentElement (succesAllertAddCompany));
      assertTrue(PresentElement (headerCompanyLink));
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  public String AssertTextAllert() {
    //Забираем текст из аллерта
    String successMessage = succesAllertAddCompany.getText();
    try {
      System.out.println("Текст аллерта ЛК: " + successMessage);
      return successMessage;
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Текст аллерта ЛК: " + successMessage);
      return successMessage;
    }
  }
}

