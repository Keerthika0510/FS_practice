import java.util.*;

public class maxSubarraySum {
    public static int findMaxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return 0; 

        Set<Integer> uniqueElements = new HashSet<>();
        int maxSum = 0, currentSum = 0;
        for (int i = 0; i < k; i++) {
            if (uniqueElements.contains(nums[i])) {
                uniqueElements.clear();
                currentSum = 0;
                break;
            }
            uniqueElements.add(nums[i]);
            currentSum += nums[i];
        }

        if (uniqueElements.size() == k) maxSum = currentSum;

               for (int i = k; i < n; i++) {
            
            int outgoing = nums[i - k];
            if (uniqueElements.contains(outgoing)) {
                uniqueElements.remove(outgoing);
                currentSum -= outgoing;
            }

            
            if (uniqueElements.contains(nums[i])) {
                uniqueElements.clear();
                currentSum = 0;
                continue;
            }

            uniqueElements.add(nums[i]);
            currentSum += nums[i];

                        if (uniqueElements.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        scanner.close();

        System.out.println(findMaxSubarraySum(nums, k));
    }
}
