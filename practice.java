public class practice {

    public static Boolean check(int[] arr, int ele){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == ele){
                return false;
            }
        }

        return true;
    }

    public static int doUnion(int a[], int n, int b[], int m)
    {
        //Your code here
        int[] uni = new int[n+m];
        int x = -1;

        for(int i =0; i<n; i++){

            if(check(uni, a[i])){
                continue;
            }else{
                x++;
                uni[x] = a[i];

            }


        }

        for(int i =0; i<m; i++){

            if(check(uni, b[i])){
                continue;
            }else{
                x++;
                uni[x] = b[i];

            }


        }

        for(int j =0; j<uni.length; j++){
            System.out.println(uni[j]);
        }
        return uni.length;

    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3};

        System.out.println(doUnion(a,5,b,3));
    }

}
