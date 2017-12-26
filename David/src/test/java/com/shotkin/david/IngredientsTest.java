/**
 * 
 */
package com.shotkin.david;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author DZS
 *
 */
public class IngredientsTest {

	private WebDriver driver;
	private Ingredients ingredients;
	private String expectedFullList = "Apple butter, 1 Tbsp\n" + 
			"Apple(s) fresh, 1 medium\n" + 
			"Applesauce, unsweetened, 1/2 cup(s)\n" + 
			"Apple(s), dried, 1/4 cup(s)\n" + 
			"Juice, Cranberry-apple drink, 8 fl oz\n";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		ingredients = new Ingredients(driver);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void thirdIngredient() {
		String name = ingredients.getName(3);
		System.out.println("\nThe third ingredient is: " + name);
		Assert.assertEquals(name, "Applesauce, unsweetened");
	}

	@Test
	public void fifthIngredient() {
		String name = ingredients.getName(5);
		System.out.println("\nThe fifth ingredient is: " + name);
		Assert.assertEquals(name, "Juice, Cranberry-apple drink");
	}

	@Test
	public void fullList() {
		List<Ingredient> ingredientList = ingredients.getIngredients();
		StringBuilder actualList = new StringBuilder();
		ingredientList.forEach((ingredient) -> {
			actualList.append(ingredient + "\n");
		});
		System.out.println("\nThe full ingredient list is:\n" + actualList);
		Assert.assertEquals(actualList.toString(), expectedFullList);
	}
}
