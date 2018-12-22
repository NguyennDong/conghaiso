/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class MyBigNumberTest implements IReceiver{

    /**
     * Test of sum method, of class MyBigNumber.
     */
    @Test
    public void testSum1() {
        System.out.println("kiem tra ket qua");
        String s1 = "123";
        String s2 = "987";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "1110";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum2() {
        System.out.println("Dong thu nhat dai hon dong thu hai");
        String s1 = "256";
        String s2 = "36";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "292";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum3() {
        System.out.println("Dong thu hai dai hon dong thu nhat");
        String s1 = "25";
        String s2 = "366458";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "366483";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum4() {
        System.out.println("Dong thu nhat rong");
        String s1 = "";
        String s2 = "36";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "36";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum5() {
        System.out.println("Dong thu hai rong");
        String s1 = "1256";
        String s2 = "";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "1256";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum6() {
        System.out.println("Ca hai dong rong");
        String s1 = "";
        String s2 = "";
        MyBigNumber instance = new MyBigNumber(this);
        String expResult = "0";
        String result = instance.sum(s1, s2);
        assertEquals(expResult, result);
    }
    @Test
    public void testSum7() {
        System.out.println("Dong 1 chua ky tu la chu");
        String s1 = "7f2";
        String s2 = "12";
        MyBigNumber instance = new MyBigNumber(this);
        try {
        String result = instance.sum(s1, s2);
        } catch (Exception e) {
            assertThat(e, instanceOf(NumberFormatException.class));
            assertEquals(e.getMessage(), "2");
        }
    }
    @Test
    public void testSum8() {
        System.out.println("Dong 2 chua ky tu la chu");
        String s1 = "72";
        String s2 = "1t2";
        MyBigNumber instance = new MyBigNumber(this);
        try {
        String result = instance.sum(s1, s2);
        } catch (Exception e) {
            assertThat(e, instanceOf(NumberFormatException.class));
            assertEquals(e.getMessage(), "2");
        }
    }
    @Test
    public void testSum9() throws Exception{
        System.out.println("Dong 1 chua ky tu dac biet");
        String s1 = "7(*2";
        String s2 = "12";
        MyBigNumber instance = new MyBigNumber(this);
        try {
        String result = instance.sum(s1, s2);
        } catch (Exception e) {
            assertThat(e, instanceOf(NumberFormatException.class));
            assertEquals(e.getMessage(), "2");
        }
    }
    @Test
    public void testSum10() throws Exception{
        System.out.println("Dong 2 chua ky tu dac biet");
        String s1 = "72";
        String s2 = "1-2";
        MyBigNumber instance = new MyBigNumber(this);
        try {
        String result = instance.sum(s1, s2);
        } catch (Exception e) {
            assertThat(e, instanceOf(NumberFormatException.class));
            assertEquals(e.getMessage(), "2");
        }
    }
    @Test
    public void testSum11() {
        System.out.println("Dong 1 chua khoang trang");
        String s1 = "7 2";
        String s2 = "12";
        MyBigNumber instance = new MyBigNumber(this);
        try {
        String result = instance.sum(s1, s2);
        } catch (Exception e) {
            assertThat(e, instanceOf(NumberFormatException.class));
            assertEquals(e.getMessage(), "2");
        }
    }
    @Test
    public void testSum12() {
        System.out.println("Dong 2 chua khoang trang");
        String s1 = "72";
        String s2 = "1 2";
        MyBigNumber instance = new MyBigNumber(this);
        try {
        String result = instance.sum(s1, s2);
        } catch (Exception e) {
            assertThat(e, instanceOf(NumberFormatException.class));
            assertEquals(e.getMessage(), "2");
        }
    }

    @Override
    public void send(String msg) {
    }
    
}
