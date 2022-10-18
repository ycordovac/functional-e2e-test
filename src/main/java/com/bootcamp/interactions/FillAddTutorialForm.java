package com.bootcamp.interactions;

import com.bootcamp.ui.AddTutorialPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class FillAddTutorialForm implements Interaction {

    @Override
    @Step("{0} navigate to the form section")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(WaitUntil.the(AddTutorialPage.ADD_TUTORIAL_SECTION_BTN, isCurrentlyVisible()).forNoMoreThan(30).seconds());
        actor.attemptsTo(Click.on(AddTutorialPage.ADD_TUTORIAL_SECTION_BTN));

        actor.attemptsTo(WaitUntil.the(AddTutorialPage.TITLE_FIELD, isCurrentlyVisible()).forNoMoreThan(30).seconds());

        actor.attemptsTo(Enter.theValue("tutorial_test_" + getRandomNumber()).into(AddTutorialPage.TITLE_FIELD));
        actor.attemptsTo(Enter.theValue("This is a automation e2e test").into(AddTutorialPage.DESCRIPTION_FIELD));
        actor.attemptsTo(Click.on(AddTutorialPage.ADD_TUTORIAL_BTN));
    }

    public static FillAddTutorialForm fill() {
        return instrumented(FillAddTutorialForm.class);
    }

    private String getRandomNumber() {
        Random r = new Random();
        int low = 0;
        int high = 999999;
        return String.valueOf(r.nextInt(high - low) + low);
    }


}
