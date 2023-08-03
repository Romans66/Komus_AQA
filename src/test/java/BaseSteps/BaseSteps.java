package BaseSteps;

import Const.Const;
import Const.PathConst;
import Const.TechnicalConst;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BaseSteps implements PathConst, Const, TechnicalConst {

  public BaseSteps(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  //Клик на кнопку
  protected final void clickOnButton(WebElement element) {
    element.click();
  }

  //Вставка текста в указанный элемент
  protected final void inputText(String text, WebElement element) {
    element.sendKeys(Keys.HOME + text);
  }

  // Скролл к элементу, Наведение и клик на элемент
  protected final void moveAndClick(WebElement element) {
    ACTIONS
            .moveToElement(element)
            .click()
            .perform();
  }

  //Проверка элемента на кликабельность
  protected final boolean isClicked(WebElement element) {
    return element.isSelected();
  }

  //Выбор радномного элемента из массива
  protected final WebElement chooseRandomElement(WebElement[] elements) {
    int index = random.nextInt(elements.length - 1);
    System.out.println("Выбор рандомного элемента из массива " + index);
    return elements[index];
  }

  //Выбор радномного элемента из коллекции элементов
  protected final WebElement chooseRandomElementFromList(List<WebElement> elements) {
    int index = random.nextInt(elements.size() - 1);
    System.out.println("Индекс выбранного рандомного элемента из коллекции " + index);
    return elements.get(index);
  }

  // Возвращает список элементов из веб страницы
  protected final List<WebElement> ListsOfElements(By by) {
    List<WebElement> listOfElements = DRIVER.findElements(by);
    return listOfElements;
  }

  //Загрузка файла по указанному пути
  protected final void uploadsFile(WebElement element, String pathToFile) {
    element.sendKeys(pathToFile);
  }

  //Ожидание до появления указанного элемента
  protected final void WaitElementShouldBeClick(WebElement element) {
    WAIT.until(ExpectedConditions.elementToBeClickable(element));
  }

  //Если элемент присутствует в DOM, вернет true / если нет - false
  protected final boolean PresentElement(WebElement element) {
    try {
      boolean isElementPresent = element.isDisplayed();
      return isElementPresent;
    } catch (NoSuchElementException e) {
      return false;
    }
  }


  //Методы для работы с VIP

  // Удаление элемента из DOM
  public void DeleteAlertCompanyMessage(WebElement element) {
    try {
      //
      EXECUTOR.executeScript("arguments[0].remove();", element);

      /*  // Не работает
      int xOffset = 10;
        int yOffset = 10;
           if(PresentElement (element)) {
               // Перемещаем курсор мыши за пределы элемента (на указанное кол-во пикселей) и кликаем
               ACTIONS
                       .moveToElement(element)
                       .moveByOffset(xOffset, yOffset)
                       .clickAndHold() // Нажатие левой кнопки мыши
                       .release() // Отпускание левой кнопки мыши
                       .perform();
           }*/

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  // Переключение на модальное окно и скролл к элементу
  public void switchToModalWindowAndScrollToElement(WebElement element) {
    // Запоминаем идентификатор текущего окна
    String parentWindowHandle = DRIVER.getWindowHandle();

    // Переключаемся на модальное окно
    for (String windowHandle : DRIVER.getWindowHandles()) {
      DRIVER.switchTo().window(windowHandle);
    }

    // Выполняем скролл к элементу внутри модального окна
    ((JavascriptExecutor) DRIVER).executeScript("arguments[0].scrollIntoView(true);", element);

    // Переключаемся обратно на основное окно
    DRIVER.switchTo().window(parentWindowHandle);
  }
}



