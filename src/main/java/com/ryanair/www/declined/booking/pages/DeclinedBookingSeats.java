package com.ryanair.www.declined.booking.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeclinedBookingSeats {
	
	WebDriver driver;
	                         
	By firstSeat = By.xpath("//*[@id='scrollable']/div[1]/div/div[2]/div[11]/div[5]/span/span");
	By secondSeat = By.xpath("//*[@id='scrollable']/div[1]/div/div[2]/div[11]/div[6]/span/span");
	
	By nextButton = By.xpath("//*[@id='ngdialog1']/div[2]/div[1]/div/div[4]/dialog-footer/div[1]/button");
	
	By firstSeatReturn = By.xpath("//*[@id='scrollable']/div[1]/div/div[2]/div[13]/div[5]/span/span");
	By secondSeatReturn = By.xpath("//*[@id='scrollable']/div[1]/div/div[2]/div[13]/div[6]/span/span");
	
	By nextButtonReturn = By.xpath("//*[@id='ngdialog1']/div[2]/div[1]/div/div[4]/dialog-footer/div[1]/button");
	
	By confirmButton = By.xpath("//*[@id='ngdialog1']/div[2]/div[1]/div/div[4]/dialog-footer/div[1]/button");
	By checkOutButton = By.xpath("//*[@id='booking-selection']/article/div[2]/section/div[2]/button");
	
	public DeclinedBookingSeats(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selection(){
		WebElement firstSeatSelected = driver.findElement(firstSeat);
		firstSeatSelected.click();
		WebElement secondSeatSelected = driver.findElement(secondSeat);
		secondSeatSelected.click();
		
		WebElement nextButtonClick = driver.findElement(nextButton);
		nextButtonClick.click();
	}
	
	public void selectionReturn(){
		WebElement firstSeatSelected = driver.findElement(firstSeatReturn);
		firstSeatSelected.click();
		WebElement secondSeatSelected = driver.findElement(secondSeatReturn);
		secondSeatSelected.click();
		
		WebElement nextButtonClick = driver.findElement(nextButtonReturn);
		nextButtonClick.click();
	}
	
	public void confirmSelection(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement confirmButtonClick = driver.findElement(confirmButton);
		confirmButtonClick.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement checkoutClick = driver.findElement(checkOutButton);
		checkoutClick.click();
	}

}
