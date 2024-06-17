import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.ArrayList;
import javax.swing.JOptionPane;







public class BankGUI implements ActionListener{
    private JFrame frameObjNavigation, frameObjDebit, frameObjCredit;
    private JPanel panelObjNavigation, panelObjDebit, panelObjCredit;
    
    
    
    
    private JButton buttonDebitCard, buttonCreditCard, buttonAddDebitCard, buttonGoBackDebit, buttonGoBackCredit, buttonWithdraw, buttonDisplayDebit, buttonDisplayCredit, buttonClearDebit, buttonAddCreditCard, buttonCancelCreditCard, buttonSetCreditLimit, buttonClearCredit;
     
    
    private Font font1, fontLabelDebit, fontDebit, fontButtonDebit, fontCredit, fontLabelCredit, fontButtonCredit;
    
    
    private JLabel labelTitle, labelCardIdDebit, labelCardIdCredit, labelBalanceAmountDebit, labelBalanceAmountCredit, labelBankAccountDebit, labelBankAccountCredit, labelIssuerBankDebit, labelIssuerBankCredit, labelClientNameDebit, labelClientNameCredit, labelPinNumber, labelWithdrawalAmount, labelDateOfWithdrawal, labelCvcNumber, labelInterestRate, labelExpirationDate, labelCreditLimit, labelGracePeriod;
   
    
    private JTextField textCardIdDebit,textCardIdCredit, textBalanceAmountDebit, textBalanceAmountCredit, textClientNameCredit, textBankAccountDebit, textBankAccountCredit, textIssuerBankDebit, textIssuerBankCredit, textClientNameDebit, textPinNumber, textWithdrawalAmount, textCvcNumber, textCreditLimit, textInterestRate, textGracePeriod;
     
    
    
    private JComboBox comboDays, comboMonths, comboYears;
    
    
    
    
    
    
    
    
    
     
    
    //The array list is created to store the object
    ArrayList<Bank_card> Arr_list = new ArrayList<Bank_card>();
    
    //main method is declared to implement GUI
    public static void main(String[] args){
        BankGUI cmd = new BankGUI();
        cmd.selection();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == buttonDebitCard)
        {
            JOptionPane.showMessageDialog(panelObjNavigation, "DEBIT CARD SELECTED");
            debitCard();
            frameObjNavigation.dispose();
            
        }
        
        else if (e.getSource() == buttonCreditCard)
        {
            JOptionPane.showMessageDialog(panelObjNavigation, "CREDIT CARD SELECTED");
            creditCard();
            frameObjNavigation.dispose();
        }
        
        
        else if (e.getSource() == buttonAddDebitCard)
        {
            
            try{
                int intBalanceAmountDebit = Integer.parseInt(textBalanceAmountDebit.getText());
                int intCardIdDebit = Integer.parseInt(textCardIdDebit.getText());
                String bankAccountDebit = textBankAccountDebit.getText();
                String issuerBankDebit = textIssuerBankDebit.getText();
                String clientNameDebit = textClientNameDebit.getText();
                int intPinNumberDebit = Integer.parseInt(textPinNumber.getText());
                
                
                // to Check if the intCardIdDebit already exists
                boolean cardIdExists = false;
                
                 for (Bank_card debitObj : Arr_list) {
                     //using instanceof to check if bankObj is an Debit_card class
                      
             
                    if (debitObj instanceof Debit_card)
                    {   
                        //Down casting to Debit card
                        Debit_card debitCardObj = (Debit_card) debitObj;
                        if(debitObj.getcard_id() == intCardIdDebit)
                        {
                        cardIdExists = true;
                        break;
                        }
                    }
                    
                }
                
                
                
                if(cardIdExists == false){
                    //creating an object of Debit_card
                    Debit_card objDebitCard = new Debit_card(intBalanceAmountDebit, intCardIdDebit, bankAccountDebit, issuerBankDebit, clientNameDebit, intPinNumberDebit);
                    //adding the object into Bank_cards arraylist
                    
                    Arr_list.add(objDebitCard);
                    JOptionPane.showMessageDialog(panelObjDebit, "Successfully added!!!\nCard Id = " + intCardIdDebit + "\nIssuer Bank = " + issuerBankDebit+"\nBalance Amount = " + intBalanceAmountDebit + "\nClient Name = " + clientNameDebit + "\nBank Account = " + bankAccountDebit + "\nPin number = " + intPinNumberDebit);
                }
                
                else if (cardIdExists == true){
                    JOptionPane.showMessageDialog(panelObjDebit, "Error!!!\nCard id " + intCardIdDebit + " already exists");
                }
                
                
                
                
                
            
            } catch(NumberFormatException a) {
                JOptionPane.showMessageDialog(panelObjDebit, "Invalid input, please enter a digit");
            }   
           
        }    
        
