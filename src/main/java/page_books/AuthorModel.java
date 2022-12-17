package page_books;

public class AuthorModel {

    private String authorId;
    private String firstName;
    private String secondName;

    public AuthorModel(String authorId, String firstName, String secondName)
    {
        this.authorId = authorId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getAuthorId(){return authorId;}
    public String getFirstName(){return firstName;}
    public String getSecondName(){return secondName;}

    public void setAuthorId(String authorId){this.authorId = new String(authorId);}
    public void setFirstName(String firstName){this.firstName = new String(firstName);}
    public void setSecondName(String secondName){this.secondName = new String(secondName);}
}
