package agh.cs.lab1;
import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        out.println("Start");
        run(args);
        out.println("Stop");
    }
    public static void run(String[] args) {
        /*out.println("Do przodu");
        boolean t = false;
        for(String argument: args){
            if(t){
                out.print(",");
            }else{
                t = true;
            }
            out.print(argument);
        }
        out.println();
         */
        for(String argument: args) {
            switch (argument) {
                case "f":
                    out.println("Do przodu");
                    break;
                case "b":
                    out.println("Do tyłu");
                    break;
                case "r":
                    out.println("W prawo");
                    break;
                case "l":
                    out.println("W lewo");
                    break;
            }
        }
    }
}
