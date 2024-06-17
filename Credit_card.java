public class Credit_card extends Bank_card
{
    private int CVC_number;
    private double Credit_limit;                  //attributes
    private double Interest_rate;
    private String Expiration_date;
    private int Grace_period;
    private boolean Isgranted;
    
    
    public Credit_card(int card_id, String client_name, String issuer_bank, String bank_account, int balance_amount, int cvc_number, double interest_rate, String expiration_date)
    {
        super(balance_amount, card_id, bank_account, issuer_bank);             //constructor
        this.setclient_name(client_name);
        this.CVC_number = cvc_number;
        this.Interest_rate = interest_rate;
        this.Expiration_date = expiration_date;
        this.Isgranted = false;
        
    }
    
    //Each attribute with it's accesor methods
    public int getCVC_number() {
        return this.CVC_number;
    }
    
    public double getCredit_limit() {
        return this.Credit_limit;
    }
    
    public double getInterest_rate() {
        return this.Interest_rate;
    }
    
    public String getExpiration_date() {
        return this.Expiration_date;
    }
    
    public int getGrace_period() {
        return this.Grace_period;
    }
    
    public boolean getIsgranted() {
        return this.Isgranted;
    }
    
    
    //mutator method to set the credit limit
    public void setCredit_limit(double Credit_limit, int Grace_period) {
        // to check if credit limit is less than or equal to 2.5 times the balance amount
        if (Credit_limit <= 2.5*super.getbalance_amount()) {
            this.Credit_limit = Credit_limit;
            this.Grace_period = Grace_period;
            this.Isgranted = true;
        }
        else {
            System.out.println("Sorry the credit cannot be issued");
        }
    }
    
    //to cancel credit card
    public void cancelCredit_card() {
        this.CVC_number = 0;
        this.Credit_limit = 0;
        this.Grace_period = 0;
        this.Isgranted = false;
    }
    
    //to display
    public void display() {
       
        if (this.Isgranted == true) {
            super.display();
            System.out.println("CVC number: " +this.CVC_number);
            System.out.println("Interest rate: " +this.Interest_rate);
            System.out.println("Expiration date: " +this.Expiration_date);
            System.out.println("Grace period: " + this.Grace_period);
            System.out.println("Credit limit: " + this.Credit_limit);
            
            }    
        else {
            System.out.println("CVC number: " +this.CVC_number);
            System.out.println("Interest rate: " +this.Interest_rate);
            System.out.println("Expiration date: " +this.Expiration_date);
        }
    }
}
