public class Bank{
    public static void main(String argv[]){
        StatusAccount stAc = new StatusAccount();
        Client cl_1 = new Client();
        cl_1.addAccount(new Account());
        cl_1.addAccount(new Account());
        cl_1.getAccount().get(0).addHistory(new Action());
        Client cl_2 = new Client();
    }
    
}