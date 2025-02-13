import java.util.Scanner;

public class maxaverage {
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        
               if (k > n) {
            throw new IllegalArgumentException("Subarray size k cannot be greater than array size n");
        }

        double maxSum = 0, currentSum = 0;

        
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        maxSum = currentSum;

        
        for (int i = k; i < n; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
             if (k > n || k <= 0) {
            System.out.println("Invalid input: k should be between 1 and n.");
            return;
        }

                System.out.println(findMaxAverage(nums, k));
    }
}
