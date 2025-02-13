import java.util.Scanner;

class Automorphic {
    public static boolean isAutomorphic(int n) {
        int original = n; 
        int squared = n * n; 
        
        
        int count = 0, temp = n;
        while (temp > 0) {
            temp /= 10;
            count++;
        }

        int result = squared % (int) Math.pow(10, count);

        return original == result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        if (isAutomorphic(n)) {
            System.out.println(n + " is an Automorphic number.");
        } else {
            System.out.println(n + " is not an Automorphic number.");
        }
    }
}
