import java.util.Date;

public class Man{
    public String name;
    public String surname;
    public String patronymic;
    public Date dateBirth;

    Man(){
        System.out.println("Man");
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }

    public void setDateBirth(Date dateBirth){
        this.dateBirth = dateBirth;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getPatronymic(){
        return patronymic;
    }

    public Date getDateBrith(){
        return dateBirth;
    }
}