package practice;

import java.util.Arrays;
import java.util.Scanner;

public class relevel2 {
    public static void main(String[] args) {

        try {
            try {
                int x = Integer.parseInt("pant");
                System.out.println("Print if no exception is found");
            }
            catch (NumberFormatException e){
                System.out.println("Specific exception was thrown");
                throw e;//throw the exception "e" once again
            }
             catch (Exception nfe) {
                System.out.println("Any Exception occurred !!!");
                throw nfe;
            }
        }catch (NumberFormatException e){
            System.out.println("Exception was thrown again !!!");
        }
        finally {
            System.out.println("This will no matter what happens");
        }

        System.out.println("Out of exception block");

    }
}