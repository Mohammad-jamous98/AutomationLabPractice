package lession3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mytest {

	WebDriver driver = new ChromeDriver();

	Random Rand = new Random();

	@BeforeTest
	public void mysetuptest() {

		driver.get("https://codenboxautomationlab.com/practice/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(enabled = false)
	public void radiotest() {

		List<WebElement> AllRadioButton = driver.findElements(By.className("radioButton"));

		int totalRadioButtons = driver.findElements(By.className("radioButton")).size();

		// this is to select random radio button
		int RandomRadioButtonIndex = Rand.nextInt(totalRadioButtons);

		AllRadioButton.get(RandomRadioButtonIndex).click();

	}

	@Test(enabled = false)
	public void autofill() throws InterruptedException {

		WebElement Autofillinput = driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input"));

		String[] Countreis = { "jo", "ye", "usa", "sy" };

		int RandomIndex = Rand.nextInt(Countreis.length);

		System.out.println(RandomIndex);
		Autofillinput.sendKeys(Countreis[RandomIndex]);

		Thread.sleep(2000);

		Autofillinput.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(enabled = false)
	public void Droplistchoice() {

		WebElement ListChoice = driver.findElement(By.name("dropdown-class-example"));

		Select mySelect = new Select(ListChoice);

		// mySelect.selectByVisibleText("Appium");

		// mySelect.selectByIndex(1);

		mySelect.selectByValue("option3");

	}

	@Test(enabled = false)
	public void checkboxcchecked() {

		WebElement Choiceboxes = driver.findElement(By.id("checkbox-example"));

		List<WebElement> AllCheckBoxs = Choiceboxes.findElements(By.tagName("input"));

		int RandomBox = Rand.nextInt(AllCheckBoxs.size());

		AllCheckBoxs.get(RandomBox).click();

//		for(int i = 0 ; i < AllCheckBoxes.size();i++) {
//		AllCheckBoxes.get(i).click();
//
//	

	}

	@Test(enabled = false)
	public void clickontab() throws InterruptedException {

		WebElement SwitchWindowButton = driver.findElement(By.id("openwindow"));

		SwitchWindowButton.click();

		Set<String> handles = driver.getWindowHandles();

		List<String> windowList = new ArrayList<>(handles);

		driver.switchTo().window(windowList.get(1));

		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"menu-item-9660\"]/a/span[1]")).click();
		Thread.sleep(2000);

		driver.switchTo().window(windowList.get(0));
		System.out.println(driver.getTitle());

	}

	@Test(enabled = false)

	public void AlertButton() throws InterruptedException {

		WebElement Alert = driver.findElement(By.id("name"));

		Alert.sendKeys("Mohammad");

		WebElement AlertCaps = driver.findElement(By.id("alertbtn"));

		AlertCaps.click();

		Thread.sleep(2000);

		driver.switchTo().alert().accept();

	}

	@Test(enabled = false)

	public void ConfirmButton() throws InterruptedException {

		WebElement Confirm = driver.findElement(By.id("name"));

		Confirm.sendKeys("Mohammad");

		WebElement ConfirmCaps = driver.findElement(By.id("confirmbtn"));

		ConfirmCaps.click();

		Thread.sleep(2000);

		// driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();

	}

	@Test(enabled = false)

	public void TableTest() {

		WebElement TableFound = driver.findElement(By.id("product"));

		// to print all Rows data
//		List<WebElement> AllRows = driver.findElements(By.tagName("tr"));
//		
//		for(int i = 0 ; i < AllRows.size() ; i++) {
//			
//			System.out.println(AllRows.get(i).getText());
//		}

		// to print all Rows data without head data
//		List<WebElement> AllData = driver.findElements(By.tagName("td"));
//		
//		for(int i = 0 ; i < AllData.size() ; i++) {
//			
//			System.out.println(AllData.get(i).getText());
//		}

		List<WebElement> SpicificRows = driver.findElements(By.tagName("tr"));

		// For Loop to thorough all Cells in Table
		for (int i = 0; i < SpicificRows.size(); i++) {
			List<WebElement> Cells = SpicificRows.get(i).findElements(By.tagName("td"));

			// Make sure row has enough columns
			if (Cells.size() >= 3) {

				// Spicific column Can didect it by (index 0 , 1 , 2)
				System.out.println(Cells.get(0).getText());
			}
		}

	}

}
