package page_students;

public class StudentsModel {
    private String studentId;
    private String firstName;
    private String secondName;
    private String gender;
    private String clas;
    private String birthDate;

    public StudentsModel(String studentId, String firstName, String secondName,
                         String gender, String clas, String birthDate)
    {
        this.studentId = studentId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.clas = clas;
        this.birthDate = birthDate;
    }

    public String getStudentId(){return studentId;}
    public String getFirstName(){return firstName;}
    public String getSecondName(){return secondName;}
    public String getGender(){return gender;}
    public String getClas(){return clas;}
    public String getBirthDate(){return birthDate;}

    public void setStudentId(String studentId){this.studentId = new String(studentId);}
    public void setFirstName(String firstName){this.firstName = new String(firstName);}
    public void setSecondName(String secondName){this.secondName = new String(secondName);}
    public void setGender(String gender){this.gender = new String( gender);}
    public void setClas(String clas){this.clas = new String(clas);}
    public void setBirthDate(String birthDate){this.birthDate = new String(birthDate);}
}