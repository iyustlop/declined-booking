package com.ryanair.www.declined.booking.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ryanair.www.declined.booking.pages.DeclinedBookingHomePage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class DeclinedBookingSteps {

	private String destination;
	private String startDate;
	private String finishDate;
	private String creditCard;

	WebDriver driver;

	private static final String url = "https://www.ryanair.com/ie/en/";
	private static final String CHROME_DRIVER = "/home/sobremesa/Documentos/Java/declined-booking/src/main/resources/chromedriver";

	DeclinedBookingHomePage homepage;

	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		this.destination = null;
		this.startDate = null;
		this.finishDate = null;
		this.creditCard = null;

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);
	}

	@Given("^having \"(.*?)\" as destination$")
	public void having_as_destination(String destination) {
		this.destination = destination;
	}

	@Given("^having \"(.*?)\" as holiday start date$")
	public void having_as_holiday_start_date(String startDate) {
		this.startDate = startDate;
	}

	@Given("^having \"(.*?)\" as holiday finish date$")
	public void having_as_holiday_finish_date(String finishDate) {
		this.finishDate = finishDate;
	}

	@Given("^having \"(.*?)\" as credit card$")
	public void having_as_credit_card(String creditCard) {
		this.creditCard = creditCard;
	}

	@When("^I connect to the url$")
	public void i_connect_to_the_url() {
		homepage = new DeclinedBookingHomePage(driver);
		homepage.setDestination(destination);
	}

	@When("^I introduce the destination and dates$")
	public void i_introduce_the_destination_and_dates() {
		homepage.setDestination(destination);
	}

}
