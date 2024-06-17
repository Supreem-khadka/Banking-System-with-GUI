public class Debit_card extends Bank_card
{
    private int PIN_number;
    private int Withdrawal_amount;                   //attributes
    private String date_of_withdrawal;
    private boolean has_Withdrawn;
    
    public Debit_card(int balance_amount, int card_id, String bank_account, String issuer_bank, String client_name, int pin_number)
    {
        super(balance_amount, card_id, bank_account, issuer_bank);
        this.PIN_number = pin_number;                                   //constructors
        this.Withdrawal_amount = 0;
        this.date_of_withdrawal = null;
        this.has_Withdrawn = false;
        this.setclient_name(client_name);
      
    }
             
                                                //getter method
    public int getPIN_number()
    {
        return this.PIN_number;
    }
    
    public int getWithdrawal_amount()
    {
        return this.Withdrawal_amount;
    }
    
    public String getdate_of_withdrawal()
    {
        return this.date_of_withdrawal;
    }
    
    public boolean gethas_Withdrawn()
    {
       return this.has_Withdrawn; 
    }
    
    
    //setter method for the Withdrawal amount attribute
    public void setWithdrawal_amount(int Withdrawal_amount)
    {
      this.Withdrawal_amount = Withdrawal_amount;
    }
    
    
    //method to withdraw money from the debit card
    public void withdraw(int amount, String date, int enterpin)
    {
        if (has_Withdrawn == true){
            System.out.println("You have already withdrawn from this card today.");
        }
        else if (enterpin != PIN_number){
            System.out.println("Invalid pin entered.");
        }
        else if (amount > this.getbalance_amount()){
            System.out.println("Insufficient Balance!!");
        }
        else {
            setbalance_amount(getbalance_amount() - amount);
            this.setWithdrawal_amount(amount);
            this.date_of_withdrawal = date;
            this.has_Withdrawn = true;
            System.out.println("Withdrawal successful!");
            System.out.println("New Balance: " + this.getbalance_amount());
        }
        }
        public void display() {
        super.display(); //to call the display the method in the super class
        
        
         if (has_Withdrawn == true) {
            System.out.println("PIN: " + this.PIN_number);
            System.out.println("Withdrawal Amount: " + this.Withdrawal_amount);
            System.out.println("Date of Withdrawal: " + this.date_of_withdrawal);
            }
        else {
            System.out.println("PIN: " + this.PIN_number);
            }
    }
            
       
}
    
    

