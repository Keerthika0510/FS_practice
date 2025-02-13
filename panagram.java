import java.io.*;
class panagram {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        int flag = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            String letter = ch + "";
            if (!str.contains(letter)) {
                flag = 1;
                break;
            }
        }

        if (flag == 1) {
            System.out.println("Not a panagram");
        } else {
            System.out.println("Is a pangaram");
        }
    }
}
