import java.util.*;

public class naive {
    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
             
        int maxSum = Integer.MIN_VALUE;
        
                for (int i = 0; i <= n - k; i++) {
            int currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum += arr[j];
            }
            maxSum = Math.max(maxSum, currentSum);
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
