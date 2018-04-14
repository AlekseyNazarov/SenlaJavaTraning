import java.util.Date;

public class Pasport extends Man{
    public String series;
    public String number;
    public String addres;
    public String departamentRegistration;
    public Date dateRegistration;

    Pasport(){
        System.out.println("Pasport");
    }

    public void setSeries(String series){
        this.series = series;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public void setAddres(String addres){
        this.addres = addres;
    }

    public void setDepartamentRegistration(String departamentRegistration){
        this.departamentRegistration = departamentRegistration;
    }

    public void setDateRegistration(Date dateRegistration){
        this.dateRegistration = dateRegistration;
    }

    public String getSeries(){
        return series;
    }

    public String getNumber(){
        return number;
    }

    public String getAddres(){
        return addres;
    }

    public String getDepartamentRegistration(){
        return departamentRegistration;
    }

    public Date getDateRegistration(){
        return dateRegistration;
    }
}