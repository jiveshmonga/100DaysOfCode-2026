public class SumofArray {
    public static void main(String[] args){
        int [] arr = {4,7,17,0,2};
        int sum_of_array = 0;
        for (int num : arr) {
            sum_of_array += num;
        }
        System.out.println("Sum of Array is : " + sum_of_array);
    }
}
