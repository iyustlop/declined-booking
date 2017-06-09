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

	public DeclinedBookingFlights(WebDriver driver) {
		this.driver = driver;
	}

	public void outboundFlight() {
		WebElement outboundButton = driver.findElement(firstOutboundFlight);
		outboundButton.click();

		WebElement leisureClassOption = driver.findElement(leisureClass);
		leisureClassOption.findElement(By.id("continue")).click();
	}

	public void returnFlight() {

	}
}
