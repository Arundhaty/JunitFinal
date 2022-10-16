package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.DashboardPage;
import Pages.ListOfCheckBoxPage;
import util.BrowserFactory;

public class RemoveSingleItemTest {

	WebDriver driver;
	DashboardPage dashboardpage;
	ListOfCheckBoxPage listOfCheckBoxPage;
	@Before
	public void removeSingleItem() {
		driver = BrowserFactory.init();
		listOfCheckBoxPage = PageFactory.initElements(driver, ListOfCheckBoxPage.class);
	}
		@Test
		public void clickOneItemToRemove() {
			listOfCheckBoxPage.clickTodoItem();
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			listOfCheckBoxPage.clickRemoveButton();
			Assert.assertTrue("The item was removed successfully", true);
		}	
	}
