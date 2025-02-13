import java.util.HashMap;
import java.util.Scanner;

public class Distinct {
    public static void countDistinctNumbers(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Count distinct elements in the first window
        for (int i = 0; i < k; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(hm.size() + " ");

        // Sliding window technique
        for (int i = k; i < n; i++) {
            // Remove the element going out of the window
            if (hm.get(arr[i - k]) == 1) {
                hm.remove(arr[i - k]);
            } else {
                hm.put(arr[i - k], hm.get(arr[i - k]) - 1);
            }

            // Add the new element in the window
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

            // Print the number of distinct elements
            System.out.print(hm.size() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // Read the array elements
        }

        int k = sc.nextInt(); // Read k value

        countDistinctNumbers(arr, n, k); // Call function

        sc.close();
    }
}