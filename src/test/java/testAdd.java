import Model.Polynomial;
import Controller.Operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testAdd {
    @Test
    public void testAdd1() {
        Polynomial p1 = new Polynomial("x^2+3x^3+4");
        Polynomial p2 = new Polynomial("x^3+x-1");

        Operations op = new Operations();
        Polynomial res = op.add(p1, p2);

        String s = res.toString(res);
        assert(s.equals("4x^3+x^2+x+3"));
    }

    @Test
    public void testAdd2() {
        Polynomial p1 = new Polynomial("x^2+3x^3+4");
        Polynomial p2 = new Polynomial("x^3+x-1");

        Operations op = new Operations();
        Polynomial res = op.add(p1, p2);

        String s = res.toString(res);
        assert(s.equals("4x+5"));
    }
}
