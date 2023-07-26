package Pages.PersonalCabVip;

import BaseSteps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PassGeneratorHelper;
import utils.StringHelper;

import java.util.List;

import static utils.NumericHelper.getRandomInt;
import static utils.SaveDataHelper.StringTempVariableSetter;
import static utils.StringHelper.getPhoneNumber;
import static utils.StringHelper.getRandomRussianString;

public class VipSettingsUserAdd extends BaseSteps {
  public VipSettingsUserAdd(WebDriver driver) {
    super(driver);
  }
  @FindBy(xpath = "//input[@name='firstName']")
  WebElement inputFirstName;
  @FindBy(xpath = "//input[@name='middleName']")
  WebElement inputMiddleName;
  @FindBy(xpath = "//input[@name='lastName']")
  WebElement inputLastName;
  @FindBy(xpath = "//input[@name='phone']")
  WebElement inputPhone;
  @FindBy(xpath = "//input[@name='sso']")
  WebElement inputSso;
  @FindBy(xpath = "//input[@name='email']")
  WebElement inputEmail;
  @FindBy(xpath = "//input[@name='pwd']")
  WebElement inputPwd;
  @FindBy(xpath = "//input[@name='pwd2']")
  WebElement inputPwd2;
  @FindBy(xpath = "//input[@name='agreement']")
  WebElement PersonalDataAgreeCheckBox;
  @FindBy(xpath = "//button[@class='b-btn b-btn--red b-btn--plain js-vipUser__add qa-user-save']")
  WebElement SaveButton;
  @FindBy(xpath = "//div[@class='b-back__window qa-popup b-back__window--auto js-back__window']")
  WebElement modalAddWindow;

  // Управление подразделением
  protected By subdivisionsListBy = By.xpath("//input[@type='radio']");
  @FindBy(xpath = "//a[@class='b-btn b-btn--grey js-user__list-dep-choice qa-user-unit-control']")
  WebElement subdivisionsManagementButton;
  @FindBy(xpath = "//button[@class='b-btn b-btn--red qa-popup-save js-unit--select__button']")
  WebElement subdivisionsChooseButton;

  //Добавление грузополучателя
  protected By consigneeListBy = By.xpath("//div[@data-pageid='1']");
  @FindBy(xpath = "//a[@class='b-btn b-btn--grey js-address--add__button qa-user-consignee']")
  WebElement consigneeAddButton;

  @FindBy(xpath = "//button[@class='b-btn b-btn--red qa-popup-save js-address__addNow']")
  WebElement consigneeChooseButton;

  //Выбор роли
  @FindBy(xpath = "//span[@class='ui-selectmenu-text']")
  WebElement rolesDropdown;
  protected By rolesListBy = By.xpath("//li[@class='ui-menu-item']");

  // Выбор Подразделения
  public VipSettingsUserAdd VipSubdivisionChoose() {
    clickOnButton(subdivisionsManagementButton);
    List listsOfElements = ListsOfElements(subdivisionsListBy);
    WebElement elementOfList = chooseRandomElementFromList(listsOfElements);
    moveAndClick(elementOfList);
    clickOnButton(subdivisionsChooseButton);
    return new VipSettingsUserAdd(DRIVER);
  }

  // Выбор грузополучателя
  public VipSettingsUserAdd VipConsigneeChoose() {
    try {
      clickOnButton(consigneeAddButton);
      List listsOfElements = ListsOfElements(consigneeListBy);
      WebElement elementOfList = chooseRandomElementFromList(listsOfElements);
      moveAndClick(elementOfList);
      clickOnButton(consigneeChooseButton);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new VipSettingsUserAdd(DRIVER);
  }
  // Выбор Роли
  public VipSettingsUserAdd VipRoleChoose() {
    try {
    clickOnButton(rolesDropdown);
    List listsOfElements = ListsOfElements(rolesListBy);
    WebElement elementOfList = chooseRandomElementFromList(listsOfElements);
    moveAndClick(elementOfList);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    return new VipSettingsUserAdd(DRIVER);
  }

  // Заполнение полей данными о сотруднике
  public VipSettingsUserAdd VipDataInput() {
    try {
      // Заполняем рандомными данными прочие поля
      inputText(getRandomRussianString(RANDOMSIZEOFSTRING), inputFirstName);
      inputText(getRandomRussianString(RANDOMSIZEOFSTRING), inputMiddleName);
      inputText(getRandomRussianString(RANDOMSIZEOFSTRING), inputLastName);
      inputText(getPhoneNumber(), inputPhone);
      inputText(String.valueOf(getRandomInt(RANDOMSIZEOFSTRING)), inputSso);
      //Выбор чекбокса "Согласие на ОПД"
      moveAndClick(PersonalDataAgreeCheckBox);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    return new VipSettingsUserAdd(DRIVER);
  }
    public VipSettingsUserAdd VipPwdAndEmailInput() {
      // Генерируем пароль и email
      String email = StringHelper.getMail();
      String pwd = PassGeneratorHelper.generatePassword();
      try {
      //Заполнение e-mail и пароля
      inputText(email, inputEmail);
      //Генерация пароля и повтор его во второй строке
      inputText(pwd, inputPwd);
      inputText(pwd, inputPwd2);
      } catch (NoSuchElementException e) {
        e.printStackTrace();
      }
      // Запоминаем сгенерированные емаил и пароль
      StringTempVariableSetter (email, pwd);
      return new VipSettingsUserAdd(DRIVER);
    }

    public VipSettingsUserAdd VipClickOnSaveButton() {
      clickOnButton(SaveButton);
      return new VipSettingsUserAdd(DRIVER);
    }

}
