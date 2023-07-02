package Pages.FeedBack;

import BaseSteps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.NumericHelper;
import utils.StringHelper;

public class FeedBackPage extends BaseSteps {

    public FeedBackPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"cardboardBoxType1\"]")
    private WebElement boxType1;
    @FindBy(xpath = "//*[@id=\"tippy-2\"]/div[2]/div[3]/a")
    private WebElement acceptRegion;

    @FindBy(xpath = "//*[@id=\"cardboardBoxType2\"]")
    private WebElement boxType2;

    @FindBy(xpath = "//*[@id=\"feedback.komus.quantity\"]")
    private WebElement quantity;

    @FindBy(xpath = "//*[@id=\"feedback.komus.comment\"]")
    private WebElement writeText;

    @FindBy(xpath = "//*[@id=\"feedback.komus.alias\"]")
    private WebElement inputName;

    @FindBy(xpath = "//*[@id=\"feedback.komus.email\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"feedback.komus.phone\"]")
    private WebElement phone;
    @FindBy(xpath = "//*[@id=\"form\"]/div[1]/div[5]/div[1]/div[1]/div/label/span[1]")
    private WebElement checkBox1;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div[5]/div[1]/div[2]/div/label/span[1]")
    private WebElement checkBox2;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div[5]/div[1]/div[3]/div/label/span[1]")
    private WebElement checkBox3;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div[7]/button")
    private WebElement submit;

    @FindBy(xpath = "//*[@id=\"file\"]")
    private WebElement uploadsFile;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div[5]/div[1]/input[2]")
    private WebElement fileName;

    public void inputEmail() {
        inputText(StringHelper.getMail(), email);
    }

    public void inputName() {
        inputText(StringHelper.getRandomRussianString(6) + " " + StringHelper.getRandomRussianString(5), inputName);
    }

    public void inputPhone() {
        inputText(StringHelper.getPhoneNumber(), phone);
    }

    public void inputQuantity() {
        inputText(String.valueOf(NumericHelper.getRandomInt(69)), quantity);
    }

    public void inputWriteText() {
        inputText(StringHelper.getRandomRussianString(20), writeText);
    }

    public void chooseCountOfBox() {
        WebElement[] arrayRadioButton = {boxType1, boxType2};
        WebElement element = chooseRandomElement(arrayRadioButton);
        WaitElementShouldBeClick(element);
        moveAndClick(element);
    }

    public boolean isClickRadioButton() {
        return isClicked(boxType1);
    }

    public void clickCheckBox() {
        WebElement[] arrayCheckBox = {checkBox1, checkBox2, checkBox3};
        moveAndClick(chooseRandomElement(arrayCheckBox));
    }

    public void sendForm() {
        clickOnButton(submit);
    }

    public void acceptRegion() {
        WaitElementShouldBeClick(acceptRegion);
        clickOnButton(acceptRegion);
    }
    public void uploadFile() {
        uploadsFile(uploadsFile, "C:\\Репозиторий 2 Комус\\src\\test\\resources\\2023-03-31_174716.jpg");
    }
    public boolean isElementPresent(By element) {
        try {
            DRIVER.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    }




