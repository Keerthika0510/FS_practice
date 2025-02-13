import java.util.Scanner;

class Binary {
    public static boolean isBinary(int n) {
        int temp;
        while (n > 0) {
            temp = n % 10;
            if (temp != 0 && temp != 1) { 
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
       

        if (isBinary(n)) {
            System.out.println("Yes, it's a binary number.");
        } else {
            System.out.println("No, it's not a binary number.");
        }
    }
}
