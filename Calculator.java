import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JTextField textField2;
    JButton[] numberButtons= new JButton[10];
    JButton[] functionButtons= new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, delButton, clrButton, equButton, negButton;
    JPanel panel;
    Font myFont = new Font("Arial",Font.BOLD,40);

    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,550);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setBackground(Color.black);

        textField = new JTextField();
        textField.setBounds(5,30,440,50);
        textField.setFont(myFont);
        textField.setBackground(Color.darkGray);        
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField.setForeground(Color.white);
        textField.setEditable(false);

        textField2 = new JTextField();
        textField2.setBounds(5,5,440,25);
        textField2.setFont(new Font("Arial",Font.PLAIN, 20));
        textField2.setBackground(Color.darkGray);
        textField2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField2.setForeground(Color.white);
        textField2.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        delButton = new JButton("Del");
        clrButton = new JButton("AC");
        equButton = new JButton("=");
        negButton = new JButton("+/-");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = delButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = equButton;
        functionButtons[8] = negButton;

        // for operator buttons
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 30));
            functionButtons[i].setBackground(Color.gray);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setForeground(Color.white);
            functionButtons[i].setBorderPainted(false);
        }

        // for number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 30));
            numberButtons[i].setBackground(Color.BLACK);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setBorderPainted(false);
        }
        delButton.setBounds(155,90,140,50);
        clrButton.setBounds(5,90,140,50);
        negButton.setBounds(305,90,140,50);

        panel = new JPanel();
        panel.setBounds(5,145,440,363);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.darkGray);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(divButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(addButton);


        frame.add(panel);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(negButton);
        frame.add(textField);
        frame.add(textField2);
        frame.setVisible(true);


    }


    public static void main(String[] args) {

        Calculator calculator = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }

        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = 'x';
            textField.setText("");
        }
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case 'x':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource() == clrButton) {
            textField.setText("");
            textField2.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}