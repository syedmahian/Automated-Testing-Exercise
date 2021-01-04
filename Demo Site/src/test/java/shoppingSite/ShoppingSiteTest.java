package selenium;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingSiteTest {
	
	 private WebDriver driver;

	    @Before
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().setSize(new Dimension(1366, 768));

	    }
  
  @Test
  public void checkTshirt() {
    driver.get("http://automationpractice.com/index.php");
  
    driver.findElement(By.cssSelector(".sf-menu > li:nth-child(3) > a")).click();
    driver.findElement(By.cssSelector(".product_img_link > .replace-2x")).click();
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Faded Short Sleeve T-shirts"));
    driver.findElement(By.cssSelector(".exclusive > span")).click();
    driver.findElement(By.cssSelector(".button-medium > span")).click();
    assertThat(driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).getText(), is("Faded Short Sleeve T-shirts"));
    driver.findElement(By.cssSelector(".standard-checkout > span")).click();
  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
}