package org.example.moduls.mod3;

import javax.xml.bind.ValidationException;
import java.util.List;

public class Validator {

    public void percentValidator(int percent) throws ValidationException {
        if (percent <= 0) {
            throw new ValidationException("Percent must be more than 0%");
        }
        if (percent >= 100) {
            throw new ValidationException("Do you have a conscience?");
        }
    }

    public void billsValidator(List<Double> bills) throws ValidationException {
        if (bills.isEmpty() || bills.size() == 1) {
            throw new ValidationException("Bills size must be more than 1.");
        }
        for (Double bill : bills) {
            if (bill <= 0) {
                throw new ValidationException("Bill must be more than 0.");
            }
        }
    }
}
