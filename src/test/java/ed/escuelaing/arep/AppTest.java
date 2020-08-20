package ed.escuelaing.arep;

import ed.escuelaing.arep.calculator.Calculator;
import ed.escuelaing.arep.resources.LinkedList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
      public void proxySize (){
        LinkedList dataTest = new LinkedList();
        Calculator calculus = new Calculator();

        dataTest.insertTail(160);
        dataTest.insertTail(591);
        dataTest.insertTail(114);
        dataTest.insertTail(229);
        dataTest.insertTail(230);
        dataTest.insertTail(270);
        dataTest.insertTail(128);
        dataTest.insertTail(1657);
        dataTest.insertTail(624);
        dataTest.insertTail(1503);

        double mean = calculus.mean (dataTest);
        double std = calculus.standardDev(dataTest);

        assertEquals(550.6, mean, 0);
        assertEquals(572.03, std, 0);
    }

    @Test
    public void developmentHours (){
        LinkedList dataTest = new LinkedList();
        Calculator calculus = new Calculator();

        dataTest.insertTail(15.0);
        dataTest.insertTail(69.9);
        dataTest.insertTail(6.5);
        dataTest.insertTail(22.4);
        dataTest.insertTail(28.4);
        dataTest.insertTail(65.9);
        dataTest.insertTail(19.4);
        dataTest.insertTail(198.7);
        dataTest.insertTail(38.8);
        dataTest.insertTail(138.2);

        double mean = calculus.mean (dataTest);
        double std = calculus.standardDev(dataTest);

        assertEquals(60.32, mean, 0);
        assertEquals(62.26, std, 0);
    }

    @Test
    public void example (){
        LinkedList dataTest = new LinkedList();
        Calculator calculus = new Calculator();

        dataTest.insertTail(186);
        dataTest.insertTail(699);
        dataTest.insertTail(132);
        dataTest.insertTail(272);
        dataTest.insertTail(291);
        dataTest.insertTail(331);
        dataTest.insertTail(199);
        dataTest.insertTail(1890);
        dataTest.insertTail(788);
        dataTest.insertTail(1601);

        double mean = calculus.mean (dataTest);
        double std = calculus.standardDev(dataTest);

        assertEquals(638.9, mean, 0);
        assertEquals(625.63, std, 0);
    }

    @Test
    public void aditional (){
        LinkedList dataTest = new LinkedList();
        Calculator calculus = new Calculator();

        dataTest.insertTail(4.5);
        dataTest.insertTail(12);
        dataTest.insertTail(16);
        dataTest.insertTail(138.6);
        dataTest.insertTail(98);
        dataTest.insertTail(116.5);
        dataTest.insertTail(48.9);
        dataTest.insertTail(64);
        dataTest.insertTail(91);
        dataTest.insertTail(84.3);

        double mean = calculus.mean (dataTest);
        double std = calculus.standardDev(dataTest);

        assertEquals(67.38, mean, 0);
        assertEquals(46.28, std, 0);
    }
}