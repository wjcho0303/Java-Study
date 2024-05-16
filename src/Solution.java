public class Solution {
    public static void main(String[] args) {
        String str1 = "aaaaa";
        String str2 = "bbbbb";

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int resultNumber = str1.length()*2;
        char[] result = new char[resultNumber];

        for(int i = 0; i < resultNumber; i+=2) {
            result[i] = charArr1[i/2];
        }
        for(int i = 1; i < resultNumber+1; i+=2) {
            result[i] = charArr2[i/2];
        }

        String answer = new String(result);
        System.out.println(answer);
    }
}
