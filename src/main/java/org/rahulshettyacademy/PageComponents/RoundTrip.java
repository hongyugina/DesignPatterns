package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {


    private By roundTripRadioBtn = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By fromEditBox = By.id("ctl00_mainContent_ddl_originStation1_CTXT");

    private By toEditBox = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");

    private By checkBox = By.id("ctl00_mainContent_chk_IndArm");

    private By searchBtn = By.id("ctl00_mainContent_btn_FindFlights");



   //Constructor
    public RoundTrip(WebDriver driver, By bookingSection) {
        super(driver, bookingSection);
    }


   //below method is to use "Execute Around" design pattern to take care of the pre-requisites or required things for a test
    public void makeStateReady(Consumer<RoundTrip> consumer)
    {
        findElement(roundTripRadioBtn).click(); //click the "Round Trip" radiobutton

        waitForElementToBeSelected(roundTripRadioBtn);

        consumer.accept(this);   //then do whatever action from current "RoundTrip" class
    }


    @Override
    public void checkAvailability(HashMap<String, String> originDestination) {

        System.out.println("checkAvailability: this is for Round Trip");
        makeStateReady(s->selectOriginCity(originDestination.get("origin")));

        selectDestinationCity(originDestination.get("destination"));
        findElement(checkBox).click();
        findElement(searchBtn).click();

    }


    public void selectOriginCity(String origin)

    {
        findElement(fromEditBox).click();  //click the "From" editbox
        findElement(By.xpath("//a[@value='" + origin + "']")).click();

    }

    public void selectDestinationCity(String dest)
    {

        findElement(toEditBox).click();  //click the "From" editbox
        findElement(By.xpath("(//a[@value='" + dest + "'])[2]")).click();
    }

}
