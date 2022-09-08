package practice;

public class RuggedTerrain {

    public static void main(String[] args) {

        int n = 4;
        int[] levels = {-1, 1,1,1};

//        int n = 2;
//        int[] levels = {3,3};

        int prevLevelRequired = levels[0]-1;
        int levelsToDig = 0;

        for (int i = 1; i < n; i++) {

//            System.out.println(levels[i]);
//            System.out.println(prevLevelRequired);
//            System.out.println(levelsToDig);
//            System.out.println();

            if(levels[i] == prevLevelRequired ){
                prevLevelRequired -= 1;
                continue;
            }

            if(levels[i] > prevLevelRequired){
                levelsToDig += levels[i] - prevLevelRequired + 1;
                prevLevelRequired -= 1;
                continue;
            }

            if(levels[i] < prevLevelRequired){
                prevLevelRequired = levels[i]-1;
                continue;
            }

        }


        int days =0;
        int DDay =1;
        while(levelsToDig > 0){

            levelsToDig -= ((2*DDay) -1);
            DDay++;
            days++;

        }

        System.out.println(days);


    }

}
