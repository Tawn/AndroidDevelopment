package mobappdev.demo.finalexam.problem1;

/**
 * Created by Tkha on 6/29/17.
 */

public class ProblemOneCalculations {

    public String getPower(String op1, String op2) {
        int operand1 = Integer.parseInt(op1);
        int operand2 = Integer.parseInt(op2);
        return Integer.toString((int)Math.pow(operand1, operand2));
    }

    public String getSub(String op1, String op2) {
        int operand1 = Integer.parseInt(op1);
        int operand2 = Integer.parseInt(op2);
        return Integer.toString(operand1 - operand2);
    }
}
