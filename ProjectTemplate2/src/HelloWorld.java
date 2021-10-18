import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class MonteCarlo {

    private MonteCarlo() {
    }

    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        double yValue = Math.sqrt(((-1) * (Math.pow(xCoord, 2))) + (2 * xCoord))
                + 1;
        if (yCoord < yValue && yCoord > 2 - yValue) {
            return true;
        } else {
            return false;
        }
    }

    private static int numberOfPointsInCircle(int n) {
        int count = 0;
        int whileCount = 0;
        while (whileCount < n) {
            whileCount++;
            double x = Math.random() * (2);
            double y = Math.random() * (2);
            if (MonteCarlo.pointIsInCircle(x, y)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        /*
         * Ask user for number of points to generate
         */
        output.print("Number of points: ");
        int n = input.nextInteger();

        int numOfPoints = numberOfPointsInCircle(n);

        double estimate = (100.0 * numOfPoints) / n;
        output.println("Estimate of percentage: " + estimate + "%");
        input.close();
        output.close();
    }

}
