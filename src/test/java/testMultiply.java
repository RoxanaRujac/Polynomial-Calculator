import Model.Polynomial;
import Controller.Operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMultiply {
    @Test
    public void testMultipy1() {
        Polynomial p1 = new Polynomial("x^2+3x^3+4");
        Polynomial p2 = new Polynomial("x^3+x-1");

        Operations op = new Operations();
        Polynomial res = op.multiply(p1, p2);

        String s = res.toString(res);
        assert(s.equals("3x^6+x^5+3x^4+2x^3-x^2+4x-4"));
    }

    @Test
    public void testMultiply2() {
        Polynomial p1 = new Polynomial("x^2+3x^3+4");
        Polynomial p2 = new Polynomial("x^3+x-1");

        Operations op = new Operations();
        Polynomial res = op.multiply(p1, p2);

        String s = res.toString(res);
        assert(s.equals("4x+5"));
    }
}
