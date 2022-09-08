public class StringsPermutations {

    public static void printPermutations(String str, String perm){

        if(str.length() == 0){
            System.out.println(perm);
            return;
        }

        for(int i=0; i<str.length(); i++){
            char currChar = str.charAt(i);
//            System.out.println(currChar);
            String newStr = str.substring(0,i) + str.substring(i+1);
            System.out.println("~"+newStr+"~");
            printPermutations(newStr, perm+currChar);
        }


    }


    public static void main(String[] args){

        String str = "ABC";
        printPermutations(str, "");

    }

}
