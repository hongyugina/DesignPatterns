package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;

public class NavigationBar extends AbstractComponent {



    By flights = By.cssSelector("[title='Flights']");  //declare the "Flights" locator

    By links = By.cssSelector("a");  //links locator on Header

    public NavigationBar(WebDriver driver, By headerSectionElement) {

        super(driver,headerSectionElement);

    }


    //method to return the "flights"
    public String getFlightAttribute()

    {

        //driver.findElement(flights).click();  //this line will return the Flights from Header instead of Footer
        //findElement(flights).click();  //call "findElement" method from parent class, "AbstractComponent".java"

       // System.out.println(findElement(flights).getAttribute("class"));
        return findElement(flights).getAttribute("class");

    }

    public int getLinkCount()

    {

        //driver.findElement(flights).click();  //this line will return the Flights from Header instead of Footer
        //findElement(flights).click();  //call "findElement" method from parent class, "AbstractComponent".java"

       // System.out.println(findElements(links).size());
        return findElements(links).size();

    }

}
