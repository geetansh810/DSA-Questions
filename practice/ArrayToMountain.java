package practice;

public class ArrayToMountain {

    public static void main(String[] args) {

//        int n = 9;
//        int[] arr = {1, 1, 1, 2, 3, 2, 1, 1, 1};

        int n = 6;
        int[] arr = {3, 3, 4, 4, 5, 5};

        int count = 0;

        if(n%2 == 0){

            for (int i = n / 2 - 1, j = n / 2; i >= 0 && j < n; i--, j++) {

                System.out.println(arr[i] + " , " + arr[j]);
                if (arr[i] != arr[j]) {
                    count += 2;
                    System.out.println("----");
                    continue;
                }

                if ((arr[i] == arr[j]) && ((arr[i] == (arr[i + 1])))) {
                    count++;
                    System.out.println();
                }
                if ((arr[i] == arr[j]) && (arr[j] == (arr[j - 1]))) {
                    count++;
                    System.out.println();
                }

            }

            System.out.println(count);
            return;
        }

        for (int i = n / 2 - 1, j = n / 2 + 1; i >= 0 && j < n; i--, j++) {

            System.out.println(arr[i] + " , " + arr[j]);
            if (arr[i] != arr[j]) {
                count += 2;
                System.out.println("----");
                continue;
            }

            if ((arr[i] == arr[j]) && ((arr[i] == (arr[i + 1])))) {
                count++;
                System.out.println();
            }
            if ((arr[i] == arr[j]) && (arr[j] == (arr[j - 1]))) {
                count++;
                System.out.println();
            }

        }

        System.out.println(count);
    }

}
