package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarEventsPage extends AbstractPageBase {


    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;


    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(15);
        //wait for element to be present in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
    }

    public String getStartDate(){
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtils.scrollTo(startDate);
        return startDate.getAttribute("value");
    }
}
