import java.io.*;

public class anagram {
    static boolean isPangram(String str) {
        // Convert to lowercase
        str = str.toLowerCase();

        // Boolean array to mark presence of characters
        boolean[] alphabet = new boolean[26];

        // Check each character
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                alphabet[ch - 'a'] = true;
            }
        }

        // Verify all letters are present
        for (boolean present : alphabet) {
            if (!present) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        sc.close();

        if (isPangram(sentence)) {
            System.out.println("The sentence is a pangram.");
        } else {
            System.out.println("The sentence is NOT a pangram.");
        }
    }
}
