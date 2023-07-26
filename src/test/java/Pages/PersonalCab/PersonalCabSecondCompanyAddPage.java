package Pages.PersonalCab;

import BaseSteps.BaseSteps;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.NumericHelper.getRandomInt;
import static utils.ReadFileLineHelper.ReadFileLineByLineWithSplit;


public class PersonalCabSecondCompanyAddPage extends BaseSteps {
  public PersonalCabSecondCompanyAddPage(WebDriver driver) {
    super(driver);
  }

  //Элементы для добавления компании по ИНН + КК
  @FindBy(xpath = "//input[@name='inn']")
  private WebElement inputInn;
  @FindBy(xpath = "//input[@name='clientCode']")
  private WebElement inputKk;
  @FindBy(xpath = "//input[@value='Добавить']")
  private WebElement AddCompanyButtonInnKk;

  //Элементы для добавления компании по спецпаролю
  @FindBy(xpath = "//a[text() = 'Я знаю спецпароль']")
  private WebElement specialPwdLink;

  public PersonalCabSecondCompanyAddPage ClickOnSpecPwdLink() {
    try {
      clickOnButton(specialPwdLink);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    return new PersonalCabSecondCompanyAddPage(DRIVER);
  }
  public PersonalCabSecondCompanyAddPage ClickOnAddCompanyButtonInnKk() {
    try {
      clickOnButton(AddCompanyButtonInnKk);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    return new PersonalCabSecondCompanyAddPage(DRIVER);
  }

  public PersonalCabSecondCompanyAddPage InputRandomInnAndKk() {
    System.out.println(ReadFileLineByLineWithSplit(PATHINNKK));
    int randomCounter = getRandomInt(ReadFileLineByLineWithSplit(PATHINNKK).size());
    int i = 0;
    String randomInn = null;
    for (String key : ReadFileLineByLineWithSplit(PATHINNKK).keySet()) {
      if (i == randomCounter) {
        randomInn = key;
        break;
      }
      i++;
    }
    String randomKk = ReadFileLineByLineWithSplit(PATHINNKK).get(randomInn);
    inputText(randomInn, inputInn);
    inputText(randomKk, inputKk);
    System.out.println(randomInn + " " + randomKk);
    return new PersonalCabSecondCompanyAddPage(DRIVER);
  }
}


