package recursion;

public class stringIsPalindrome {

    public static boolean palindrome(String str, int start, int end){

        if(start >= end)
            return true;

        if (str.charAt(start) == str.charAt(end))
            return palindrome(str, start+1, end-1);

        return false;


    }

    public static void main(String[] args){
        String s = "RADar";
        System.out.println(palindrome(s, 0, s.length()-1));
    }

}
