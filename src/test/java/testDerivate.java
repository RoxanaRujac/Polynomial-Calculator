import Model.Polynomial;
import Controller.Operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDerivate{
    @Test
    public void testDrv1() {
        Polynomial p1 = new Polynomial("x^2+3x^3+4");
        Operations op = new Operations();

        Polynomial res = op.derivate(p1);
        String s = res.toString(res);

        assert(s.equals("9x^2+2x"));
    }

    @Test
    public void testDrv2() {
        Polynomial p1 = new Polynomial("x^2+3x^3+4");
        Operations op = new Operations();

        Polynomial res = op.derivate(p1);

        String s = res.toString(res);
        assert(s.equals("4x+5"));
    }
}
