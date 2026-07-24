import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Postfix Expression: ");
        String postfix = sc.next();

        Stack<String> st = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {

            char ch = postfix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            }
            else {

                String op2 = st.pop();
                String op1 = st.pop();

                String prefix = ch + op1 + op2;

                st.push(prefix);
            }
        }

        System.out.println("Prefix Expression: " + st.peek());
    }
}