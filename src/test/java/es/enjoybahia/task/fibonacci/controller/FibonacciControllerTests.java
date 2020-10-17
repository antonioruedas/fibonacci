package es.enjoybahia.task.fibonacci.controller;

import es.enjoybahia.task.fibonacci.exception.BadRequestException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class FibonacciControllerTests {
    @InjectMocks
    private FibonacciController controller;

    private long number;
    private ResponseEntity obtainedFibonacciNumber;
    private long expectedFibonacciNumber;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void gettingFibonacciNumberSuccessfully() throws BadRequestException {
        givenSomeInputToRequestFibonacciNumber();
        whenTheFibonacciNumberIsRequestedWithThatInput();
        thenTheExpectedFibonacciNumberObtained();
    }

    @Test(expected = BadRequestException.class)
    public void gettingInterconnectionsBadRequest() throws BadRequestException {
        givenSomeBadInputToRequestFibonacciNumber();
        whenTheFibonacciNumberIsRequestedWithThatInput();
        thenABadRequestIsObtained();
    }

    private void givenSomeInputToRequestFibonacciNumber() {
        this.number = 5;
        this.expectedFibonacciNumber = 5;
    }

    private void givenSomeBadInputToRequestFibonacciNumber() {
        this.number = -1;
    }

    private void whenTheFibonacciNumberIsRequestedWithThatInput() throws BadRequestException {
        this.obtainedFibonacciNumber = this.controller.getFibonacciNumber(this.number);
    }

    private void thenTheExpectedFibonacciNumberObtained() {
        assertEquals(HttpStatus.OK, this.obtainedFibonacciNumber.getStatusCode());
        assertEquals(expectedFibonacciNumber, (long)this.obtainedFibonacciNumber.getBody());
    }

    private void thenABadRequestIsObtained() {
        assertEquals(HttpStatus.BAD_REQUEST, this.obtainedFibonacciNumber.getStatusCode());
    }
}
