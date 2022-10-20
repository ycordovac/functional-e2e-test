package com.bootcamp.tasks;

import com.bootcamp.interactions.FillAddTutorialForm;
import com.bootcamp.ui.AddTutorialPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddTutorial implements Task {

    private AddTutorialPage addTutorialPage;

    @Override
    @Step("{0} navigate to the form section")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.relativeUrl("http://angular-14-app.default:80"));
        actor.attemptsTo(FillAddTutorialForm.fill());
    }

    public static AddTutorial createTutorial() {
        return instrumented(AddTutorial.class);
    }


}
