package es.enjoybahia.task.fibonacci.controller;

import es.enjoybahia.task.fibonacci.algorithm.Fibonacci;
import es.enjoybahia.task.fibonacci.exception.BadRequestException;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@Api
@SwaggerDefinition(
        info = @Info(
                description = "The Fibonacci API computes the fibonacci function given a number.",
                version = "V2.0",
                title = "Fibonacci API"))
@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciController.class);

    @ApiOperation(value = "Compute the fibonacci number of a given number.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, response = Long.class, message = "The request has been correctly computed."),
            @ApiResponse(code = 400, message = "Bad request. An informative message is returned.")
    })
    @GetMapping(path="/{n}", produces = "application/json")
    public ResponseEntity<Long> getFibonacciNumber(@PathVariable final long n) throws BadRequestException {
        validateRequest(n);
        long fibonacci = Fibonacci.compute(n);
        LOGGER.info(String.format("fibonacci(%s)=%s", n, fibonacci));
        return ok(fibonacci);
    }

    private void validateRequest(final long n) throws BadRequestException {
        if (n < 0) {
            String msg = "n must be greater than or equal to zero.";
            LOGGER.warn(msg);
            throw new BadRequestException(msg);
        }
    }
}
