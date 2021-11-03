import javax.swing.text.html.HTMLDocument.RunElement;

public class Account {
    static int NUMBER_OF_CREATED_ACCOUNTS = 0;
    

    public Account(String imie, String nazwisko, String waluta)  {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.waluta = waluta;
        saldo = 0;
        NUMBER_OF_CREATED_ACCOUNTS++;
    }


    public Account(String imie, String nazwisko,double saldo, String waluta)  {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.waluta = waluta;
        this.saldo = saldo;
        NUMBER_OF_CREATED_ACCOUNTS++;
    }


    public String getOwner() {
        return imie+" "+nazwisko;
    }

    public String getAccountBalance() {
        return ""+saldo+ " " + waluta;
    }

    public void setBalance (double nval) {
        saldo = nval;
    }


    public String toString() {
        return "firstName= " + imie + " lastName= " + nazwisko + " kod :" + code + " saldo: "+saldo + waluta;
    }

    @Override
    public boolean equals( Object o) {
        if(o == null || o.getClass() != getClass())return false;
        Account acc = (Account) o;
        return (imie == acc.imie && nazwisko == acc.nazwisko && saldo == acc.saldo && code == acc.code && waluta ==acc.waluta);
    }

    public void setCode(String cd) {
        code = cd;
    }
    public String getNumber(){
        return code;
    }

    public void SetCurrency(String cr){
        saldo = value(saldo,waluta,cr);

        waluta = cr;
    }

    public void ReduceBy(double val) {
        saldo=saldo-val;
    }

    public double value (double amount, String waluta, String cr) {
        if (waluta != "PLN") {
            if(waluta == "USD") amount = amount*Bank.USD;
            else if(waluta == "EURO") amount = amount*Bank.EURO;
        }

        if(cr == "USD") amount = amount/Bank.USD;
        else if(cr == "EURO") amount = amount/Bank.EURO;
        return amount;
    }

    public String GetCurrency(){
        return waluta;
    }

    



    





    private String imie;
    private String nazwisko;
    private String waluta;
    private double saldo;
    private String code ="Not assigned to any bank. ";
}
