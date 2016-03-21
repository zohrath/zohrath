package symbolic;

import static org.junit.Assert.assertEquals;

/**
 * Created by edvin on 3/20/16.
 */
public class JunitTest {

        @org.junit.Test
        public void main() throws Exception {

            //Constant.java
            ConstantTest testConst = new ConstantTest();
            testConst.getName();
            testConst.getConstant();

            //
        }


}
