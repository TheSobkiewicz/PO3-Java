import java.util.HashMap;
public class Bank {


    public  Bank() {
        start ++;
    }

    public void addAccount(Account acc) {

        int val = (100+ (int) (Math.random() * ((999- 100) + 1)));

        acc.setCode(""+start+val);
        accounts.put(acc.getNumber(), acc);
    }

    public void printAccounts() {
        System.out.println();
        for( Account i : accounts.values()) System.out.println(i);
   
    }

    public void transfer(String cr1, String cr2, double val) {
        if(accounts.containsKey(cr1) && accounts.containsKey(cr2)){
            accounts.get(cr1).ReduceBy(val);
            accounts.get(cr2).ReduceBy(-accounts.get(cr2).value(val,accounts.get(cr1).GetCurrency(), accounts.get(cr2).GetCurrency()));
        }
        else System.out.println("Wrong code");
    }


    public String findAccount(String code) {
        if(accounts.containsKey(code)){
        return accounts.get(code).toString();
        } 
        else return "Nie znaleziono\n";
    }

    public void transferToDifferentCurrency(String code, String cr) {
        if(!accounts.containsKey(code)) System.out.println("cannot find this account");
        else accounts.get(code).SetCurrency(cr);
        
    }




    private HashMap<String,Account> accounts = new HashMap<>();

    public static final double EURO = 4.6;
    public static final double USD = 3.95;
    public static final double PLN = 1.0;
    private static int start = 0;




}
