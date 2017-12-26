package com.shotkin.david;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ingredients {

	static String htmlFile = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\com\\shotkin\\david\\ingredients.html";

	@FindBy(xpath = "//span[contains(@class,'title')]")
	List<WebElement> titles;

	public Ingredients(WebDriver driver) {
		driver.get(htmlFile);
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * @return a LinkedHashMap using the ingredients as keys and the quantities as
	 *         values. Assumes that there are no duplicate ingredients.
	 */
	public List<Ingredient> getIngredients() {
		List<Ingredient> list = new ArrayList<>();
		for (WebElement title : titles) {
			String name = title.getText();
			String quantity = title.findElement(By.xpath("following-sibling::span")).getText();
			list.add(new Ingredient(name, quantity));
		}
		return list;
	}

	/**
	 * @param oneBasedIndex
	 *            the index of the desired ingredient
	 * @return the name of the specified ingredient
	 */
	public String getName(int oneBasedIndex) {
		List<Ingredient> ingredientList = getIngredients();
		Ingredient ingredient = ingredientList.get(oneBasedIndex - 1);
		return ingredient.getName();
	}
}
