package page_borrows;

public class BorrowsModel {
    private String borrowId;
    private String studentId;
    private String bookId;
    private String takeDate;
    private String broughtDate;

    public BorrowsModel(String borrowId, String studentId, String bookId,
                         String takeDate, String broughtDate)
    {
        this.borrowId = borrowId;
        this.studentId = studentId;
        this.bookId = bookId;
        this.takeDate = takeDate;
        this.broughtDate = broughtDate;
    }

    public String getBorrowId(){return borrowId;}

    public String getStudentId(){return studentId;}
    public String getBookId(){return bookId;}
    public String getTakeDate(){return takeDate;}
    public String getBroughtDate(){return broughtDate;}

    public void setBorrowId(String borrowId){this.borrowId = new String(borrowId);}
    public void setStudentId(String studentId){this.studentId = new String(studentId);}
    public void setBookId(String bookId){this.bookId = new String(bookId);}
    public void setTakeDate(String takeDate){this.takeDate = new String( takeDate);}
    public void setBroughtDate(String broughtDate){this.broughtDate = new String(broughtDate);}
}