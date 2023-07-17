package Pages.PersonalCab;

import BaseSteps.BaseSteps;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.NumericHelper.getRandomInt;
import static utils.ReadFileLineHelper.ReadFileLineByLine;


public class PersonalCabCompanySpecPwdAddPage extends BaseSteps {

  public PersonalCabCompanySpecPwdAddPage(WebDriver driver) {
    super(driver);
  }

  //Элементы для добавления компании по спецпаролю
  @FindBy(xpath = "//input[@name = 'specPassword']")
  private WebElement inputSpecialPwd;
  @FindBy(xpath = "//button[@class = 'b-btn b-btn--red i-mr15 i-pb10']")
  private WebElement addCompanyButtonSpecialPwd;


  //Блок добавления компании по спецпаролю
  public void InputRandomSpecPwd() {
    String randomSpecPwd = ReadFileLineByLine(PATHSPECPWD).get(getRandomInt(ReadFileLineByLine(PATHSPECPWD).size()));
    WaitElementShouldBeClick(inputSpecialPwd);
    inputText(randomSpecPwd, inputSpecialPwd);
    System.out.println(ReadFileLineByLine(PATHSPECPWD));
  }

  public void ClickOnAddCompanyButtonSpecialPwd() {
     try {
       clickOnButton(addCompanyButtonSpecialPwd);
     } catch (NoSuchElementException e) {
       e.printStackTrace();
     }

  }
}
