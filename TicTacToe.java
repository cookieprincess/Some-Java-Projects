import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
Random random = new Random(); //creating an instance of the random class
JFrame frame = new JFrame();
JPanel titlePanel = new JPanel(); //where the title will be located
JPanel buttonPanel = new JPanel(); //consisting of grids
JLabel textfield = new JLabel(); //to display text whenever we have a message
JButton[] buttons = new JButton[9]; //an array that takes in Jbuttons (is empty at the moment however)
boolean player1Turn;
    

TicTacToe(){
    //constructor defined
    
    //defining the characteristics of our frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //how it closes
    frame.setSize(800,800); //its size
    frame.getContentPane().setBackground(new Color(50, 50, 50)); //its color
    frame.setLayout(new BorderLayout()); //its layout
    frame.setVisible(true); //its visibility

    //defining the characteristics of the text
    textfield.setBackground(new Color(25,25,25));
    textfield.setForeground(new Color(25, 255, 0));
    textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
    textfield.setHorizontalAlignment(JLabel.CENTER);
    textfield.setText("Tic-Tac-Toe");
    textfield.setOpaque(true);

    //defining the panel containing our text
    titlePanel.setLayout(new BorderLayout());
    titlePanel.setBounds(0,0,800,100); //position and size

    //defining the ppanel containing the buttons 
    buttonPanel.setLayout(new GridLayout(3,3));
    buttonPanel.setBackground(new Color(150,150,150));

    for(int i=0; i<9; i++){
        buttons[i] = new JButton(); //filling the array with buttons
        buttonPanel.add(buttons[i]); //adding our buttons to their panel
        //giving the buttons extra characteristics
        buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
        buttons[i].setFocusable(false);
        buttons[i].addActionListener(this);
    }

    //constructing our app:
    titlePanel.add(textfield);
    frame.add(titlePanel);
    frame.add(buttonPanel);

    firstTurn();

    
}
@Override
public void actionPerformed(ActionEvent e){
    for(int i=0; i<9; i++){
        if(e.getSource()==buttons[i]){
            if(player1Turn == true){
                if(buttons[i].getText()==""){
                    buttons[i].setForeground(new Color(255,0,0));
                    buttons[i].setText("X");
                    player1Turn = false;
                    textfield.setText("O's turn");
                    check();
                }
            }
            else{
                if(buttons[i].getText()==""){
                    buttons[i].setForeground(new Color(0,0,255));
                    buttons[i].setText("O");
                    player1Turn = true;
                    textfield.setText("X's turn");
                    check();
                }
            }


        }
    }
}

public void firstTurn(){
    try{
    Thread.sleep(3000);     //delaying the display of turns by 3 seconds
    } catch (InterruptedException e){
        e.printStackTrace();
    }

    if(random.nextInt(2)==0){
        player1Turn = true;
        textfield.setText("X's turn");
    }
    else{
        player1Turn = false;
        textfield.setText("O's turn");
    }
}

public void check(){
//checking if we have a winning combination
        if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) 
                {
			xWins(0,1,2);
		        }
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);

		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
                }
}

public void xWins(int a, int b, int c){ //those represent indices
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);

    for(int i=0; i<9; i++){
        buttons[i].setEnabled(false);
    }
    textfield.setText("X wins");
}

public void oWins(int a, int b, int c){
    buttons[a].setBackground(Color.GREEN);  //turning all of them green
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);

    for(int i=0; i<9; i++){
        buttons[i].setEnabled(false);   //you can't click on them anymore
    }
    textfield.setText("O wins");

}

}
