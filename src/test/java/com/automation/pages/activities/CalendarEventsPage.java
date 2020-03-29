package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarEventsPage extends AbstractPageBase {


    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;


    public void clickToCreateCalendarEvent(){

    }
}
