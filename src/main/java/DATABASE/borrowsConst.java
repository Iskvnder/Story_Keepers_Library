package DATABASE;

public class borrowsConst {

    public static String borrowsTable = "borrows";
    public static String borrowId = "borrow_id";
    public static String studentId = "student_id";
    public static String bookId = "book_id";
    public static String takeDate = "take_date";
    public static String broughtDate = "brought_date";

    public borrowsConst(String borrowId, String studentId, String bookId, String takeDate, String broughtDate){
        this.borrowId = borrowId;
        this.studentId = studentId;
        this.bookId = bookId;
        this.takeDate = takeDate;
        this.broughtDate = broughtDate;
    }
    public String getBorrowId(){return borrowId;}
    public String setBorrowId(String borrowId){
       return borrowsConst.borrowId = borrowId;
    }

    public String getStudentId(){return studentId;}
    public String setStudentId(String studentId){
        return borrowsConst.studentId = studentId;
    }
    public String getBookId(){return bookId;}
    public String setBookId(String bookId){
        return borrowsConst.bookId = bookId;
    }
    public String getTakeDate(){return takeDate;}
    public String getTakeDate(String takeDate){
        return borrowsConst.takeDate = takeDate;
    }
    public String getBroughtDate(){return broughtDate;}
    public String setBroughtDate(String broughtDate){
        return borrowsConst.broughtDate = broughtDate;
    }


}
