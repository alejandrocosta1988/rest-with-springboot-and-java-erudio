package dev.acosta.restwithspringbootandjavaerudio;

import dev.acosta.restwithspringbootandjavaerudio.basicmath.SimpleMath;
import dev.acosta.restwithspringbootandjavaerudio.exceptions.UnsupportedMathOperationException;
import dev.acosta.restwithspringbootandjavaerudio.util.UserInputCheck;
import dev.acosta.restwithspringbootandjavaerudio.util.UserInputConvertion;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!UserInputCheck.isNumeric(numberOne) || !UserInputCheck.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please enter only numeric values.");
        }
        return math.sum(UserInputConvertion.convertNumericInputToDouble(numberOne), UserInputConvertion.convertNumericInputToDouble(numberTwo));
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtract(@PathVariable(name = "numberOne") String numberOne,
                           @PathVariable(name = "numberTwo") String numberTwo) throws Exception {
        if (!UserInputCheck.isNumeric(numberOne) || !UserInputCheck.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please enter only numeric values.");
        }
        return UserInputConvertion.convertNumericInputToDouble(numberOne) - UserInputConvertion.convertNumericInputToDouble(numberTwo);
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiply(@PathVariable(name = "numberOne") String numberOne,
                           @PathVariable(name = "numberTwo") String numberTwo) throws Exception {
        if (!UserInputCheck.isNumeric(numberOne) || !UserInputCheck.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please enter only numeric values.");
        }
        return UserInputConvertion.convertNumericInputToDouble(numberOne) * UserInputConvertion.convertNumericInputToDouble(numberTwo);
    }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divide(@PathVariable(name = "numberOne") String numberOne,
                       @PathVariable(name = "numberTwo") String numberTwo) throws Exception {
        if (!UserInputCheck.isNumeric(numberOne) || !UserInputCheck.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please enter only numeric values.");
        }
        return UserInputConvertion.convertNumericInputToDouble(numberOne) / UserInputConvertion.convertNumericInputToDouble(numberTwo);
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable(name = "numberOne") String numberOne,
                          @PathVariable(name = "numberTwo") String numberTwo) throws Exception {
        if (!UserInputCheck.isNumeric(numberOne) || !UserInputCheck.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please enter only numeric values.");
        }
        return ( UserInputConvertion.convertNumericInputToDouble(numberOne) + UserInputConvertion.convertNumericInputToDouble(numberTwo) ) / 2;
    }

    @RequestMapping(value = "/square-root/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(name = "number") String number) throws Exception {
        if (!UserInputCheck.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please enter only numeric values.");
        }
        return Math.sqrt(UserInputConvertion.convertNumericInputToDouble(number));
    }
}
