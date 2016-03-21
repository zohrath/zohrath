package symbolic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by edvin on 3/20/16.
 */
public class MultiplicationTest {


    Constant conupp = new Constant(1337);
    Constant conner = new Constant(10);
    Multiplication mult = new Multiplication(conupp,conner);

    @Test
    public void getName() throws Exception {
        assertEquals("*",mult.getName());
    }
    //Testa med variabler
    @Test
    public void eval() throws Exception {
        assertEquals(13370, mult.eval().getValue(),0);
    }

    @Test
    public void getResult() throws Exception {
        assertEquals(13370, mult.getResult(conupp.getValue(),conner.getValue()),0);
    }
}