package symbolic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class DivisionTest {

    Constant conupp = new Constant(1337);
    Constant conner = new Constant(10);
    Division div = new Division(conupp,conner);

    @Test
    public void getName() throws Exception {
        assertEquals("/",div.getName());
    }
    //testa med variabler
    @Test
    public void eval() throws Exception {
        assertEquals(133.7,div.eval().getValue(),0.1);
    }

    @Test
    public void getResult() throws Exception {
        assertEquals(133.7,div.getResult(1337,10),0.1);
    }
}