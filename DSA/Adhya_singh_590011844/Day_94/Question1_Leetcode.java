import java.util.*;

public class Main {

    static boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(divisorGame(n));

        sc.close();
    }
}