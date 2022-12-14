package page_students;

import java.util.Date;

public class data_students {

    private int student_id;
    private String first_name;
    private String second_name;
    private String gender;
    private String clas;
    private Date birth_date;

    public data_students(int student_id, String first_name,
                         String second_name, String gender,
                         String clas, Date birth_date)
    {
        this.student_id = student_id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.gender = gender;
        this.clas = clas;
        this.birth_date = birth_date;
    }

    public data_students(){}
//getters
    public int getStudent_id(){return student_id;}
    public String getFirst_name(){return first_name;}
    public String getSecond_name(){return second_name;}
    public String getGender(){return gender;}
    public String getClas(){return clas;}
    public Date getBirth_date(){return birth_date;}
    
//setters
    public void setStudent_id(int student_id){this.student_id = student_id;}
    public void setFirst_name(String first_name){this.first_name = first_name;}
    public void setSecond_name(String second_name){this.second_name = second_name;}
    public void setGender(String gender){this.gender = gender;}
    public void setClas(String clas){this.clas = clas;}
    public void setBirth_date(Date birth_date){this.birth_date = birth_date;}



}
