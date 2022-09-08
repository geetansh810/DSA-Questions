import java.util.*;

public class countAnagram {
    public static void main(String[] args) throws Exception {

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {

            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            System.out.println("s1 -> "+s1);
            System.out.println("s2 -> "+s2);

            HashMap<Character, Integer> hm1 = new HashMap<>();
            HashMap<Character, Integer> hm2 = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {
                char tempChar = s1.charAt(i);
                if (hm1.containsKey(tempChar)) {
                    int val = hm1.get(tempChar);
                    hm1.put(tempChar, (val + 1));
                } else {
                    hm1.put(tempChar, 1);
                }
            }

            for (int i = 0; i < s2.length(); i++) {
                char tempChar = s2.charAt(i);
                if (hm2.containsKey(tempChar)) {
                    int val = hm2.get(tempChar);
                    hm2.put(tempChar, (val + 1));
                } else {
                    hm2.put(tempChar, 1);
                }
            }

            System.out.println(hm1);
            System.out.println(hm2);

            int count = 0;

            if (s1.length() > s2.length()) {

                Set<Character> hs = hm1.keySet();
                char[] arr = new char[hs.size()];
                int j = 0;
                for (char ele : hs) {
                    arr[j++] = ele;
                }

                for (char tempChar : arr) {
                    int val;
                    if (hm1.containsKey(tempChar)) {
                        val = Math.abs(hm2.get(tempChar) - hm1.get(tempChar));
                    } else {
                        val = hm2.get(tempChar);
                    }
                    count += val;
                }

            } else {

                Set<Character> hs = hm2.keySet();
                char[] arr = new char[hs.size()];
                int j = 0;
                for (char ele : hs) {
                    arr[j++] = ele;
                }

                for (char tempChar : arr) {
                    int val;
                    System.out.println(tempChar);
                    if (hm1.containsKey(tempChar)) {
                        val = Math.abs(hm2.get(tempChar) - hm1.get(tempChar));
                    } else {
                        val = hm1.get(tempChar);
                    }
                    count += val;
                }
            }

            System.out.println(count);


        }


    }

}