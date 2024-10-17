import Model.Polynomial;
import Controller.Operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDivision {
    @Test
    public void testDivision1() {
        Polynomial p1 = new Polynomial("x^2+2x+1");
        Polynomial p2 = new Polynomial("x+1");

        Operations op = new Operations();
        Polynomial res = op.divide(p1, p2);

        String s = res.toString(res);
        assert(s.equals("x+1"));
    }

    @Test
    public void testDivision2() {
        Polynomial p1 = new Polynomial("x^2+3x^3+4");
        Polynomial p2 = new Polynomial("x^3+x-1");

        Operations op = new Operations();
        Polynomial res = op.divide(p1, p2);

        String s = res.toString(res);
        assert(s.equals("4x+5"));
    }
}
