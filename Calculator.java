package Project5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textfield;
	
	JButton[] numberButton = new JButton[10];
	JButton[] functionButton = new JButton[9];
	
	JButton addButton, subButton, mulButton, divButton;
	JButton decimalButton, equalButton, deleteButton, clearButton, negativeButton;
	
	JPanel panel;
	
	Font myFont = new Font("Times New Roman", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);//Cause the user to not be able to edit the textfield, but are able to edit it once we click on a button
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("/");
		decimalButton = new JButton(".");
		equalButton = new JButton("=");
		deleteButton = new JButton("Delete");
		clearButton = new JButton("Clear");
		negativeButton = new JButton("(-)");
		
		functionButton[0] = addButton;
		functionButton[1] = subButton;
		functionButton[2] = mulButton;
		functionButton[3] = divButton;
		functionButton[4] = decimalButton;
		functionButton[5] = equalButton;
		functionButton[6] = deleteButton;
		functionButton[7] = clearButton;
		functionButton[8] = negativeButton;

		for(int i = 0; i < functionButton.length; i++) {
			functionButton[i].addActionListener(this);
			functionButton[i].setFont(myFont);
			functionButton[i].setFocusable(false);
		}
		
		
		for(int i = 0; i < numberButton.length; i++) {
			numberButton[i] = new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFont(myFont);
			numberButton[i].setFocusable(false);
		}
		
		negativeButton.setBounds(50, 430, 100, 50);
		deleteButton.setBounds(150, 430, 100, 50);
		clearButton.setBounds(255, 430, 100, 50);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		//panel.setBackground(Color.GRAY);
		
		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(addButton);
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(subButton);
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(mulButton);
		panel.add(decimalButton);
		panel.add(numberButton[0]);
		panel.add(equalButton);
		panel.add(divButton);
		

		frame.add(panel);
		frame.add(negativeButton);
		frame.add(deleteButton);
		frame.add(clearButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Calculator calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButton[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));//Concat(simple term) - makes the string go to the back
			}
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");//empty the text
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");//empty the text
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = 'x';
			textfield.setText("");//empty the text
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");//empty the text
		}
		if(e.getSource() == equalButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator){
				case'+':
					result = num1 + num2;
					break;
				case'-':
					result = num1 - num2;
					break;
				case'x':
					result = num1 * num2;
					break;
				case'/':
					result = num1 / num2;
					break;
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clearButton) {
			textfield.setText("");
		}
		if(e.getSource() == deleteButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length() - 1; i++) {//basically delete the text with "string.length() - 1" Ex."hello" the length - 1 cause it to be hell
				textfield.setText(textfield.getText() + string.charAt(i));//set text to hell
			}
		}
		if(e.getSource() == negativeButton) {
			if(textfield.getText() == "") {
				num1 = Double.parseDouble(textfield.getText());
				textfield.setText("-" + num1);
			}
			else {
				double temp = Double.parseDouble(textfield.getText());
				temp *= -1;
				textfield.setText(String.valueOf(temp));//String.valueOf(temp) cause the temp String to not be non editable (their values cannot be changed after they are created)
				
			}

		}
	}
}
