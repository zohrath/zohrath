package symbolic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class AdditionTest {
        Constant con = new Constant(2);
        Addition add = new Addition(con,con);
    @Test
    public void getName() throws Exception {
        assertEquals("+",add.getName());
    }
    //Gör test med variabler
    @Test
    public void eval() throws Exception {

        assertEquals((double)4,add.eval().getValue(),(double)0);

    }

    @Test
    public void getResult() throws Exception {
        assertEquals((double)10,add.getResult((double)5,(double)5),(double)0);
    }
}