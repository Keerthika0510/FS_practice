
/*1876. Substrings of Size Three with Distinct Characters

A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.

 
Example 1:
Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".

Example 2:
Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".
 


case=1
input=
xyzzaz
output=
1


case=2
input=
aababcabc
output=
4


case=3
input=
ab
output=
0

case=4
input=
aaaaaa

output=
0

case=5
input=
abcdef
output=
4


*/
import java.util.*;
public class Test 
{
    public static int goodstrings(String s) 
    {
        int count = 0;
        if (s.length() < 3) 
        return 0;
        for (int i = 0; i <= s.length() - 3; i++) 
        {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            if(a!=b && b!=c && c!=a)
            {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(goodstrings(s));
        
    }
}


    
