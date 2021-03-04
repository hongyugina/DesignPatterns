package org.rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractComponent {


    WebElement sectionElement;
    WebDriver driver;



    public AbstractComponent(WebDriver driver, By sectionElement) {

    // the specific section element locator (e.g. Header section element, Footer section Element,Booking section element

        this.driver = driver;

        this.sectionElement =  driver.findElement(sectionElement);

    }

    public WebElement findElement( By element)
    {


        return sectionElement.findElement(element);  //return a locator specified by the "element" parameter.

    }

    public List<WebElement> findElements(By element)
    {
        return sectionElement.findElements(element);
    }


    public void waitForElementToDisappear(By findBy)
    {

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));

    }

    public void waitForElementToBeSelected(By findBy)
    {

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.elementToBeSelected(findBy));

    }



}