         else if(e.getSource() == buttonClearDebit)
        {
            //System.out.println("Clear button has been clicked");
            textCardIdDebit.setText(null);
            textBalanceAmountDebit.setText(null);
            textBankAccountDebit.setText(null);
            textIssuerBankDebit.setText(null);
            textClientNameDebit.setText(null);
            textPinNumber.setText(null);
            textWithdrawalAmount.setText(null);
        
        }
        

        
        else if(e.getSource() == buttonWithdraw)
        {
            try{
                int intCardIdDebit = Integer.parseInt(textCardIdDebit.getText());
                int intPinNumberDebit = Integer.parseInt(textPinNumber.getText());
                int intWithdrawAmountDebit = Integer.parseInt(textWithdrawalAmount.getText());
                String withdrawDate =  comboDays.getSelectedItem().toString()  + ","+ comboMonths.getSelectedItem().toString() +","+ comboYears.getSelectedItem().toString();
                
                 for (Bank_card debitObj : Arr_list) {
                          
                 
                        if (debitObj instanceof Debit_card)
                        {   
                            //Down casting
                            Debit_card debitCardObj = (Debit_card) debitObj;
                            if(debitCardObj.getcard_id() == intCardIdDebit)
                            {
                                //JOptionPane.showMessageDialog(panelObjDebit, "Card Id : " + intCardIdDebit + "\nAmount Withdrawn : " + intWithdrawAmountDebit + "\nDate of Withdraw :" + withdrawDate + "\nPIN Number : " + intPinNumberDebit);
                                if (intPinNumberDebit == debitCardObj.getPIN_number()){
                                    
                                
                                    if(intWithdrawAmountDebit <= debitCardObj.getbalance_amount()){
                                        /////code to be executed
                                        debitCardObj.withdraw(intWithdrawAmountDebit, withdrawDate, intPinNumberDebit);
                                        JOptionPane.showMessageDialog(panelObjDebit, "Card Id : " + intCardIdDebit + "\nAmount Withdrawn : " + intWithdrawAmountDebit + "\nDate of Withdraw :" + withdrawDate + "\nPIN Number : " + intPinNumberDebit + "\nNew Balance : " +  debitCardObj.getbalance_amount());
                                        textBalanceAmountDebit.setText(Integer.toString(debitCardObj.getbalance_amount()));
                                        break;
                                    }
                                
                                    else{
                                        JOptionPane.showMessageDialog(panelObjDebit, "Sorry!!!\nInsufficient Amount");
                                        break;
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(panelObjDebit, "Invalid PIN!!!");
                                    break;
                                }
                            }
                            
                            
                            else {
                            JOptionPane.showMessageDialog(panelObjDebit, "Card Id : " + intCardIdDebit + " is invalid");
                            }
                        }
                }
            }
            catch(NumberFormatException a) {
                JOptionPane.showMessageDialog(panelObjDebit, "Invalid input, please enter a valid withdraw amount");
            }   
           
        }
        
         else if(e.getSource() == buttonDisplayDebit)
        {
             for (Bank_card debitObj : Arr_list) {
                      
             
                    if (debitObj instanceof Debit_card)
                    {   
                        //Down casting
                        Debit_card debitCardObj = (Debit_card) debitObj;
                        debitCardObj.display();
                        JOptionPane.showMessageDialog(panelObjDebit, "PIN number : " + debitCardObj.getPIN_number() + "\nWithdrawal amount : " + debitCardObj.getWithdrawal_amount() + "\nDate of Withdrawal : " + debitCardObj.getdate_of_withdrawal() );  
                        
                            
                        }
            }
        }   
        
         else if(e.getSource() == buttonGoBackDebit)
        {
            selection();
            frameObjDebit.dispose();
        }
        
        
        
        else if (e.getSource() == buttonAddCreditCard)
        {
            try{
               int intCardIdCredit = Integer.parseInt(textCardIdCredit.getText()); 
               String clientNameCredit = textClientNameCredit.getText();
               String issuerBankCredit = textIssuerBankCredit.getText();
               String bankAccountCredit = textBankAccountCredit.getText();
               int balanceAmount = Integer.parseInt(textBalanceAmountCredit.getText());
               int intCvcNumberCredit = Integer.parseInt(textCvcNumber.getText());
               double doubleInterestRate = Double.parseDouble(textInterestRate.getText());
               String expirationDate =  comboDays.getSelectedItem().toString() + "," + comboMonths.getSelectedItem().toString() + "," + comboYears.getSelectedItem().toString();
               
               
               boolean creditCardIdExists = false;
               
               for (Bank_card creditObj : Arr_list) {
                   if(creditObj instanceof Credit_card) {
                       //downcasting
                       Credit_card creditCardObj = (Credit_card) creditObj;
                       if(creditObj.getcard_id() == intCardIdCredit) {
                       creditCardIdExists = true;
                       break;
                   }
                }
                   
               }
               
               if(creditCardIdExists == false){
                   //Creating an object of Credit card 
                   Credit_card objCreditCard = new Credit_card(intCardIdCredit, clientNameCredit, issuerBankCredit, bankAccountCredit, balanceAmount, intCvcNumberCredit, doubleInterestRate, expirationDate);
                    Arr_list.add(objCreditCard);
                   JOptionPane.showMessageDialog(panelObjCredit, "Successfully added!!!\nCard id = " + intCardIdCredit + "\nIssuer Bank = " + issuerBankCredit + "\n Balance Amount =  " + balanceAmount + "\nClient Name = " + clientNameCredit + "\nBank Account = " + bankAccountCredit + "\nCVC Number = " + intCvcNumberCredit + "\nInterest Rate = " + doubleInterestRate + "\nExpiration Date = " + expirationDate );
                }
               
               else if(creditCardIdExists == true) {
                   JOptionPane.showMessageDialog(panelObjCredit, "Error!!!!\n Card id " + intCardIdCredit + " already exists" );
               }
               
               
            } catch(NumberFormatException a) {
                JOptionPane.showMessageDialog(panelObjCredit, "Invalid input, please enter a digit");
            }
        }
        
       
        
        else if(e.getSource() == buttonGoBackCredit)
        {
            selection();
            frameObjCredit.dispose();
        }
        
        
        
        
       
        
        else if(e.getSource() == buttonDisplayCredit)
        {
            for (Bank_card creditObj : Arr_list) {
                if (creditObj instanceof Credit_card) {
                    Credit_card creditCardObj = (Credit_card) creditObj;
                    creditCardObj.display();
                    JOptionPane.showMessageDialog(panelObjCredit, "CVC number : " + creditCardObj.getCVC_number() + "\nIntersest rate : " + creditCardObj. getInterest_rate() + "\nCredit Limit : " + creditCardObj.getCredit_limit() + "\nExpiration date : " + creditCardObj.getExpiration_date() + "\nGrace Period : " + creditCardObj.getGrace_period());
                }
            }
        }
        
        
        

        else if(e.getSource() == buttonClearCredit)
        {
            textCardIdCredit.setText(null);
            textBalanceAmountCredit.setText(null);
            textBankAccountCredit.setText(null);
            textIssuerBankCredit.setText(null);
            textClientNameCredit.setText(null);
            
            
            textCvcNumber.setText(null);
            textInterestRate.setText(null);
            textCreditLimit.setText(null);
            textGracePeriod.setText(null);
        }
        else if(e.getSource() == buttonSetCreditLimit)
        {
            try{
                int intCardIdCredit = Integer.parseInt(textCardIdCredit.getText()); 
                int intCreditLimit = Integer.parseInt(textCreditLimit.getText());
                int intGracePeriod = Integer.parseInt(textGracePeriod.getText());
                int intCvcNumber = Integer.parseInt(textCvcNumber.getText());
                
                for (Bank_card creditObj : Arr_list) {
                       if(creditObj instanceof Credit_card) {
                           //downcasting
                           Credit_card creditCardObj = (Credit_card) creditObj;
                           
                           if(intCardIdCredit == creditObj.getcard_id()){
                                if (intCvcNumber == creditCardObj.getCVC_number()){
                                   if (intCreditLimit <= 2.5*(creditCardObj.getbalance_amount())){
                                       creditCardObj.setCredit_limit(intCreditLimit, intGracePeriod);
                                       JOptionPane.showMessageDialog(panelObjCredit, "Updated Successfully!!\nCredit Limit : " + intCreditLimit + "\nGrace Period : " + intGracePeriod);
                                       break;
                                   }
                                   else{
                                       JOptionPane.showMessageDialog(panelObjCredit,"Sorry the credit limit can not be issued");
                                       break;
                                   }
                                }
                                else{
                                    JOptionPane.showMessageDialog(panelObjCredit,"Invalid CVC number");
                                    break;
                                }
                            }
                           else {
                               JOptionPane.showMessageDialog(panelObjCredit, "Card Id : " + intCardIdCredit + " is invalid!!!");
                           }
                        }
                    
                    
                }
                
            }
            catch(NumberFormatException a) {
                JOptionPane.showMessageDialog(panelObjCredit, "Invalid input, please enter a digit");
            }
        }
        
        else if(e.getSource() == buttonCancelCreditCard) {
            int intCardIdCredit = Integer.parseInt(textCardIdCredit.getText());
            
            for(Bank_card creditObj : Arr_list) {
                if (creditObj instanceof Credit_card) {
                    //downcasting
                    Credit_card creditCardObj = (Credit_card) creditObj;
                    
                    if (intCardIdCredit == creditObj.getcard_id()) {
                        creditCardObj.cancelCredit_card();
                        JOptionPane.showMessageDialog(panelObjCredit, "Your card of Card id. " + intCardIdCredit + " has been cancelled.");
    
                    }
                    else {
                        JOptionPane.showMessageDialog(panelObjCredit, "Invalid Card id!!!!\nNo Card id. " + intCardIdCredit + " in the record.");
                    }
                }
            }
        }
    }
    //method "selection()" is for navigating to debitCard and creditCard method
    
    
    public void selection()
    {   
        Color select = new Color(173, 216, 230);
        
        
        
        //JFrame
        frameObjNavigation = new JFrame();
        frameObjNavigation.setTitle("Navigation");
        frameObjNavigation.setBounds(0, 0 , 850, 800);
        frameObjNavigation.setLayout(null);
        
        //JPanel
        panelObjNavigation = new JPanel();
        panelObjNavigation.setBounds(0, 0, 850, 800);
        panelObjNavigation.setLayout(null);
        panelObjNavigation.setBackground(select);
        
        
        
        //Font
        font1 = new Font("Arial", Font.BOLD, 65);
        
        
        
        //JButton for navigating to debitcard method
        buttonDebitCard = new JButton("Debit Card");
        buttonDebitCard.setBounds(120, 250, 600, 120);
        buttonDebitCard.addActionListener(this);
        buttonDebitCard.setFont(font1);
        
        
        
        
        
        //JButton for navigating to creditcard method
        buttonCreditCard = new JButton("Credit Card");
        buttonCreditCard.setBounds(125, 450, 600, 120);
        buttonCreditCard.addActionListener(this);
        buttonCreditCard.setFont(font1);
        
        
        
        panelObjNavigation.add(buttonDebitCard);
        panelObjNavigation.add(buttonCreditCard);
        frameObjNavigation.add(panelObjNavigation);
        frameObjNavigation.setVisible(true);
        frameObjNavigation.setResizable(false);
    }
    
    
    
    
    public void debitCard() 
    {
      Color debit = new Color(173, 216, 230);  
        
        
      //JFrame  
      frameObjDebit = new JFrame();
      frameObjDebit.setTitle("Debit Card");
      frameObjDebit.setBounds(0, 0, 850, 800);
      frameObjDebit.setLayout(null);
      
      //JPanel
      panelObjDebit = new JPanel();
      panelObjDebit.setBounds(0, 0, 850, 800);
      panelObjDebit.setBackground(debit);
      panelObjDebit.setLayout(null);
      
      
      //font
      fontDebit = new Font("Arial", Font.BOLD, 45);
        
      
      //font for JLabel  
      fontLabelDebit = new Font("Arial", Font.BOLD, 20);
      
      //font for buttons
      fontButtonDebit = new Font("Arial", Font.BOLD, 25);
      
      //Color cc = new Color(0,0,0);
        
      //Title
      labelTitle = new JLabel("Debit Card");
      labelTitle.setBounds(300, 10, 400, 45);
      labelTitle.setFont(fontDebit);
      
      //Card Id
      labelCardIdDebit = new JLabel("Card Id: ");
      labelCardIdDebit.setBounds(20, 75, 200, 30);
      labelCardIdDebit.setFont(fontLabelDebit);
      
      textCardIdDebit = new JTextField();
      textCardIdDebit.setBounds(225, 75, 180, 30);
      
      
      
      //balance Amount
      labelBalanceAmountDebit = new JLabel("Balance Amount: ");
      labelBalanceAmountDebit.setBounds(20, 115, 200, 30);
      labelBalanceAmountDebit.setFont(fontLabelDebit);
    
      
      textBalanceAmountDebit = new JTextField();
      textBalanceAmountDebit.setBounds(225, 115, 180, 30);
      
      
      
      //Bank Account
      labelBankAccountDebit = new JLabel("Bank Account: ");
      labelBankAccountDebit.setBounds(20, 155, 200, 30);
      labelBankAccountDebit.setFont(fontLabelDebit);
      
      
      textBankAccountDebit = new JTextField();
      textBankAccountDebit.setBounds(225, 155, 180, 30);
      
      
      
      //Issuer Bank
      labelIssuerBankDebit = new JLabel("Issuer Bank: ");
      labelIssuerBankDebit.setBounds(450, 75, 180, 30);
      labelIssuerBankDebit.setFont(fontLabelDebit);
      
      textIssuerBankDebit = new JTextField();
      textIssuerBankDebit.setBounds(635, 75, 180, 30);
      
      
      //client name
      labelClientNameDebit = new JLabel("Client Name: ");
      labelClientNameDebit.setBounds(450, 115, 180, 30);
      labelClientNameDebit.setFont(fontLabelDebit);
      
      textClientNameDebit = new JTextField();
      textClientNameDebit.setBounds(635, 115, 180, 30);
      
      
      
    
      //PIN number
      labelPinNumber = new JLabel("PIN Number: ");
      labelPinNumber.setBounds(450, 155, 180, 30);
      labelPinNumber.setFont(fontLabelDebit);
      
      textPinNumber = new JTextField();
      textPinNumber.setBounds(635, 155, 180, 30);
      
      
      
      //button to add debit card
      buttonAddDebitCard = new JButton("Add Debit Card");
      buttonAddDebitCard.setBounds(585, 215, 230, 50);
      buttonAddDebitCard.addActionListener(this);
      buttonAddDebitCard.setFont(fontButtonDebit);
      
      
      
      
      //withdrawal amount
      labelWithdrawalAmount = new JLabel("Withdrawal Amount: ");
      labelWithdrawalAmount.setBounds(20, 290, 200, 30);
      labelWithdrawalAmount.setFont(fontLabelDebit);
      
      
      textWithdrawalAmount = new JTextField();
      textWithdrawalAmount.setBounds(225, 290, 180, 30);
      
      
      
      //Date of withdrawal
      labelDateOfWithdrawal = new JLabel("Date of Withdrawal: ");
      labelDateOfWithdrawal.setBounds(20, 330, 200, 30);
      labelDateOfWithdrawal.setFont(fontLabelDebit);
      
      comboDays = new JComboBox();
      comboDays.setBounds(225, 330, 50, 30);
      for (int i = 1; i <= 31; i++){
          comboDays.addItem(i);
      }
      
      
      
      String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
      comboMonths = new JComboBox(months);
      comboMonths.setBounds(280, 330, 100, 30);
      
      comboYears = new JComboBox();
      comboYears.setBounds(385, 330, 100, 30);
      for (int i = 2000; i <= 2023; i++){
          comboYears.addItem(i);
      }
      
      
      //withdraw button
      buttonWithdraw = new JButton("Withdraw");
      buttonWithdraw.setBounds(480, 390, 160, 50);
      buttonWithdraw.addActionListener(this);
      buttonWithdraw.setFont(fontButtonDebit);
      
      
      //display button
      buttonDisplayDebit = new JButton("Display");
      buttonDisplayDebit.setBounds(655, 390, 160, 50);
      buttonDisplayDebit.addActionListener(this);
      buttonDisplayDebit.setFont(fontButtonDebit);
      
      
      //clear Button
      buttonClearDebit = new JButton("Clear");
      buttonClearDebit.setBounds(695, 470, 120, 50);
      buttonClearDebit.addActionListener(this);
      buttonClearDebit.setFont(fontButtonDebit);
      
      
      //button to go back to navigation
      buttonGoBackDebit = new JButton("Go Back");
      buttonGoBackDebit.setBounds(665, 550, 150, 50);
      buttonGoBackDebit.addActionListener(this);
      buttonGoBackDebit.setFont(fontButtonDebit);
      
      
      panelObjDebit.add(buttonClearDebit);
      panelObjDebit.add(buttonDisplayDebit);
      panelObjDebit.add(buttonWithdraw);
      panelObjDebit.add(comboYears);
      panelObjDebit.add(comboMonths);
      panelObjDebit.add(comboDays);
      panelObjDebit.add(labelDateOfWithdrawal);
      panelObjDebit.add(textWithdrawalAmount);
      panelObjDebit.add(labelWithdrawalAmount);
      panelObjDebit.add(buttonGoBackDebit);
      panelObjDebit.add(buttonAddDebitCard);
      panelObjDebit.add(textPinNumber);
      panelObjDebit.add(labelPinNumber);
      panelObjDebit.add(textClientNameDebit);
      panelObjDebit.add(labelClientNameDebit);
      panelObjDebit.add(textIssuerBankDebit);
      panelObjDebit.add(labelIssuerBankDebit);
      panelObjDebit.add(labelBankAccountDebit);
      panelObjDebit.add(textBankAccountDebit);
      panelObjDebit.add(textBalanceAmountDebit);
      panelObjDebit.add(labelBalanceAmountDebit);
      panelObjDebit.add(textCardIdDebit);
      panelObjDebit.add(labelCardIdDebit);  
      panelObjDebit.add(labelTitle);
      frameObjDebit.add(panelObjDebit);
      frameObjDebit.setResizable(false);
      frameObjDebit.setVisible(true);
    }
    
    
    
