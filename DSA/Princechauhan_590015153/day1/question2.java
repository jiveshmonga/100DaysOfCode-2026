
import java.util.*;
public class question2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        int n = sc.nextInt();
System.out.println("enter elements of array:");
int sum = 0;
for(int i =0; i<n;i++){sum = sum + sc.nextInt();}
        sc.close();
        System.out.println("sum of elements of array:"+sum);
    }
}