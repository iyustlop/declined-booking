package com.ryanair.www.declined.booking.pages;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeclinedBookingHomePage {

	WebDriver driver;

	By destination = By.xpath("//input[@placeholder='Destination airport']");
	By destinationPopup = By.xpath("/div/div/div[2]/popup-content/core-linked-list/div[2]/div[1]/div[3]");

	By dayStart = By.xpath("//input[@name='dateInput0']");
	By monthStart = By.xpath("//input[@name='dateInput1']");
	By yearStart = By.xpath("//input[@name='dateInput2']");

	By dayFinish = By.xpath("//*[@id='row-dates-pax']/div[1]/div/div[2]/div/div[2]/div[2]/div/input[1]");
	By monthFinish = By.xpath("//*[@id='row-dates-pax']/div[1]/div/div[2]/div/div[2]/div[2]/div/input[2]");
	By yearFinish = By.xpath("//*[@id='row-dates-pax']/div[1]/div/div[2]/div/div[2]/div[2]/div/input[3]");

	By arrow = By.xpath("//*[@id='row-dates-pax']/div[2]/div[2]/div[2]/div/div[2]");
	By addOnePass = By.xpath(
			"//*[@id='row-dates-pax']/div[2]/div[3]/div/div/div[2]/popup-content/div[6]/div/div[3]/core-inc-dec/button[2]");

	By clickLetsGo = By.xpath("//*[@id='search-container']/div[1]/div/form/div[4]/button[2]");

	public DeclinedBookingHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void setDestination(String destination) {
		driver.findElement(this.destination).sendKeys(destination);
		driver.findElement(this.destination).sendKeys(Keys.RETURN);

	}

	public void setStartDate(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		WebElement days = driver.findElement(dayStart);
		days.sendKeys(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement month = driver.findElement(monthStart);
		month.clear();
		month.sendKeys(String.valueOf(calendar.get(Calendar.MONTH) + 1));

		WebElement year = driver.findElement(yearStart);
		year.clear();
		year.sendKeys(String.valueOf(calendar.get(Calendar.YEAR)));
		year.sendKeys(Keys.RETURN);

	}

	public void setFinishDate(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		WebElement days = driver.findElement(dayFinish);
		days.sendKeys(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement month = driver.findElement(monthFinish);
		month.clear();
		month.sendKeys(String.valueOf(calendar.get(Calendar.MONTH) + 1));

		WebElement year = driver.findElement(yearFinish);
		year.clear();
		year.sendKeys(String.valueOf(calendar.get(Calendar.YEAR)));
		year.sendKeys(Keys.RETURN);
	}

	public void clickArrow() {
		WebElement arrow = driver.findElement(this.arrow);
		arrow.click();
	}

	public void addOnePassanger() {
		WebElement plusOne = driver.findElement(addOnePass);
		plusOne.click();
	}

	public void clickLetsGo() {
		WebElement button = driver.findElement(clickLetsGo);
		button.click();
	}
}
