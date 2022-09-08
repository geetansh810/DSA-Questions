package practice;

public class problem5 {

    public static boolean checkpalindrome(String str, int start, int end){

        if(start >= end)
            return true;

        if(str.charAt(start) != str.charAt(end)){
            return false;
        }

        return checkpalindrome(str, start+1, end-1);
    }


    public static void powersetOfString(String str, int i, String curr){

        if(i == str.length()){
            System.out.println(curr);
            return;
        }

        powersetOfString(str, i+1, curr+str.charAt(i));
        powersetOfString(str, i+1, curr);

    }

    public static void permutationOfString(String str, String curr){

        if(str.length() == 1){
            System.out.println(curr+str);
            return;
        }

        for(int i=0; i<str.length(); i++){
            char currChar = str.charAt(i);
            String leftOutString = str.substring(0,i) + str.substring(i+1);
            permutationOfString(leftOutString, curr+currChar);
        }

    }


    public static void main(String[] args){

        String str = "ABC";

        System.out.println("Is string is palindrome : ");
        boolean isPalindrome = checkpalindrome(str, 0, str.length()-1);
        System.out.println(isPalindrome);

        System.out.println("Powerset of a given string is ");
        powersetOfString(str, 0, "");

        System.out.println("Permutations of a given string are ");
        permutationOfString(str, "");
    }



}
