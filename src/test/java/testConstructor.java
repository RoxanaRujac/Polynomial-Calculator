
import Model.Polynomial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testConstructor {
    @Test
    public void constructorTest1(){
        Polynomial p1 = new Polynomial("x^3+3x^2-10");
        String s1 = p1.toString(p1);
        assert(s1.equals("x^3+3x^2-10"));
    }

    @Test
    public void constructorTest2(){
        Polynomial p1 = new Polynomial("x^3+3x^2-10");
        String s1 = p1.toString(p1);
        assert(s1.equals("x^3+3x^2+12"));
    }
}