import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewWindowTest {

  WebDriver driver;

  @BeforeMethod
  public void setup() {
    driver = new ChromeDriver();
    driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#Open%20New%20Window");
    driver.manage().window().maximize();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }

  @Test
  public void iFrameTest() {
    By buttonBy = By.cssSelector(".button_hilite");
    driver.findElement(buttonBy).click();

    driver.get("https://www.amazon.fr");
    //Set<String> listOfWindows = driver.getWindowHandles();
    ArrayList<String> listOfTabs = new ArrayList<>(driver.getWindowHandles());
    String window1 = listOfTabs.get(0);
    String window2 = listOfTabs.get(1);


    driver.switchTo().window(window2); // second tab
    driver.get("https://www.google.fr");

    driver.switchTo().window(window1); // first tab
    driver.get("https://www.airfrance.fr");

    driver.switchTo().window(window2);
    driver.close();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }




}
