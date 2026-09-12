import java.util.Scanner;
import java.util.Stack;

public class Question1_Leetcode {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Parentheses String: ");
        String s = sc.next();

        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {

                if (!st.isEmpty()) {
                    ans.append(ch);
                }

                st.push(ch);
            }

            else {

                st.pop();

                if (!st.isEmpty()) {
                    ans.append(ch);
                }
            }
        }

        System.out.println("Result: " + ans.toString());

        sc.close();
    }
}