package es.enjoybahia.task.fibonacci.cucumber;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

@Ignore
public class FibonacciStepDefinitions extends SpringIntegrationTest {

    int response = 0;
    String url = DEFAULT_URL + "fibonacci/";

    @Then("the client receives answer as {int}")
    public void the_client_receives_answer_as(int result) {
        assertEquals(result, response);
    }

    @When("the client calls the fibonacci function with value {int}")
    public void the_client_calls_calc_mul_with_values_and(Integer number) {
        response = restTemplate.getForObject(url + number, Integer.class);
    }

}
