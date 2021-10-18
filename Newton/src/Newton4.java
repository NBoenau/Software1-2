import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static double sqrt(double x, double userEp) {

        double sqrtCalc = x;
        double num = 0;

        if (x == 0) {
            return 0;
        }

        while ((Math.abs(Math.pow(num, 2) - x) / x > Math.pow(userEp, 2))) {
            num = sqrtCalc;
            sqrtCalc = (num + x / num) / 2;
        }
        return sqrtCalc;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.println("Would you like to calculate a square root? (y/n)");
        String userAns = in.nextLine();
        boolean isPositive = true;
        if (userAns.equals("n")) {
            isPositive = false;
        } else {
            isPositive = true;
        }

        while (isPositive) {
            out.print("Please enter a value: ");
            double userNum = in.nextDouble();

            if (userNum < 0) {
                isPositive = false;
                break;
            }
            out.print("Enter value for ε");
            double userEp = in.nextDouble();

            out.println("The square root of " + userNum + " is: "
                    + sqrt(userNum, userEp));

            out.println("Would you like to calculate a square root? (y/n)");
            userAns = in.nextLine();
            isPositive = true;
            if (userAns.equals("n")) {
                isPositive = false;
            } else {
                isPositive = true;
            }
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
