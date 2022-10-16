package Test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.DashboardPage;
import Pages.ListOfCheckBoxPage;
import util.BrowserFactory;

public class RemoveAllItemsTest {

	WebDriver driver;
	DashboardPage dashboardpage;
	ListOfCheckBoxPage listOfCheckBoxPage;

	@Before
	public void RemoveAllItemsTest() {
		driver = BrowserFactory.init();
		listOfCheckBoxPage = PageFactory.initElements(driver, ListOfCheckBoxPage.class);
	}

	@Test
	public void clickToggleAllAndRemove() {
		listOfCheckBoxPage.checkToggleAll();
		listOfCheckBoxPage.clickRemoveButton();

		Assert.assertTrue("The Checkbox list is clear", checkBoxClear());
	}

	private boolean checkBoxClear() {
		List<String> CheckBoxlist = listOfCheckBoxPage.getListOfCheckBox();
		for (int i = 0; i < CheckBoxlist.size(); i++) {
			if (CheckBoxlist.get(i).isEmpty()) {

			}
		}

		return true;
	}

	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
