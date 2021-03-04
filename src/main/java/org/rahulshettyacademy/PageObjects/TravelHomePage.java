package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvail;
import org.rahulshettyacademy.AbstractComponents.StrategyFactory;
import org.rahulshettyacademy.PageComponents.FooterNavigation;
import org.rahulshettyacademy.PageComponents.NavigationBar;

import java.util.HashMap;

public class TravelHomePage {


    By footerSectionElement =  By.id("traveller-home");  //footer section object

    By headerSectionElement = By.id("buttons");  //header section object

    SearchFlightAvail searchFltAvailability;  //booking section object for OneWay, RoundTrip and MultiTrip by returning the Interface Type for code re-usability.



    WebDriver driver;

    public TravelHomePage(WebDriver driver) {

        this.driver = driver;  //this driver has life and is passed from our testcases

    }


    public void launchURL()
    {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.manage().window().maximize();
    }


    // below method is to re-direct us to the "NavigationBar" class or Section
    public NavigationBar getNavigationBar()
    {
        return new NavigationBar(driver, headerSectionElement); //NavigationBar object is created
    }


    // below method is to re-direct us to the "FooterNavigation" class Section
    public FooterNavigation getFooterNavigation()
    {
        return new FooterNavigation(driver, footerSectionElement);  //FooterNavigation object is created

    }

//Use "Strategy Design Pattern" to create an object of either OneWay or RoundTrip or MultiTrip
    public void setBookingStrategy(String tripType)
    {

   //below two lines to use "Strategy design Pattern to call "createStrategy()" method to create an object of tripType (i.e. Round Trip or MultiTrip)
        StrategyFactory strategyFactory = new StrategyFactory(driver);
        SearchFlightAvail search = strategyFactory.createStrategy(tripType);

  //Use SRP to create searchFltAvailability object so that you can use it to invoke the "checkAvailability" method defined in our Interface
        this.searchFltAvailability = search; //SearchFlightAvail object is created.

    }


    public void checkAvail(HashMap<String,String> originDest)
    {
       //call and implement the checkAvailability method defined in our Interface based on the "searchFltAvailability" object passed (i.e. either RoundTrip or MultiTrip)
        searchFltAvailability.checkAvailability(originDest);
    }


    public String getTitle()

    {
        System.out.println(("This is test."));
        return driver.getTitle();
    }

}
