import java.util.*;

public class slidingwindow {
    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;        
        int maxSum = 0, sum = 0;
        
        
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxSum = sum;
        
               for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        
        System.out.println(maxSumSubarray(arr, k));
        sc.close();
    }
}
