import java.util.ArrayList;

public class Client{
    public String code;
    public Pasport dataPasport;
    public String phone;
    public String addres;
    public ArrayList<Account> accounts;

    Client(){
        accounts = new ArrayList<Account>();
        dataPasport = new Pasport();
        System.out.println("Client");
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setDataPasport(Pasport pasport){
        this.dataPasport = pasport;
    }

    public Pasport getDataPasport(){
        return dataPasport;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public void setAddres(String addres){
        this.addres = addres;
    }

    public String getAddres(){
        return addres;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public boolean delAccount(Account account){
        return accounts.remove(account);
    }

    public ArrayList<Account> getAccount(){
        return accounts;
    }
}