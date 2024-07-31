import  java.lang.Math;
import java.util.Scanner;

public class TicTacToe {
    char player = 'X';
    int a[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    TicTacToe() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(a[i][j] + "|");
            }
            System.out.print(a[i][2]);
            System.out.println();
            System.out.println("-----");
        }
        for (int j = 0; j < 2; j++) {
            System.out.print(a[2][j] + "|");
        }
        System.out.print(a[2][2]);
        System.out.println();
        while (true) {
            input();
            display();
            if (win() == 'X') {
                System.out.print("X wins");
                break;
            }
            else if (win() == 'O') {
                System.out.print("O wins");
                break;
            }
            toggle();
        }
    }


    public void input() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the key 1 to 9 for your moves X & 0 \n");
        int m = s.nextInt();
        for (int chances = 1; chances <= 9; chances++) {
            if (m == 1)
                a[0][0] = player;
            else if (m == 2)
                a[0][1] = player;
            else if (m == 3)
                a[0][2] = player;
            else if (m == 4)
                a[1][0] = player;
            else if (m == 5)
                a[1][1] = player;
            else if (m == 6)
                a[1][2] = player;
            else if (m == 7)
                a[2][0] = player;
            else if (m == 8)
                a[2][1] = player;
            else if (m == 9)
                a[2][2] =player;

        }
    }

    public void toggle() {
        if (player == 'X')
            player = 'O';
        else
            player = 'X';
    }

    public char win() {
        if (a[0][0] == 'X' && a[0][1] == 'X' && a[0][2] == 'X')
            return 'X';
        if (a[1][0] == 'X' && a[1][1] == 'X' && a[1][2] == 'X')
            return 'X';
        if (a[2][0] == 'X' && a[2][1] == 'X' && a[2][2] == 'X')
            return 'X';
        if (a[0][0] == 'X' && a[1][0] == 'X' && a[2][0] == 'X')
            return 'X';
        if (a[0][1] == 'X' && a[1][1] == 'X' && a[2][1] == 'X')
            return 'X';
        if (a[0][2] == 'X' && a[1][2] == 'X' && a[2][2] == 'X')
            return 'X';
        if (a[0][0] == 'X' && a[1][1] == 'X' && a[2][2] == 'X')
            return 'X';
        if (a[2][0] == 'X' && a[1][1] == 'X' && a[0][2] == 'X')
            return 'X';
        if (a[0][0] == 'O' && a[0][1] == 'O' && a[0][2] == 'O')
            return 'O';
        if (a[1][0] == 'O' && a[1][1] == 'O' && a[1][2] == 'O')
            return 'O';
        if (a[2][0] == 'O' && a[2][1] == 'O' && a[2][2] == 'O')
            return 'O';
        if (a[0][0] == 'O' && a[1][0] == 'O' && a[2][0] == 'O')
            return 'O';
        if (a[0][1] == 'O' && a[1][1] == 'O' && a[2][1] == 'O')
            return 'O';
        if (a[0][2] == 'O' && a[1][2] == 'O' && a[2][2] == 'O')
            return 'O';
        if (a[0][0] == 'O' && a[1][1] == 'O' && a[2][2] == 'O')
            return 'O';
        if (a[2][0] == 'O' && a[1][1] == 'O' && a[0][2] == 'O')
            return 'O';
        return 0;

    }


      public void display(){
          for(int i=0;i<2;i++) {
              for (int j = 0; j < 2; j++) {
                  System.out.print(a[i][j] + "|");
              }
              System.out.print(a[i][2]);
              System.out.println();
              System.out.println("-----");
          }
          for (int j = 0; j < 2; j++) {
              System.out.print(a[2][j] + "|");
          }
          System.out.print(a[2][2]);
          System.out.println();
      }


}
