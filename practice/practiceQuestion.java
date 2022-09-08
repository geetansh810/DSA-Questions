package practice;

import java.sql.SQLOutput;

public class practiceQuestion {

    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix[0][0] == target)
            return true;

        int i=0;
        int j=1;

//        System.out.println(matrix.length);
//        System.out.println(matrix[0].length);

        while(j<matrix[0].length && i<matrix.length){
            System.out.println("i -> "+i);
            System.out.println("j -> "+j);
//            System.out.println(matrix[i][j]);
//            System.out.println(matrix[j][i]);

            if(matrix[i][j] == target)
                return true;

            if(matrix[j][i] == target)
                return true;

            if(target - matrix[i][j] < target - matrix[j][i]){
                i++;
            }else{
                j++;
            }

            System.out.println();

        }

        return false;

    }
    public static void main(String[] args){

//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int target = 5;

        int[][] matrix = {{1, 1}};
        int target = 0;

        System.out.println(searchMatrix(matrix, target));


    }


}
