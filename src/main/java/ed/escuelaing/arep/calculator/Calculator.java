package ed.escuelaing.arep.calculator;
import ed.escuelaing.arep.resources.*;

/**
 * Class that does the mean and standard deviation of a group of data
 * @author Maria Hernandez
 */
public class Calculator {

    public Calculator() {
    }

    /**
     * Method that does the mean of a group of data
     * @param list List that will be operate
     * @return double mean of the list
     */
    public double mean(LinkedList list) {
        double mean = 0;
        mean = list.sumList() / list.size();
        return (double)Math.round(mean * 100d) / 100d;
    }

    /**
     * Method that does the standard deviation of a group of data
     * @param list List that will be operate
     * @return double standard deviation
     */
    public double standardDev(LinkedList list) {
        mean (list);
        double size = list.size() - 1;
        double ans = Math.sqrt(list.sumDev()/size);
        return (double)Math.round(ans * 100d) / 100d;
    }
}