package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver =driver;
	}
	@FindBy(how = How.XPATH, using = "//input[@name='allbox']") WebElement CheckAllBox;
	
	public void waitforElement(WebElement element,WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("todo[0]")));
	}
}
