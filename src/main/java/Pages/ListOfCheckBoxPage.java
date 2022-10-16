package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListOfCheckBoxPage {
	
	WebDriver driver;
	
	public ListOfCheckBoxPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH, using ="//input[@name='allbox']") WebElement CheckAllBox;
	@FindBy(how = How.XPATH, using ="//input[@name='todo[1]']") WebElement CheckBoxTodo;
	@FindBy(how = How.XPATH, using ="//input[@value='Remove']")WebElement RemoveButton;
	
	public void checkToggleAll() {
		CheckAllBox.click();	
	}
	
	public void clickTodoItem() {
		CheckBoxTodo.click();
	}
	
	public void clickRemoveButton() {
		RemoveButton.click();
	}
		public List<String> getListOfCheckBox() {
			List<String> list = new ArrayList<String>();
			List<WebElement> columnDataElement = driver.findElements(By.xpath("//input[@name='todo[1]']"));
			for(int i =0; i< columnDataElement.size();i++) {
				list.add(i,columnDataElement.get(i).getText());
			}
		return list;	
			
		}

		}
	

	

