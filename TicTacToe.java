import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener {
    Random random=new Random();
    JFrame frame1=new JFrame();

    JButton click=new JButton("Start Game");
    JPanel click_panel=new JPanel();
    JFrame frame=new JFrame();
    JPanel title=new JPanel();
    JPanel button=new JPanel();
    JLabel text=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1;
    JLabel label_title=new JLabel("Tic-Tac-Toe");
    TicTacToe(){
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(800,800);
        frame1.getContentPane().setBackground(new Color(50,50,50));
        frame1.setLayout(new BorderLayout());
        frame1.setVisible(true);
        click_panel.setBackground(new Color(150,150,150));
        label_title.setFont(new Font("Times Roman",Font.BOLD,85));
        label_title.setHorizontalAlignment(JLabel.CENTER);
        click.setHorizontalAlignment(JButton.CENTER);
        click_panel.add(click);
        click_panel.add(label_title);
        frame1.add(click_panel);
        click.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Start Game")) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.getContentPane().setBackground(new Color(50, 50, 50));
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);

            text.setBackground(new Color(25, 25, 25));
            text.setForeground(new Color(234, 7, 7));
            text.setFont(new Font("Times Roman", Font.BOLD, 85));
            text.setHorizontalAlignment(JLabel.CENTER);
            text.setText("Tic Tac Toe (X/O)");
            text.setOpaque(true);

            title.setLayout(new BorderLayout());
            title.setBounds(0, 0, 800, 100);

            button.setLayout(new GridLayout(3, 3));
            button.setBackground(new Color(150, 150, 150));

            title.add(text);
            frame.add(title, BorderLayout.NORTH);
            frame.add(button);

            for (int i = 0; i < 9; i++) {
                buttons[i] = new JButton();
                button.add(buttons[i]);
                buttons[i].setFont(new Font("Times Roman", Font.BOLD, 120));
                buttons[i].setFocusable(false);
                buttons[i].addActionListener(this);
            }
            playerTurn();
        }
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == buttons[i]) {
                    if (player1) {
                        if (buttons[i].getText()=="") {
                            buttons[i].setForeground(new Color(255, 0, 0));
                            buttons[i].setText("X");
                            player1 = false;
                            text.setText("0 Turn");
                            operations();
                        }
                    } else {
                        if (buttons[i].getText() =="") {
                            buttons[i].setForeground(new Color(0, 0, 255));
                            buttons[i].setText("O");
                            player1 = true;
                            text.setText("X Turn");
                            operations();
                        }
                    }
                }
            }
        }
    public void playerTurn(){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        if(random.nextInt(2)==0){
            player1=true;
            text.setText("X Turn");
        }
        else{
            player1=false;
            text.setText("O Turn");
        }
    }
    public void operations(){
        // Horizonatal
        if((buttons[0].getText()=="X"&& buttons[1].getText()=="X"&&buttons[2].getText()=="X"))
            xWins(0,1,2);
        if((buttons[3].getText()=="X"&& buttons[4].getText()=="X"&&buttons[5].getText()=="X"))
            xWins(3,4,5);
        if((buttons[6].getText()=="X"&& buttons[7].getText()=="X"&&buttons[8].getText()=="X"))
            xWins(6,7,8);
        //Vertical
        if((buttons[0].getText()=="X"&& buttons[3].getText()=="X"&&buttons[6].getText()=="X"))
            xWins(0,3,6);
        if((buttons[1].getText()=="X"&& buttons[4].getText()=="X"&&buttons[7].getText()=="X"))
            xWins(1,4,7);
        if((buttons[2].getText()=="X"&& buttons[5].getText()=="X"&&buttons[8].getText()=="X"))
            xWins(2,5,8);
        //Diagonal
        if((buttons[0].getText()=="X"&& buttons[4].getText()=="X"&&buttons[8].getText()=="X"))
            xWins(0,4,8);
        if((buttons[2].getText()=="X"&& buttons[4].getText()=="X"&&buttons[6].getText()=="X"))
            xWins(2,4,6);
        
        // O operations
        if((buttons[0].getText()=="O"&& buttons[1].getText()=="O"&&buttons[2].getText()=="O"))
            oWins(0,1,2);
        if((buttons[3].getText()=="O"&& buttons[4].getText()=="O"&&buttons[5].getText()=="O"))
            oWins(3,4,5);
        if((buttons[6].getText()=="O"&& buttons[7].getText()=="O"&&buttons[8].getText()=="O"))
            oWins(6,7,8);
        //Vertical
        if((buttons[0].getText()=="O"&& buttons[3].getText()=="O"&&buttons[6].getText()=="O"))
            oWins(0,3,6);
        if((buttons[1].getText()=="O"&& buttons[4].getText()=="O"&&buttons[7].getText()=="O"))
            oWins(1,4,7);
        if((buttons[2].getText()=="O"&& buttons[5].getText()=="O"&&buttons[8].getText()=="O"))
            oWins(2,5,8);
        //Diagonal
        if((buttons[0].getText()=="O"&& buttons[4].getText()=="O"&&buttons[8].getText()=="O"))
            oWins(0,4,8);
        if((buttons[2].getText()=="O"&& buttons[4].getText()=="O"&&buttons[6].getText()=="O"))
            oWins(2,4,6);

    }
    public void xWins(int a,int b,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text.setText("X wins");
    }
    public void oWins(int a,int b,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text.setText("O wins");
    }
}