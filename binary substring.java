/* 

Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.

Example 1:
Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.

Example 2:
Input: s = "0110", k = 1
Output: true
Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring. 

Example 3:
Input: s = "0110", k = 2
Output: false
Explanation: The binary code "00" is of length 2 and does not exist in the array.
 

case=1
input=
00110110
2
output=
true

case=2
input=
0110
1
output=
true

case=3
input=
0110
2
output=
false


case=4
input=
0001110100111010
3
output=
true

case=5
input=
110101101011
3
output=
false
*/
import java.util.*;
public class Test 

{
    public static boolean binary(String s, int k) 
    {
            HashSet<String>hs=new HashSet<>();
            for(int i=0;i<s.length()-k;i++)
            {
                hs.add(s.substring(i,i+k));
            }
            if(hs.size()==Math.pow(2,k))
            {
              return true;
            }
            else
            {
              return false;
            }
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();
        System.out.println(binary(s,k));
    }
}
    


    
    


