package symbolic;

import static org.junit.Assert.assertEquals;

/**
 * Created by edvin on 3/20/16.
 */
public class JunitTest {

        @org.junit.Test
        public void main() throws Exception {

            //Addition.java
            AdditionTest testAdd = new AdditionTest();
            testAdd.getName();
            testAdd.eval();
            testAdd.getResult();

            //Constant.java
            ConstantTest testConst = new ConstantTest();
            testConst.getName();
            testConst.getConstant();

            //Division.java
            DivisionTest testDiv = new DivisionTest();
            testDiv.getName();
            testDiv.eval();
            testDiv.getResult();

        }


}