    public void creditCard()
    {
      Color credit = new Color(173, 216, 230);  
        
        
        
        //JFrame  
      frameObjCredit = new JFrame();
      frameObjCredit.setTitle("Credit Card");
      frameObjCredit.setBounds(0, 0, 850, 800);
      frameObjCredit.setLayout(null);
      
      //JPanel
      panelObjCredit = new JPanel();
      panelObjCredit.setBounds(0, 0, 850, 800);
      panelObjCredit.setBackground(credit);
      panelObjCredit.setLayout(null);
      
      
      //font
      fontCredit = new Font("Arial", Font.BOLD, 45);
      
      
      fontLabelCredit = new Font("Arial", Font.BOLD, 20);
      
      fontButtonCredit = new Font("Arial", Font.BOLD, 25);
      
      //Title
      labelTitle = new JLabel("Credit Card");
      labelTitle.setBounds(310, 10, 400, 50);
      labelTitle.setFont(fontCredit);
      
      //Card Id
      labelCardIdCredit = new JLabel("Card Id: ");
      labelCardIdCredit.setBounds(20, 75, 180, 30);
      labelCardIdCredit.setFont(fontLabelCredit);
      
      textCardIdCredit = new JTextField();
      textCardIdCredit.setBounds(205, 75, 180, 30);
      
      
      //balance Amount
      labelBalanceAmountCredit = new JLabel("Balance Amount: ");
      labelBalanceAmountCredit.setBounds(20, 115, 180, 30);
      labelBalanceAmountCredit.setFont(fontLabelCredit);
      
      
      textBalanceAmountCredit = new JTextField();
      textBalanceAmountCredit.setBounds(205, 115, 180, 30);
      
      //Bank Account
      labelBankAccountCredit = new JLabel("Bank Account: ");
      labelBankAccountCredit.setBounds(20, 155, 180, 30);
      labelBankAccountCredit.setFont(fontLabelCredit);
      
      textBankAccountCredit = new JTextField();
      textBankAccountCredit.setBounds(205, 155, 180, 30);
      
      
      
      //Issuer Bank
      labelIssuerBankCredit = new JLabel("Issuer Bank: ");
      labelIssuerBankCredit.setBounds(450, 75, 180, 30);
      labelIssuerBankCredit.setFont(fontLabelCredit);
      
      
      textIssuerBankCredit = new JTextField();
      textIssuerBankCredit.setBounds(635, 75, 180, 30);
      
      
      //client name
      labelClientNameCredit = new JLabel("Client Name: ");
      labelClientNameCredit.setBounds(450, 115, 180, 30);
      labelClientNameCredit.setFont(fontLabelCredit);
      
      
      textClientNameCredit = new JTextField();
      textClientNameCredit.setBounds(635, 115, 180, 30);
      
      
      
    
      //CVC number
      labelCvcNumber = new JLabel("CVC Number: ");
      labelCvcNumber.setBounds(450, 155, 180, 30);
      labelCvcNumber.setFont(fontLabelCredit);
      
      textCvcNumber = new JTextField();
      textCvcNumber.setBounds(635, 155, 180, 30);
      
      
      
      //button to add Credit card
      buttonAddCreditCard = new JButton("Add Credit Card");
      buttonAddCreditCard.setBounds(300, 215, 250, 50);
      buttonAddCreditCard.setFont(fontButtonCredit);
      buttonAddCreditCard.addActionListener(this);
      
      
      //button to cancel credit card
      buttonCancelCreditCard = new JButton("Cancel Credit Card");
      buttonCancelCreditCard.setBounds(535, 295, 280, 50);
      buttonCancelCreditCard.setFont(fontButtonCredit);
      buttonCancelCreditCard.addActionListener(this);
      
      //Interest Rate
      labelInterestRate = new JLabel("Interest Rate: ");
      labelInterestRate.setBounds(20, 365, 180, 30);
      labelInterestRate.setFont(fontLabelCredit);
      
      textInterestRate = new JTextField();
      textInterestRate.setBounds(205, 365, 180, 30);
      
      
      
      //Expiration date
      labelExpirationDate = new JLabel("Expiration Date: ");
      labelExpirationDate.setBounds(20, 405, 180, 30);
      labelExpirationDate.setFont(fontLabelCredit);
      
      comboDays = new JComboBox();
      comboDays.setBounds(205, 405, 50, 30);
      for (int i = 1; i <= 31; i++){
          comboDays.addItem(i);
      }
      
      
      
      String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
      comboMonths = new JComboBox(months);
      comboMonths.setBounds(265, 405, 100, 30);
      
      comboYears = new JComboBox();
      comboYears.setBounds(375, 405, 100, 30);
      for (int i = 2000; i <= 2023; i++){
          comboYears.addItem(i);
      }
      
      
      
      //credit limit
      labelCreditLimit = new JLabel("Credit Limit: ");
      labelCreditLimit.setBounds(20, 445, 180, 30);
      labelCreditLimit.setFont(fontLabelCredit);
      
      textCreditLimit = new JTextField();
      textCreditLimit.setBounds(205, 445, 180, 30);
      
      //
      labelGracePeriod = new JLabel("Grace Period: ");
      labelGracePeriod.setBounds(20, 485, 180, 30);
      labelGracePeriod.setFont(fontLabelCredit);
      
      textGracePeriod = new JTextField();
      textGracePeriod.setBounds(205, 485, 180, 30);
      
      
      

      //set credit limit button
      buttonSetCreditLimit = new JButton("Set Credit Limit");
      buttonSetCreditLimit.setBounds(380, 545, 270, 50);
      buttonSetCreditLimit.setFont(fontButtonCredit);
      buttonSetCreditLimit.addActionListener(this);
      
      
      //display button
      buttonDisplayCredit = new JButton("Display");
      buttonDisplayCredit.setBounds(665, 545, 150, 50);
      buttonDisplayCredit.setFont(fontButtonCredit);
      buttonDisplayCredit.addActionListener(this);
      
      
      //clear Button
      buttonClearCredit = new JButton("Clear");
      buttonClearCredit.setBounds(695, 610, 120, 50);
      buttonClearCredit.setFont(fontButtonCredit);
      buttonClearCredit.addActionListener(this);
      
      
      //Go Back Button
      buttonGoBackCredit = new JButton("Go Back");
      buttonGoBackCredit.setBounds(655, 675, 160, 50);
      buttonGoBackCredit.setFont(fontButtonCredit);
      buttonGoBackCredit.addActionListener(this);
      
      
      panelObjCredit.add(buttonGoBackCredit);
      panelObjCredit.add(buttonClearCredit);
      panelObjCredit.add(buttonDisplayCredit);
      panelObjCredit.add(buttonSetCreditLimit);
      panelObjCredit.add(textGracePeriod);
      panelObjCredit.add(labelGracePeriod);
      panelObjCredit.add(textCreditLimit);
      panelObjCredit.add(labelCreditLimit);
      panelObjCredit.add(comboYears);
      panelObjCredit.add(comboMonths);
      panelObjCredit.add(comboDays);
      panelObjCredit.add(labelExpirationDate);
      panelObjCredit.add(textInterestRate);
      panelObjCredit.add(labelInterestRate);
      panelObjCredit.add(buttonCancelCreditCard);
      panelObjCredit.add(buttonAddCreditCard);
      panelObjCredit.add(textCvcNumber);
      panelObjCredit.add(labelCvcNumber);
      panelObjCredit.add(textClientNameCredit);
      panelObjCredit.add(labelClientNameCredit);
      panelObjCredit.add(textIssuerBankCredit);
      panelObjCredit.add(labelIssuerBankCredit);
      panelObjCredit.add(labelBankAccountCredit);
      panelObjCredit.add(textBankAccountCredit);
      panelObjCredit.add(textBalanceAmountCredit);
      panelObjCredit.add(labelBalanceAmountCredit);
      panelObjCredit.add(textCardIdCredit);
      panelObjCredit.add(labelCardIdCredit);  
      panelObjCredit.add(labelTitle);
      frameObjCredit.add(panelObjCredit);
      frameObjCredit.setResizable(false);
      frameObjCredit.setVisible(true);
        
        
        
    }


}
