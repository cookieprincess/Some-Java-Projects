import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class App implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton [] numButtons = new JButton[10]; //numbered buttons
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton; //naming our functional buttons
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel; //to hold all our fonts
    
    Font myFont = new Font("Ink Free",Font.BOLD,30); //declaring a font to use
    
    double num1=0,num2=0,result=0;
    char operator; //hold our value
    
    App(){  //creating a constructor
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows us to close our progrma
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false); //textfield cannot be inputted on

        //creating symbols
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        //adding our functional buttons to their respective positions in arrays

        for(int i=0; i<8; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0; i<10; i++){
            numButtons[i] = new JButton(String.valueOf(i)); //instantiating individual buttons
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }

        /*for(int i=0; i<3; i++){
            numButtons[i].setBounds(null);

        }*/

        //addButton.setBounds(30,100,10,10);
        
        //we want our del and clr button to not be in the panel

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205, 430, 145, 50);
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300); //the panel's size determines how the buttons are  sized in it
        panel.setLayout(new GridLayout(4,4,10,10)); //the 10 and 10 are the gaps between each small square
        
        //panel.setBackground(Color.GRAY);

        for(int i=1; i<=3; i++){
            panel.add(numButtons[i]);
        }

        panel.add(addButton);

        for(int i=4; i<=6; i++){
            panel.add(numButtons[i]);
        }

        panel.add(subButton);

        for(int i=7; i<=9; i++){
            panel.add(numButtons[i]);
        }

        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

       
        
    }

    public static void main(String[] args) throws Exception {
        App app = new App();    //creating an instance
    }

    public void actionPerformed(ActionEvent e){
        for(int i=0; i<10; i++){
            if(e.getSource() == numButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i))); //setting the text of the text field to what's been written + what will be written

            }
        }
        if(e.getSource()==decButton){
            textfield.setText(textfield.getText().concat("."));
        }

        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textfield.getText()); //takes what's in the textField (which will be a string) and stores it as a double value
            operator ='+';
            textfield.setText(""); //erasing what's in the text afterwards   

            //I guess after the input is 
        }

        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator ='-';
            textfield.setText("");    
        }

        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator ='*';
            textfield.setText("");    
        }

        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator ='/';
            textfield.setText("");    
        }

        if(e.getSource()==equButton){
            num2 = Double.parseDouble(textfield.getText());
            //the last number displayed before we enter equal

            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
            
                case '-':
                    result = num1 - num2;
                    break;
                
                case '*':
                    result = num1 * num2;
                    break;
                
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result; //updates num1 after having pressed on the equal sign button
        }

        if(e.getSource()==clrButton){
            textfield.setText("");
        }

        if(e.getSource()==delButton){
            String string = textfield.getText();    //retrieving current text
            textfield.setText("");  //setting it to blank
            for(int i=0; i<string.length()-1; i++){
                textfield.setText(textfield.getText()+string.charAt(i)); //setting it to blank + numbers of what was previously on the text box minus its last
            }
            //each press increments on it
            
        }

    }
}
