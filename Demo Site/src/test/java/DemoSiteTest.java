import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoSiteTest {

	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		
	}
	
	@Test
	public void demoSiteTesting() {
		
		driver.get("http://thedemosite.co.uk/addauser.php");
		driver.findElement(By.linkText("3. Add a User")).click();
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("guest");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("guest");
		driver.findElement(By.name("FormsButton2")).click();
		
		driver.findElement(By.linkText("4. Login")).click();
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("guest");
		driver.findElement(By.name("password")).sendKeys("guest");
		driver.findElement(By.name("FormsButton2")).click();
		driver.findElement(By.cssSelector("font > center")).click();
		
		assertThat(driver.findElement(By.cssSelector("center > b")).getText(), is("**Successful Login**"));
	
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	
}
