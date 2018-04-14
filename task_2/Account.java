import java.util.ArrayList;

public class Account{
    public StatusAccount status;
    public String code;
    public int balance;
    public ArrayList<Action> history;

    Account(){
        history = new ArrayList<Action>();
        status = new StatusAccount();
        System.out.println("Account");
    }

    public void setStatus(StatusAccount status){
        this.status = status;
    }

    public void setCode(String code){
        this.code = code;
    }

    public StatusAccount getStatus(){
        return status;
    }

    public String getCode(){
        return code;
    }

    public void addBalance(int count){
        balance +=count;
    }

    public boolean subBalance(int count){
        if(count > balance){
            return false;
        }

        balance -= count;
        return true;
    }

    public void addHistory(Action action){
        history.add(action);
    }

    public ArrayList<Action> getHistory(){
        return history;
    }
}