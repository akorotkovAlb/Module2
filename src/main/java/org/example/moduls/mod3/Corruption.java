package org.example.moduls.mod3;

import javax.xml.bind.ValidationException;
import java.util.List;

public class Corruption {

    public double operation(int percent, List<Double> bills) throws ValidationException {
        Validator validator = new Validator();
        validator.percentValidator(percent);
        validator.billsValidator(bills);

        while (bills.size() != 1) {
            workMethod(percent, bills);
        }
        return bills.get(0);
    }

    private void workMethod(int percent, List<Double> bills) {
        Double getFirstValue = getMinValue(bills);
        bills.remove(getFirstValue);
        Double getSecondValue = getMinValue(bills);
        bills.remove(getSecondValue);
        Double result = calculate(percent, getFirstValue, getSecondValue);
        bills.add(result);
    }

    private Double calculate(int percent, Double getFirstValue, Double getSecondValue) {
        Double percentSum = ((getFirstValue + getSecondValue)/100)*percent;
        return getFirstValue + getSecondValue - percentSum;
    }

    private Double getMinValue(List<Double> bills) {
        return bills.stream().mapToDouble(v -> v)
                .min().getAsDouble();
    }
}
