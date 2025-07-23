package kwibal;

import org.openqa.selenium.By;


public class Locators {

    public static final By SEARCH_BOX = By.xpath("//input[contains(@placeholder, 'Search for anything')]"); 

    public static final By RESULTS = By.xpath("//div[@role='button' and contains(@class,'card flex')]");

}

