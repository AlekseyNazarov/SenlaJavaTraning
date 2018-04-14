public class StatusAccount{
    public int id;
    public String value;

    public StatusAccount(){
        System.out.println("StatusAccount");
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}