package recursion;

import java.util.ArrayList;

public class powerSet {

    public static ArrayList<ArrayList<Integer>> mainAns = new ArrayList<>();
    public static ArrayList<Integer> ans = new ArrayList<>();
    public static void subSets(int[] arr, int i){

//        System.out.println("i -> "+i+"  ans -> "+ans);

        if(i >= arr.length){
            mainAns.add(ans);
            System.out.println("=========="+ans);
            System.out.println();
            return;
        }

        int iTh = arr[i];
        ans.add(iTh);
        subSets(arr, i+1);
//        System.out.println("~~~~~i -> "+i+"  ans -> "+ans);
        ans.remove(ans.size()-1);
        subSets(arr, i+1);
    }

    public static void main(String[] args){

        int[] arr = {1,2,3};
        subSets(arr, 0);
//        System.out.println(mainAns);

    }


}
