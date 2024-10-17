package Model;

public class Monomial {
    private int degree;
    private Number coefficient;

    public Monomial(int degree, Number coefficient) {
        this.degree = degree;
        this.coefficient = coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public Number getCoefficient() {
        return coefficient;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setCoefficient(Number coefficient) {
        this.coefficient = coefficient;
    }

    public String toString() {
        return "Monomial{" +
                "degree=" + degree +
                ", coefficient=" + coefficient +
                '}';
    }
}
