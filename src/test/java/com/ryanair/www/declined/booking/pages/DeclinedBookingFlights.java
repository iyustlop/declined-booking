package com.ryanair.www.declined.booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeclinedBookingFlights {

	WebDriver driver;

	By firstOutboundFlight = By.xpath(
			"//*[@id='flight-FR~2051~ ~~MAD~08/14/2017 08:35~PMI~08/14/2017 10:10~']/div/div[2]/flights-table-price/div/div");
	By leisureClass = By.xpath(
			"//*[@id='outbound']/form/div[3]/div/flights-table/div/div[1]/div[1]/div/flights-table-fares/div/div[1]/div[2]");
	By secondReturnFlight = By.xpath(
			"//*[@id='flight-FR~2054~ ~~PMI~08/21/2017 14:10~MAD~08/21/2017 15:45~']/div/div[2]/flights-table-price/div/div");
	By leisureClass2 = By.xpath(
			"//*[@id='inbound']/form/div[3]/div/flights-table/div/div[1]/div[2]/div/flights-table-fares/div/div[1]/div[2]");
	By continueButton = By.xpath("//*[@id='declined.booking-selection']/article/div[2]/section/div[2]/button");

	public DeclinedBookingFlights(WebDriver driver) {
		this.driver = driver;
	}

	public void outboundFlight() throws InterruptedException {
		WebElement outboundButton = driver.findElement(firstOutboundFlight);
		outboundButton.click();

		Thread.sleep(1000);
		WebElement leisureClassOption = driver.findElement(leisureClass);
		leisureClassOption.findElement(By.id("continue")).click();
	}

	public void returnFlight() throws InterruptedException {
		Thread.sleep(1000);
		WebElement returnFlight = driver.findElement(secondReturnFlight);
		returnFlight.click();

		Thread.sleep(1000);
		try {
			WebElement leisureClassOption2 = driver.findElement(leisureClass2);
			leisureClassOption2.findElement(By.id("continue")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickContinueButton() throws InterruptedException {
		Thread.sleep(3000);
		WebElement continueButtonClick = driver.findElement(continueButton);
		continueButtonClick.click();
	}
}
