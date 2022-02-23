public class fabinacci {

    public static void fab(int start, int end, int interations ){

        if(interations==0)
            return;

        int temp = start+end;

        System.out.println(temp);

        fab(end, temp, --interations);
    }

    public static void main(String[] args){

        System.out.println(0);
        System.out.println(1);
        fab(0,1,10);

    }

}
