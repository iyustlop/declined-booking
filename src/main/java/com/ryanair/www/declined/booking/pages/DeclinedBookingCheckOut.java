package com.ryanair.www.declined.booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeclinedBookingCheckOut {
	
	WebDriver driver;
	
	By checkOutButton = By.xpath("//*[@id='booking-selection']/article/div[2]/section/div[2]/button");
	
	public DeclinedBookingCheckOut(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkOutClick(){
		WebElement checkOutButtonClick = driver.findElement(checkOutButton);
		checkOutButtonClick.click();
		
	}

}
