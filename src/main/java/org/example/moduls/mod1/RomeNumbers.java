package org.example.moduls.mod1;

import java.util.List;

public class RomeNumbers {
    public String arabicToRome(Integer number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public int romeToArabic(String input) {
        String romeValue = input.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanList = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while (romeValue.length() > 0) {
            RomanNumeral symbol = romanList.get(i);
            if (romeValue.startsWith(symbol.name())) {
                result += symbol.getValue();
                romeValue = romeValue.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romeValue.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }
}
