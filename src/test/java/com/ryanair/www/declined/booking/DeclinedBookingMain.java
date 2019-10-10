package com.ryanair.www.declined.booking;

import com.ryanair.www.declined.booking.test.DeclinedBookingTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class DeclinedBookingMain {
    public static void main(String[] args) {
        Result result =  JUnitCore.runClasses(DeclinedBookingTest.class);
    }
}
