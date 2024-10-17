package Controller;

import Model.Monomial;
import Model.Polynomial;

import java.util.Map;
import java.util.TreeMap;

public class Operations {

    public Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial("");

        //adding the terms from the first polynomial
        for (Map.Entry<Integer, Monomial> entry : p1.polynomial.entrySet()) {
            Monomial monomial = entry.getValue();
            result.addTermToMap(new Monomial(monomial.getDegree(), monomial.getCoefficient()));
        }

        //adding the terms from second polynomial
        for (Map.Entry<Integer, Monomial> entry : p2.polynomial.entrySet()) {
            Monomial monomial = entry.getValue();
            int degree = monomial.getDegree();
            double coefficient = (double) monomial.getCoefficient();

            if (result.polynomial.containsKey(degree)) {
                double newCoefficient = (double) result.polynomial.get(degree).getCoefficient() + coefficient;
                if (newCoefficient == 0) {
                    // if the monomial is reduced
                    result.polynomial.remove(degree);
                } else {
                    // else update the coefficient
                    result.polynomial.get(degree).setCoefficient(newCoefficient);
                }
            } else {
                // if the new monomial isn't in the result already we add it with a + sign
                result.addTermToMap(new Monomial(degree, coefficient));
            }
        }

        return result;
    }


    public Polynomial subtract(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial("");

        //adding the terms from the first polynomial
        for (Map.Entry<Integer, Monomial> entry : p1.polynomial.entrySet()) {
            Monomial monomial = entry.getValue();
            result.addTermToMap(new Monomial(monomial.getDegree(), monomial.getCoefficient()));
        }

        //substracting terms from second polynomial
        for (Map.Entry<Integer, Monomial> entry : p2.polynomial.entrySet()) {
            Monomial monomial = entry.getValue();
            int degree = monomial.getDegree();
            double coefficient = (double) monomial.getCoefficient();

            if (result.polynomial.containsKey(degree)) {
                double newCoefficient = (double) result.polynomial.get(degree).getCoefficient() - coefficient;
                if (newCoefficient == 0) {
                    // if the monomial is reduced
                    result.polynomial.remove(degree);
                } else {
                    // else update the coefficient
                    result.polynomial.get(degree).setCoefficient(newCoefficient);
                }
            } else {
                // if the new monomial isn't in the result already we add it with a - sign
                result.addTermToMap(new Monomial(degree, -coefficient));
            }
        }
        return result;
    }


    public Polynomial multiply(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial("");
        //iterate through each term of the first polynomial and second polynomial
        for (Map.Entry<Integer, Monomial> entry : p1.polynomial.entrySet()) {
            for (Map.Entry<Integer, Monomial> entry2 : p2.polynomial.entrySet()) {

                Monomial monomial1 = entry.getValue();
                Monomial monomial2 = entry2.getValue();
                //calculate the degree and coefficient of the product
                int degree = monomial1.getDegree() + monomial2.getDegree();
                double coefficient = (double) monomial1.getCoefficient() * (double) monomial2.getCoefficient();

                if (coefficient != 0)
                    result.addTermToMap(new Monomial(degree, coefficient));
            }

        }

        return result;
    }

    

    public Polynomial divide(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial("");
        Polynomial remainder = new Polynomial(p1.toString());

        //if divisor polynomial is zero -> error
        if (p2.polynomial.isEmpty() || p2.polynomial.get(0).getCoefficient().doubleValue() == 0) {
            System.err.println("Cannot divide by zero");
            return null;
        }

        //long division
        while (!p1.polynomial.isEmpty() && p1.polynomial.firstEntry().getValue().getDegree() >= p2.polynomial.firstEntry().getValue().getDegree()) {
           remainder.polynomial.clear();

           //calculate the new degree and coefficient
            int newDegree = p1.polynomial.firstKey() -  p2.polynomial.firstKey();
            double newCoefficient = (double) p1.polynomial.firstEntry().getValue().getCoefficient() / (double) p2.polynomial.firstEntry().getValue().getCoefficient();

            result.addTermToMap(new Monomial(newDegree, newCoefficient));

            //multiply the result with p2 and substract from p1
            for (Integer degree : p2.polynomial.keySet()){
                double coef= (double) p2.polynomial.get(degree).getCoefficient();
                remainder.addTermToMap(new Monomial(newDegree+degree,newCoefficient*coef));
            }
            p1 = subtract(p1, remainder);
            System.out.println(p1.toString(p1));
        }
        return result;
    }



    public Polynomial derivate(Polynomial polynomial) {
        Polynomial result = new Polynomial("");
        for (Map.Entry<Integer, Monomial> entry : polynomial.polynomial.entrySet()) {
            Monomial monomial = entry.getValue();
            int degree = monomial.getDegree();
            double coefficient = (double) monomial.getCoefficient();

            //derivate each term
            if (Math.abs(degree * coefficient) >= 1) {
                result.addTermToMap(new Monomial(degree - 1, coefficient * degree));
            }
        }
        return result;
    }


    public Polynomial integrate(Polynomial polynomial){
        Polynomial result = new Polynomial("");
        for (Map.Entry<Integer, Monomial> entry : polynomial.polynomial.entrySet()) {
            Monomial monomial = entry.getValue();
            int degree = monomial.getDegree();
            double coefficient = (double) monomial.getCoefficient();

            //integrate each term
            if (degree >= 0) {
                result.addTermToMap(new Monomial(degree + 1, coefficient / (degree + 1)));
            }
        }
        return result;
    }

}
