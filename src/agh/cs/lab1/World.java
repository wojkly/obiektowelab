package agh.cs.lab1;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("Start");


        Direction[] direction = new Direction[args.length];

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                    case "f":
                        direction[i] = Direction.FORWARD;
                        break;
                    case "b":
                        direction[i] = Direction.BACKWARD;
                        break;
                    case "r":
                        direction[i] = Direction.RIGHT;
                        break;
                    case "l":
                        direction[i] = Direction.LEFT;
                        break;
            }
        }
        run(direction);
        out.println("Stop");
    }

    public static void run(Direction[] direction) {
        for (Direction d : direction) {
            switch (d) {
                case FORWARD:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    out.println("Zwierzak idzie w lewo");
                    break;
                case LEFT:
                    out.println("Zwierzak idzie w prawo");
                    break;
            }
        }

        /*    Przecinki

        out.println("Do przodu");
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


        /*   Zwykle wypisanie, gdzie idzie
        for(String argument: args) {
            switch (argument) {
                case "f":
                    out.println("Zwierzak idzie do przodu");
                    break;
                case "b":
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case "r":
                    out.println("Zwierzak skręca w prawo");
                    break;
                case "l":
                    out.println("Zwierzak skręca w lewo");
                    break;
            }
        }

         */
    }
}