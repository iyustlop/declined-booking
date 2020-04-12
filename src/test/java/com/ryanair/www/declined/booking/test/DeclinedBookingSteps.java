package com.ryanair.www.declined.booking.test;

import com.ryanair.www.declined.booking.pages.DeclinedBookingSeats;
import com.ryanair.www.declined.booking.pages.DeclinedBookingCheckOut;
import com.ryanair.www.declined.booking.pages.DeclinedBookingFlights;
import com.ryanair.www.declined.booking.pages.DeclinedBookingHomePage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class DeclinedBookingSteps {

	private String destination;
	private String creditCard;

	private Date startDay;
	private Date finishDay;

	WebDriver driver;

	private static final String url = "https://www.ryanair.com/ie/en/";
	private static final String CHROME_DRIVER = "./src/test/resources/chromedriver.exe";

	SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

	DeclinedBookingHomePage homepage;
	DeclinedBookingFlights flights;
	DeclinedBookingSeats seats;
	DeclinedBookingCheckOut checkOut;

	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		this.destination = null;
		this.creditCard = null;

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(url);
	}

	@Given("^having \"(.*?)\" as destination$")
	public void having_as_destination(String destination) {
		this.destination = destination;
	}

	@Given("^having \"(.*?)\" as holiday start date$")
	public void having_as_holiday_start_date(String startDate) {

		try {
			startDay = formater.parse(startDate);
		} catch (ParseException error) {
			error.printStackTrace();
		}
	}

	@Given("^having \"(.*?)\" as holiday finish date$")
	public void having_as_holiday_finish_date(String finishDate) {

		try {
			finishDay = formater.parse(finishDate);
		} catch (ParseException error) {
			error.printStackTrace();
		}
	}

	@Given("^having \"(.*?)\" as credit card$")
	public void having_as_credit_card(String creditCard) {
		this.creditCard = creditCard;
	}

	@When("^I introduce the destination and dates$")
	public void i_introduce_the_destination_and_dates() {
		homepage = new DeclinedBookingHomePage(driver);
		homepage.setDestination(destination);

		homepage.setStartDate(startDay);
		homepage.setFinishDate(finishDay);
	}

	@When("^I add a passanger$")
	public void i_add_a_passanger() {
		homepage.clickArrow();
		homepage.addOnePassanger();
		homepage.clickLetsGo();
	}

	@When("^I select a outbound flight$")
	public void i_select_a_outbound_flight() throws InterruptedException {
		flights = new DeclinedBookingFlights(driver);
		flights.outboundFlight();
	}

	@When("^I select a return flight$")
	public void i_select_a_return_flight() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		flights.returnFlight();
		flights.clickContinueButton();
	}

	@When("^I select two seats$")
	public void i_select_two_seats() {
		seats = new DeclinedBookingSeats(driver);
		seats.selection();
		seats.selectionReturn();
		seats.confirmSelection();
	}
	
	@When("^I made the checkout$")
	public void i_made_the_checkout() {
		checkOut = new DeclinedBookingCheckOut(driver);
		checkOut.checkOutClick();
	}

	@Then("^decline the payment$")
	public void decline_the_payment() {
	}

}
