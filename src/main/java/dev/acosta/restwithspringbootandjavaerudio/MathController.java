package dev.acosta.restwithspringbootandjavaerudio;

import dev.acosta.restwithspringbootandjavaerudio.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please enter only numeric values.");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private boolean isNumeric(String userNumber) {
        if (userNumber == null) return false;
        String number = userNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToDouble(String userNumber) {
        if (userNumber == null) return 0D;
        String number = userNumber.replaceAll(",", ".");
        if (isNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 0D;
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtract(@PathVariable(name = "numberOne") String numberOne,
                           @PathVariable(name = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please enter only numeric values.");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    //TODO Multiplication functionality
    //TODO Division functionality
    //TODO Simple average functionality
    //TODO Square root
}
