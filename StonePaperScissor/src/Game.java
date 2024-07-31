import java.util.Scanner;
import java.util.Random;
public class Game {
    public static void main(String [] args){
        Scanner input=new Scanner(System.in);
        Random random=new Random();
        System.out.println("Enter your choice");
        System.out.println("1 for stone");
        System.out.println("2 for scissor");
        System.out.println("3 for paper");
        String ch = null;
        int a=input.nextInt();
        System.out.print("Player turn  : ");
        switch (a){
            case 1: ch="Stone";
                System.out.print("Stone\n");
                break;
            case 2: ch="Scissor";
                System.out.print("Scissor\n");
                break;
            case 3:ch="Paper";
                System.out.print("paper\n");
            break;
            default:System.out.print("invalid choice\n");
            break;

        }


        System.out.print("Cpu turn     : ");
        int rand=1+random.nextInt(3);
        String c = null;
        switch (rand){
            case 1: c="Stone";
                System.out.print("Stone\n");
                break;
            case 2: c="Scissor";
                System.out.print("Scissor\n");
                break;
            case 3:c="Paper";
                System.out.print("paper\n");
                break;
            default:System.out.print("invalid choice\n");
                break;
        }if(ch==c){
            System.out.print("Game Tie ");
        }
        else if(ch=="Stone" && c=="Scissor"){
            System.out.print("Player win\n");
        }
        else if(ch=="Stone" && c=="Paper"){
            System.out.println("CPU win\n");
        }
        else if(ch=="Paper" && c=="Scissor"){
            System.out.println("CPU win\n");
        }
        else if(ch=="Paper" && c=="Stone"){
            System.out.println("Player win\n");
        }
        else if(ch=="Scissor" && c=="Paper"){
            System.out.println("Player win\n");
        }
        else if(ch=="Scissor" && c=="Stone"){
            System.out.println("CPU win\n");
        }
        else{
            System.out.print("No one win");
        }

    }
}
