package com.bootcamp.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class AddTutorialPage extends PageObject {

    public static final Target ADD_TUTORIAL_SECTION_BTN = Target.the("Go to add tutorial section").locatedBy("/html/body/app-root/div/nav/div/li[2]");

    public static final Target TITLE_FIELD = Target.the("Title field to create tutorial").locatedBy("#title");

    public static final Target DESCRIPTION_FIELD = Target.the("Title field to create tutorial").locatedBy("#description");

    public static final Target ADD_TUTORIAL_BTN = Target.the("Button to persist the tutorial data").locatedBy("/html/body/app-root/div/div/app-add-tutorial/div/div/div/button");

    public static final Target SUCCESS_MESSAGE = Target.the("Success Message after submit correctly the form data").locatedBy("/html/body/app-root/div/div/app-add-tutorial/div/div/div/h4");

}
