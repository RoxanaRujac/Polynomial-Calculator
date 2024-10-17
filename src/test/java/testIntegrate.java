import Model.Polynomial;
import Controller.Operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testIntegrate{
    @Test
    public void testIntg1() {
        Polynomial p1 = new Polynomial("x^2+3x^3+4");
        Operations op = new Operations();

        Polynomial res = op.integrate(p1);
        String s = res.toString(res);

        assert(s.equals("0.75x^4+0.33x^3+4x"));
    }

    @Test
    public void testIntg2() {
        Polynomial p1 = new Polynomial("x^2+3x^3+4");
        Operations op = new Operations();

        Polynomial res = op.integrate(p1);

        String s = res.toString(res);
        assert(s.equals("4x+5"));
    }
}
