# Banking-System-with-GUI
A banking system with deposit and withdrawal features and implementation of GUI using JAVA

# METHOD DESCRIPTION
main(String[] args) 
It is the main method of the class which creates an object of BankGUI class and assigns 
it to a variable and then call the selection() method to use the GUI. 
actionPerformed (ActionEvent e) 
This method handles the events that occur during the program related to buttons. When 
buttons like buttonDebitCard, buttonCreditCard, ,goBack are used to navigate between 
GUI of different methods. Likewise, buttons buttonAddDebitCard and 
buttonAddCreditCard handled in a way to add the inputs in a Arraylist of their respective 
object. buttonCreditLimit will set all the text fields to null and other buttons like 
buttonWithdraw and buttonCancel will display appropriate messages in a dialog box as 
well as call the methods like withdraw() from their respective objects.  
selection()  
The selection method contains the implementation of the GUI components like JFrame, 
JPanel, JLabel, JTextField and JComboBox. First the objects are created of the 
respective components and are assigned to a variable and then different methods are 
used like setBounds() which takes x-axis, y-axis, breadth and height as the arguments. 
After this is done for all the objects, they are added into the JPanel which will itself get 
added to the JFrame.  
debitCard()  
The debitCard method contains the implementation of the GUI components like JFrame, 
JPanel, JLabel, JTextField and JComboBox. First the objects are created of the 
respective components and are assigned to a variable and then different methods are 
used like setBounds() which takes x-axis, y-axis, breadth and height as the arguments. 
After this is done for all the objects, they are added into the JPanel which will itself get 
added to the JFrame. This method also contains GUI components like JButton and 
JComboBox. 
39 
creditCard() 
The creditCard method contains the implementation of the GUI components like 
JFrame, JPanel, JLabel, JTextField and JComboBox. First the objects are created of 
the respective components and are assigned to a variable and then different methods 
are used like setBounds() which takes x-axis, y-axis, breadth and height as the 
arguments. After this is done for all the objects, they are added into the JPanel which 
will itself get added to the JFrame. This method also contains GUI components like 
JButton and JComboBox.

