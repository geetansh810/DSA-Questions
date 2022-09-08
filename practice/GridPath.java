package practice;

public class GridPath {

    public static void main(String[] args) {

        int n = 3;
        int[][] grid = {{1,1},{2,2},{3,3}};

        int maxSum = grid[0][1];

        for(int i=1; i<n; i++){
            if(grid[i][1] > grid[i-1][1]){
                maxSum += grid[i][1];
            }
        }

        System.out.println(maxSum);


    }

}
