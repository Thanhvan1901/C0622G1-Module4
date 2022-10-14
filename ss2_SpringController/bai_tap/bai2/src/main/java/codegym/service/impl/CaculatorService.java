package codegym.service.impl;

import codegym.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {
    @Override
    public String caculator(String num1, String num2, String operator) {
        try {
            double result = 0;
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            switch (operator) {
                case "Addition":
                    result = number1 + number2;
                    break;
                case "Subtraction":
                    result = number1 - number2;
                    break;
                case "Multiplication":
                    result = number1 * number2;
                    break;
                case "Division":
                    if (number2 == 0) {
                        return "Cannot be divided by 0 !!!";
                    } else {
                        result = number1 / number2;
                        break;
                    }
            }
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "Please enter number !!!";
        }
    }
}
