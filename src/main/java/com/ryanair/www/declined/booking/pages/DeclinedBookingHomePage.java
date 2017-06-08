package com.ryanair.www.declined.booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeclinedBookingHomePage {

	WebDriver driver;

	By destination = By.xpath("//input[@placeholder='Destination airport']");

	public DeclinedBookingHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void setDestination(String destination) {
		driver.findElement(this.destination).sendKeys(destination);
	}
}
