import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Calculates the w, x, y, and z of de Jager's formula.
 *
 * @author Nick Boenau
 *
 */

public final class ABCDGuesser1 {
    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        /**
         * Repeats prompt until user successfully enters a a positive, real
         * number for μ
         */
        boolean valueNotEntered = true;
        double userUVal = 0;

        while (valueNotEntered) {
            out.println("Please input a positive, real number for μ");
            String userUInput = in.nextLine();

            if (FormatChecker.canParseDouble(userUInput)) {
                userUVal = Double.parseDouble(userUInput);
                if (userUVal <= 0) {
                    out.println(
                            "Input invalid, please enter a positive, real number for μ");
                } else {
                    valueNotEntered = false;
                }

            }

        }
        return userUVal;

    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        /**
         * Repeats prompt until user successfully inputs a value that is greater
         * than 0 and not equal to 1.0
         */
        boolean valueNotEntered = true;
        double userVal = 0;

        while (valueNotEntered) {
            out.println("Please input a positive, real value that is not 1");
            String userInput = in.nextLine();

            if (FormatChecker.canParseDouble(userInput)) {
                userVal = Double.parseDouble(userInput);
                if (userVal < 0 || userVal == 1.0) {
                    out.println(
                            "Error, input a positive, real value that is not 1");
                } else {
                    valueNotEntered = false;
                }
            }
        }
        return userVal;
    }

    /**
     * Loops through every combination of exponents -5 to 5 for each variable
     * w,x,y,z until reaching the users inputed value for μ.
     *
     * @param u
     *
     * @param w
     *
     * @param x
     *
     * @param y
     *
     * @param z
     *
     * @param out
     */

    /**
     * Calls getPositiveDouble and getPositiveDoubleNotOne Calls deJager and
     * attempts to calculate user "u" value given w,x,y,z.
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        /*
         * Records user-inputed values
         */

        double u = getPositiveDouble(in, out);
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        double wClose = 0;
        double xClose = 0;
        double yClose = 0;
        double zClose = 0;

        double wExact = 0;
        double xExact = 0;
        double yExact = 0;
        double zExact = 0;

        double closestCalc = 0;
        double exactCalc = 0;

        int loopWCount = 0;
        int loopXCount = 0;
        int loopYCount = 0;
        int loopZCount = 0;

        final int maxLoops = 17;

        final double one = 1.0;
        final double two = 2.0;
        final double three = 3.0;
        final double four = 4.0;
        final double five = 5.0;
        final double zero = 0.0;
        final int hundred = 100;

        double[] exponents = { -five, -four, -three, -two, -one, -one / two,
                -one / three, -one / four, zero, one / four, one / three,
                one / two, one, two, three, four, five };

        while (loopWCount < maxLoops) {

            double tempW = Math.pow(w, exponents[loopWCount]);
            while (loopXCount < maxLoops) {

                double tempX = Math.pow(w, exponents[loopXCount]);
                while (loopYCount < maxLoops) {

                    double tempY = Math.pow(w, exponents[loopYCount]);
                    while (loopZCount < maxLoops) {

                        double tempZ = Math.pow(w, exponents[loopZCount]);
                        double jagerCalc = tempW * tempX * tempY * tempZ;

                        if (u - jagerCalc == 0) {
                            exactCalc = jagerCalc;

                            wExact = exponents[loopWCount];
                            xExact = exponents[loopXCount];
                            yExact = exponents[loopYCount];
                            zExact = exponents[loopZCount];
                        } else if (Math.abs(u - jagerCalc) < Math
                                .abs(u - closestCalc)) {
                            closestCalc = jagerCalc;

                            wClose = exponents[loopWCount];
                            xClose = exponents[loopXCount];
                            yClose = exponents[loopYCount];
                            zClose = exponents[loopZCount];
                        }
                        loopZCount++;
                        if (loopZCount == maxLoops) {
                            loopZCount = 0;
                            break;
                        }
                    }
                    loopYCount++;
                    if (loopYCount == maxLoops) {
                        loopYCount = 0;
                        break;
                    }
                }
                loopXCount++;
                if (loopXCount == maxLoops) {
                    loopXCount = 0;
                    break;
                }

            }
            loopWCount++;

        }

        if (exactCalc != 0) {
            out.println(exactCalc);
            out.println(w + "^" + wExact + " * " + x + "^" + xExact + " * " + y
                    + "^" + yExact + " * " + z + "^" + zExact + " = "
                    + exactCalc);
            out.println("Calculated with a percent error of 0%");
        } else {
            out.println(w + "^" + wClose + " * " + x + "^" + xClose + " * " + y
                    + "^" + yClose + " * " + z + "^" + zClose + " = ");
            out.print(closestCalc, 2, false);

            double error = Math.abs((closestCalc - u) / u);
            out.println("\n Calculated with a percent error of ");
            out.print(error * hundred, 2, false);
            out.print("%");
        }

        /*
         * calls deJager with user-inputed values
         */

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
