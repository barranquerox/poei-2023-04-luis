import java.util.concurrent.TransferQueue;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import pageobjects.SearchResultPage;

public class AmazonTest {

  WebDriver driver;

  @BeforeMethod
  public void setup() {
    driver = new ChromeDriver();
    driver.get("https://www.amazon.fr");
    driver.manage().window().maximize();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }

  @Test
  public void testAmazon() {
    String keyword = "Apple iPhone 14 Pro (512 Go) - Violet Intense";

    HomePage homePage = new HomePage(driver);

    String realTitle = homePage.closeCookiePopup()
        .search(keyword)
        .openSearchResult(0)
        .addToCartAndOpenCart()
        .getProductTitle(0);

    Assert.assertEquals(realTitle, keyword, "The product title is not " + keyword);
  }


}
