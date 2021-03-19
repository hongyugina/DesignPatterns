package org.rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.PageComponents.MultiTrip;
import org.rahulshettyacademy.PageComponents.RoundTrip;

public class StrategyFactory {

    WebDriver driver;
	By bookingSectionElement;  //locates the section that includes one-way/roundtrip/multitrip

   // By bookingSection =By.id("flightSearchContainer");     //this is the section that includes one-way/roundtrip/multitrip

    public StrategyFactory(WebDriver driver, By bookingSectionElement) {
        this.driver = driver;
		this.bookingSectionElement = bookingSectionElement;
    }

    public SearchFlightAvail selectTripType(String strategyType)

    {
        if (strategyType.equalsIgnoreCase("multitrip"))
        {

            return new MultiTrip(driver, bookingSectionElement);
        }

        if (strategyType.equalsIgnoreCase("roundtrip"))
        {
            return new RoundTrip(driver, bookingSectionElement);
        }

        return null;
    }

}
