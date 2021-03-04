package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {


    private By modalPopUp = By.id("MultiCityModelAlert");
    private By multiTripRadioBtn = By.id("ctl00_mainContent_rbtnl_Trip_2");

    private By fromEditBox = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By toEditBox = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By fromEditoBox_2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");

    //private By searchBtn = By.id("ctl00_mainContent_btn_FindFlights");



    //Constructor
    public MultiTrip(WebDriver driver, By bookingSection) {
        super(driver, bookingSection);
    }

  //below 3 steps is showing how to use "Execute Around design pattern" to ensure to execute the pre-requisites; perform actual methods; and execute post-requisite (tear down)
    public void makeStateReady(Consumer<MultiTrip> consumer)
    {
        //step 1. below two lines are to execute the pre-requisites, i.e. select the "Multi City" raditobutton and click OK on the popup message
        findElement(multiTripRadioBtn).click();
        findElement(modalPopUp).click();

        waitForElementToDisappear(modalPopUp);  //wait until popup message is gone

        //step 2. below line is to continue/accept to execute any actual methods of the current class (i.e. "MultiTrip.java" class after the above pre-requisite is done.
        consumer.accept(this);

        //step 3.  below line is the "tear down" (post-requisite) step
        System.out.println("I am done with the test");

    }


    @Override
    public void checkAvailability (HashMap<String, String> originDestination) {

        System.out.println("checkAvailability: this is for Multi Trip");

        makeStateReady(s->selectOriginCity(originDestination.get("origin")));  //call "makeStateReady" method to first execute the pre-requisites, i.e. click the MultiCity radiobutton and click OK on the popup message; then continue to enter the "Origin"

        selectDestinationCity(originDestination.get("destination"));

        selectDestinationCity_2(originDestination.get("destination2"));  //should not be hard-coded "BLR" city. we will use "Hash Map" to take care of this


       // findElement(searchBtn).click();

    }

    //click and enter the 1st "From"
    public void selectOriginCity(String origin)

    {
        findElement(fromEditBox).click();  //click the "From" editbox
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }


    //click and enter the "To"
    public void selectDestinationCity(String dest)
    {

        findElement(toEditBox).click();  //click the "From" editbox
        findElement(By.xpath("(//a[@value='" + dest + "'])[2]")).click();
    }


    //click and enter the 2nd "From"
    public void selectDestinationCity_2(String dest2)
    {

        findElement(fromEditoBox_2).click();  //click the "From" editbox
        findElement(By.xpath("(//a[@value='" + dest2 + "'])[3]")).click();
    }

}
