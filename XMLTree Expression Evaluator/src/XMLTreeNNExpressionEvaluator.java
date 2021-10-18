import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Nick Boenau
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";
        NaturalNumber answer = new NaturalNumber2(0);
        NaturalNumber zero = new NaturalNumber2(0);
        //base case is if its a number (has the attriubte value of value)
        if (exp.hasAttribute("value")) {
            int value = Integer.parseInt(exp.attributeValue("value"));
            NaturalNumber num = new NaturalNumber2(value);
            return num;
        } else {
            String operator = exp.label();
            switch (operator) {
                case ("plus"):
                    NaturalNumber temp1 = new NaturalNumber2(
                            evaluate(exp.child(0)));
                    NaturalNumber temp2 = new NaturalNumber2(
                            evaluate(exp.child(1)));
                    temp1.add(temp2);
                    answer.add(temp1);

                    break;
                case ("minus"):
                    NaturalNumber temp3 = new NaturalNumber2(
                            evaluate(exp.child(0)));
                    NaturalNumber temp4 = new NaturalNumber2(
                            evaluate(exp.child(1)));
                    temp3.subtract(temp4);
                    answer.add(temp3);

                    break;
                case ("divide"):
                    NaturalNumber temp5 = new NaturalNumber2(
                            evaluate(exp.child(0)));
                    NaturalNumber temp6 = new NaturalNumber2(
                            evaluate(exp.child(1)));
                    if (temp6.equals(zero)) {
                        Reporter.fatalErrorToConsole(
                                "ERROR: Expression contains division by zero.");
                    }
                    temp5.divide(temp6);
                    answer.add(temp5);

                    break;
                case ("times"):
                    NaturalNumber temp7 = new NaturalNumber2(
                            evaluate(exp.child(0)));
                    NaturalNumber temp8 = new NaturalNumber2(
                            evaluate(exp.child(1)));
                    temp7.multiply(temp8);
                    answer.add(temp7);

                    break;

            }
        }

        return answer;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
