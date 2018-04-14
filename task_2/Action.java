public class Action{
    public int balanceBefore;
    public int balanceAfter;
    public String info;

    Action(){
        System.out.println("Action");
    }

    public void setBalanceBefore(int balance){
        this.balanceBefore = balance;
    }

    public void setBalanceAfter(int balance){
        this.balanceAfter = balance;
    }

    public void setInfo(String info){
        this.info = info;
    }

    public int getBalanceBefore(){
        return balanceBefore;
    }

    public int getBalanceAfter(){
        return balanceAfter;
    }

    public String getInfo(){
        return info;
    }
}