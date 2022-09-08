import java.util.*;

class mainClass{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println("a -> "+a);
            System.out.println("b -> "+b);

            for(int i=1; i<=(a*2)+1; i++){

                for(int j=1; j<=(b*2)+1; j++){

//                    System.out.println("i-> "+i);
//                    System.out.println("j-> "+j);

                    if(i < 3 && j<3){
                        System.out.print(".");
                    }else{
                        if(i%2 != 0 && j%2 != 0){
                            System.out.print("+");
                        }else if(i%2 != 0 && j%2 == 0){
                            System.out.print("-");
                        }else if(i%2 == 0 && j%2 == 0){
                            System.out.print(".");
                        }else{
                            System.out.print("|");
                        }
                    }

                }

                System.out.println();


            }
        }

    }
}