package org.rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.PageComponents.MultiTrip;
import org.rahulshettyacademy.PageComponents.RoundTrip;

public class StrategyFactory {

    WebDriver driver;

    By bookingSection =By.id("flightSearchContainer");

    public StrategyFactory(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvail createStrategy(String strategyType)

    {
        if (strategyType.equalsIgnoreCase("multitrip"))
        {

            return new MultiTrip(driver, bookingSection);
        }

        if (strategyType.equalsIgnoreCase("roundtrip"))
        {
            return new RoundTrip(driver, bookingSection);
        }

        return null;
    }

}
