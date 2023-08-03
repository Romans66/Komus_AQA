import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfProperties;


public class main {
  public static void main(String args[]) {
    WebDriver driver = new ChromeDriver();
    //определение пути до драйвера и его настройка
    System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
    //определение пути до драйвера и его настройка
    driver.manage().window().maximize();
    driver.get(ConfProperties.getProperty("RegPage"));
    WebElement poisk = driver.findElement(By.xpath("//input[@id='search']"));
    poisk.sendKeys(Keys.HOME + "чай");
    WebElement linkElement = driver.findElement(By.linkText("//ul[@id='ui-id-1']"));
    linkElement.click();

  }

  public int factorial(int n) {

    return n * factorial(n - 1);
  }
}



