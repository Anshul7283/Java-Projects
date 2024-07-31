import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] number=new JButton[10];
    JButton[] function=new JButton[9];
    JButton add,sub,mul,div,decimal,equal,del,clr,neg;
    JPanel panel;
    Font myfont=new Font("Times Roman",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;


    Calculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,550);
        frame.setLayout(null);

        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myfont);
        textField.setEditable(false);

        add=new JButton("+");
        sub=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        decimal=new JButton(".");
        equal=new JButton("=");
        del=new JButton("del");
        clr=new JButton("clr");
        neg=new JButton("(-)");

        function[0]=add;
        function[1]=sub;
        function[2]=mul;
        function[3]=div;
        function[4]=decimal;
        function[5]=equal;
        function[6]=del;
        function[7]=clr;
        function[8]=neg;

        for(int i=0;i<9;i++){
            function[i].addActionListener(this);
            function[i].setFont(myfont);
            function[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            number[i]=new JButton(String.valueOf((i)));
            number[i].addActionListener(this);
            number[i].setFont(myfont);
            number[i].setFocusable(false);
        }
        neg.setBounds(50,430,100,50);
        del.setBounds(150,430,100,50);
        clr.setBounds(250,430,100,50);

        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(number[1]);
        panel.add(number[2]);
        panel.add(number[3]);
        panel.add(add);
        panel.add(number[4]);
        panel.add(number[5]);
        panel.add(number[6]);
        panel.add(sub);
        panel.add(number[7]);
        panel.add(number[8]);
        panel.add(number[9]);
        panel.add(mul);
        panel.add(decimal);
        panel.add(number[0]);
        panel.add(equal);
        panel.add(div);

        frame.add(panel);
        frame.add(neg);
        frame.add(del);
        frame.add(clr);
        frame.add(textField);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==number[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decimal){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==add){
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==sub){
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==mul){
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==div){
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==clr){
            textField.setText("");
        }
        if(e.getSource()==del){
            String str=textField.getText();
            textField.setText("");
            for(int i=0;i<str.length()-1;i++){
                textField.setText(textField.getText()+str.charAt(i));
            }
        }
        if(e.getSource()==neg){
            double temp=Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }

        if(e.getSource()==equal){
            num2=Double.parseDouble(textField.getText());
            switch (operator){
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }

    }
    public static void main(String[] args){
        Calculator c=new Calculator();
    }
}
