package Model;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.TreeMap;


public class Polynomial {
    public TreeMap<Integer, Monomial> polynomial;
    public void addTermToMap(Monomial monomial){
        if (monomial == null) {
            return;
        }

        int degree = monomial.getDegree();

        //if the coefficient already exists
        if (polynomial.containsKey(degree)) {
            Monomial existingMonomial = polynomial.get(degree);
            double newCoefficient = existingMonomial.getCoefficient().doubleValue() + monomial.getCoefficient().doubleValue();
            existingMonomial.setCoefficient(newCoefficient);
        } else {
            polynomial.put(degree, monomial);
        }
    }

    public Polynomial(String input) {
        //descending order of power
        this.polynomial= new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));

        //define the pattern to extract terms from the input string
        Pattern termPattern = Pattern.compile("([+\\-]?)(\\d*)(x(\\^(\\d+))?)?");
        Matcher matcher = termPattern.matcher(input);

        //extracting components
        while (matcher.find()) {
            String signStr = matcher.group(1);              //for the sign - optional ([+\\-]?)
            String coefficientStr = matcher.group(2);       //the coefficient of the term - optional (\\d*)
            String hasX = matcher.group(3);                 //contains x or not - optional (x(\\^(\\d+))?)
            //subgroup 4                                    //has an exponent (\\^(\\d+))
            String powerStr = matcher.group(5);             //if x has an exponent or its 1 (\\d+)

            double coefficient = parseCoefficient(coefficientStr, hasX, signStr);
            int power = parsePower(hasX, powerStr);
            Monomial monomial = new Monomial(power, coefficient);
            addTermToMap(monomial);
        }

    }


    private static double parseCoefficient(String coefficientStr, String hasX, String signStr) {
        if (coefficientStr == null || coefficientStr.isEmpty()) {
            if (hasX != null) {
                if (signStr != null && signStr.equals("-")) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        } else {
            String sign;
            if (signStr != null && signStr.equals("-")) {
                sign = signStr;
            } else {
                sign = "";
            }

        String combinedStr = sign + coefficientStr;
        return Double.parseDouble(combinedStr);
    }
    }


    private static int parsePower(String hasX, String powerStr) {
        int power;
        if (hasX != null) {
            //parse power from string
            if (powerStr != null && !powerStr.isEmpty()) {
                power = Integer.parseInt(powerStr);
            } else {
                power = 1;
            }
        } else {
            if (powerStr != null && !powerStr.isEmpty()) {
                power = Integer.parseInt(powerStr);
            } else {
                power = 0;
            }
        }
        return power;
    }


    public String toString(Polynomial p) {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Map.Entry<Integer, Monomial> entry : p.polynomial.entrySet()) {
            int power = entry.getKey();
            double coefficient = (double) entry.getValue().getCoefficient();

            // skip the terms with coefficient = 0
            if (coefficient == 0) {
                continue;
            }

            // append the sign
            if (!first) {
                if (coefficient > 0) {
                    result.append("+");
                } else {
                    result.append("-");
                }
            } else if (coefficient < 0) {
                result.append("-");
            }

            appendCoefficient(result, coefficient, power);
            appendPower(result, power);

            first = false;
        }
        // if empty
        if (result.length() == 0) {
            return "0";
        }

        return result.toString();
    }

    private void appendCoefficient(StringBuilder result, double coefficient, double power) {
        //for showing the result with 2 decimals
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if(power > 0) {
            if (Math.abs(coefficient) != 1) {
                //if the coefficient is int display as int else display as double .2f
                if (Math.floor(coefficient) == coefficient) {
                    result.append(Math.abs((int) coefficient));
                } else {
                    result.append(decimalFormat.format(Math.abs(coefficient)));
                }
            }
        }else{
            if (Math.floor(coefficient) == coefficient) {
                result.append(Math.abs((int) coefficient));
            } else {
                result.append(decimalFormat.format(Math.abs(coefficient)));
            }
        }
    }

    private void appendPower(StringBuilder result, int power) {
        //if x has a power greater than 0
        if (power > 0) {
            result.append("x");
            //if the power is 1 don't write it, if it's greater append ^power
            if (power > 1) {
                result.append("^").append(power);
            }
        }
    }

}
