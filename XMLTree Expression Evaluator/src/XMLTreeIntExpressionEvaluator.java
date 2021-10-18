import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Nick Boenau
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
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
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";
        int answer = 0;
        //base case is if its a number (has the attriubte value of value)
        if (exp.hasAttribute("value")) {
            int value = Integer.parseInt(exp.attributeValue("value"));
            return value;
        } else {
            String operator = exp.label();
            switch (operator) {
                case ("plus"):

                    answer += (evaluate(exp.child(0)) + evaluate(exp.child(1)));

                    break;
                case ("minus"):

                    answer += (evaluate(exp.child(0)) - evaluate(exp.child(1)));

                    break;
                case ("divide"):

                    answer += (evaluate(exp.child(0)) / evaluate(exp.child(1)));

                    break;
                case ("times"):

                    answer += (evaluate(exp.child(0)) * evaluate(exp.child(1)));

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
