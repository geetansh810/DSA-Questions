public class TowerOfHanoi {

    public static void towerOfHanoi(int n, String src, String help, String dest){

        if(n==1){
            System.out.println("Transferred "+n+" from "+src+" to "+dest);
            return;
        }

        towerOfHanoi(n-1, src, dest, help);

        System.out.println("Transferred "+n+" from "+src+" to "+dest);

        towerOfHanoi(n-1, help, src, dest);

    }


    public static void main(String[] args){
        int n = 3;
        String src = "Source";
        String help = "Helping";
        String dest = "Destination";

        towerOfHanoi(n,src,help,dest);

    }

}
