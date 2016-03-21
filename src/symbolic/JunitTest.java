package symbolic;

import static org.junit.Assert.assertEquals;

/**
 * Created by edvin on 3/20/16.
 */
public class JunitTest {

        public void main() throws Exception {

            TestingAddition();
            TestingConstant();
            TestingCos();
            TestingDivision();
            TestingExp();
            TestingLog();
            TestingMultiplikation();
            TestingNegation();
            TestingQuit();
            TestingSin();
            TestingSubtraction();
        }

        @org.junit.Test
        public void TestingAddition() throws Exception {
            AdditionTest testAdd = new AdditionTest();
            testAdd.getName();
            testAdd.eval();
            testAdd.getResult();
        }

        @org.junit.Test
        public void TestingConstant() throws Exception {
            ConstantTest testConst = new ConstantTest();
            testConst.getName();
            testConst.eval();
            testConst.getConstant();
        }

        @org.junit.Test
        public void TestingCos() throws Exception{
            CosTest testCos = new CosTest();
            testCos.getName();
            testCos.eval();
            testCos.getResult();
        }

        @org.junit.Test
        public void TestingDivision() throws Exception {
            DivisionTest testDiv = new DivisionTest();
            testDiv.getName();
            testDiv.eval();
            testDiv.getResult();
        }

        @org.junit.Test
        public void TestingExp() throws Exception {
            ExpTest testExp = new ExpTest();
            testExp.getName();
            testExp.eval();
            testExp.getResult();
        }

        @org.junit.Test
        public void TestingLog() throws Exception{
            LogTest testLog = new LogTest();
            testLog.getName();
            testLog.eval();
            testLog.getResult();
        }

        @org.junit.Test
        public void TestingMultiplikation() throws Exception {
            MultiplicationTest testMult = new MultiplicationTest();
            testMult.getName();
            testMult.eval();
            testMult.getResult();
        }

        @org.junit.Test
        public void TestingNegation() throws Exception {
            NegationTest testNeg = new NegationTest();
            testNeg.getName();
            testNeg.eval();
            testNeg.getResult();
        }

        @org.junit.Test
        public void TestingQuit() throws Exception {
            QuitTest testQuit = new QuitTest();
            testQuit.getName();
        }

        @org.junit.Test
        public void TestingSin() throws Exception {
            SinTest testSin = new SinTest();
            testSin.getName();
            testSin.eval();
            testSin.getResult();
        }

        @org.junit.Test
        public void TestingSubtraction() throws Exception{
            SubtractionTest testSub = new SubtractionTest();
            testSub.getName();
            testSub.eval();
            testSub.getResult();
        }




}
