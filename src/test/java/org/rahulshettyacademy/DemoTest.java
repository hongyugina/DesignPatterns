package org.rahulshettyacademy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rahulshettyacademy.PageComponents.MultiTrip;
import org.rahulshettyacademy.PageComponents.RoundTrip;
import org.rahulshettyacademy.PageObjects.TravelHomePage;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest {


    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setup()

    {
        driver = initDriver();  //initialize the driver before running actual test
        driver.manage().window().maximize();
        //create an object of the "TraveHomePage" class
        travelHomePage = new TravelHomePage(driver);
    }

    @AfterTest

    public void tearDown()
    {
        driver.quit();
    }


   // By bookingSection =By.id("flightSearchContainer");   not a good practice to put this line here. we'll use factory design later to fix this.

    @Test(dataProvider = "getData")
    public void flightTest( HashMap<String,String> originDestination)
    {


        travelHomePage.launchURL();

        System.out.println(travelHomePage.getFooterNavigation().getFlightAttribute());

        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());

        System.out.println(travelHomePage.getFooterNavigation().getLinkCount());

        System.out.println(travelHomePage.getNavigationBar().getLinkCount());

        //System.out.println(travelHomePage.getTitle());


       travelHomePage.tripBooking("multitrip"); //create an object for MultiTrip
       //travelHomePage.tripBooking("roundtrip"); //create an object for Round Trip
       travelHomePage.checkAvail(originDestination);  //capture user entered origin and destination


    }


    @DataProvider
    public Object[][] getData() throws IOException {

        /*
        HashMap<String,String> originDestination = new HashMap<String,String>();
        originDestination.put("origin","MAA");
        originDestination.put("destination", "HYD");
        originDestination.put("destination2", "DEL");


        HashMap<String,String> originDestination2 = new HashMap<String,String>();
        originDestination2.put("origin","DEL");
        originDestination2.put("destination", "HYD");
        originDestination2.put("destination2", "MAA");


        List< HashMap<String,String>>  lst = new ArrayList();
        lst.add(originDestination);
        lst.add(originDestination2);

        */


        String base_dir = System.getProperty("user.dir");

        //List< HashMap<String,String>>  lst = getJsonData(base_dir + "//src//test//java//org//rahulshettyacademy//data//originDest.json");  //call the "getJsonData()" method from BaseTest.java parent class to convert the Json Content/String into a List of Hash Maps
        List< HashMap<String,String>>  lst = getJsonData(base_dir + "//src//test//java//org//rahulshettyacademy//data//originDest.json");  //call the "getJsonData()" method from BaseTest.java parent class to convert the Json Content/String into a List of Hash Maps


        return new Object[][]
                {
                     // {originDestination}, {originDestination2}

                        {lst.get(0)}, {lst.get(1)}   //two sets of data
                };
    }

}
