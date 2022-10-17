package com.bootcamp.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.bootcamp.ui.AddTutorialPage.SUCCESS_MESSAGE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class AddTutorialQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(SUCCESS_MESSAGE, isCurrentlyVisible()).forNoMoreThan(10).seconds());
        return SUCCESS_MESSAGE.resolveFor(actor).getText().contains("Tutorial was submitted successfully!");
    }

    public static Question<Boolean> isTutorialCreated() {
        return new AddTutorialQuestion();
    }

}
