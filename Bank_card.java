
/**
 * @author (Supreem)
 * @version (1/5/2023)
 */


public class Bank_card
{
    private int card_id;           //attributes
    private String client_name;
    private String issuer_bank;
    private String bank_account;
    private int Balance_Amount;
    
    public Bank_card(int balance_amount, int card_id, String bank_account, String issuer_bank)
    {
        this.client_name = "";            //constructor
        this.Balance_Amount = balance_amount;
        this.card_id = card_id;
        this.bank_account = bank_account;
        this.issuer_bank = issuer_bank;    
    }
                                    
                            //getter methods
    public int getcard_id()
    {
        return this.card_id;
    }
    
    public String getclient_name()
    {
        return this.client_name;
    }
    
    public String getissuer_bank()
    {
        return this.issuer_bank;
    }
    
    public String getbank_account()
    {
        return this.bank_account;
    }
    
    public int getbalance_amount()
    {
        return this.Balance_Amount;
    }
    
    
                                    //setter methods
    public void setbalance_amount(int balance_amount)
    {
        this.Balance_Amount = balance_amount;
    }  
    
    public void setclient_name(String client_name)
    {
        this.client_name = client_name;
    }
    
    
                        //display method
    public void display()
    {
        System.out.println("Card Id: "+getcard_id());
        System.out.println("Client Name: "+getclient_name());
        System.out.println("Issuer Bank: "+getissuer_bank());
        System.out.println("Bank Account"+getbank_account());
        System.out.println("Balance Amount"+getbalance_amount());
        if(this.client_name=="")
        {
            System.out.println("Client name is not assigned.");
        }else
            {
                System.out.println("The client name is: " +getclient_name());
            }
        
    }
}
