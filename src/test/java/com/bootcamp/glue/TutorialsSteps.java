package com.bootcamp.glue;

import com.bootcamp.questions.AddTutorialQuestion;
import com.bootcamp.tasks.AddTutorial;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class TutorialsSteps {

    @Given("^(Antonio) wants to create a new tutorial$")
    public void antonioWantsToCreateANewTutorial(String actorName) {
        theActorCalled(actorName);
    }

    @When("Antonio create a new tutorial")
    public void antonioCreateANewTutorial() {
        theActorInTheSpotlight().attemptsTo(
                AddTutorial.createTutorial()
        );
    }

    @Then("The tutorial requested should be create")
    public void theTutorialRequestedShouldBeCreate() {
        theActorInTheSpotlight().should(
                seeThat(
                        "The page show the correct message",
                        AddTutorialQuestion.isTutorialCreated(),
                        equalTo(true)
                )
        );
    }
}
