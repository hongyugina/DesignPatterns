package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;

public class FooterNavigation extends AbstractComponent {

    WebDriver driver;

    /*
     * when Selenium executes any method in this class, the scope of selenium should be
     * in the Footer of the webpage Only
     */


    By flights = By.cssSelector("[title='Flights']");  //declare the "Flights" locator //declare the "Flights" locator
    By links = By.cssSelector("a");


    //constructor
    public FooterNavigation(WebDriver driver, By footerSectionElement) {
        super(driver,footerSectionElement);
    }


    //method to return the "flights"
    public String getFlightAttribute()

    {

        //driver.findElement(flights).click();  //this line will return the 1st occurrence of "Flights" found, i.e. Flights from Header instead of Footer
        //findElement(flights).click();  //call "findElement" method from parent class, "AbstractComponent".java"

        //System.out.println(findElement(flights).getAttribute("class"));
        return findElement(flights).getAttribute("class");


    }


    public int getLinkCount()
    {

       return findElements(links).size(); //return links count on the footer

    }

}
