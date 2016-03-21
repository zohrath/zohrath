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
            testConst.eval();
            testConst.getConstant();

            //Division.java
            DivisionTest testDiv = new DivisionTest();
            testDiv.getName();
            testDiv.eval();
            testDiv.getResult();

            //Multiplication.java
            MultiplicationTest testMult = new MultiplicationTest();
            testMult.getName();
            testMult.eval();
            testMult.getResult();

            //Negation.java
            NegationTest testNeg    = new NegationTest();
            testNeg.getName();
            testNeg.eval();
            testNeg.getResult();

            //Sin.java
            SinTest testSin = new SinTest();
            testSin.getName();
            testSin.eval();
            testSin.getResult();
        }


}
