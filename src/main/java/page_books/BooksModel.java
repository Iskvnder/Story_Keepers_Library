package page_books;

public class BooksModel {
    private String bookId;
    private String quantity;
    private String bookName;
    private String pageCount;
    private String authorId;
    private String genreId;
    private String bookDescription;

    public BooksModel(String bookId, String quantity, String bookName,
                         String pageCount, String authorId, String genreId, String bookDescription)
    {
        this.bookId = bookId;
        this.quantity = quantity;
        this.bookName = bookName;
        this.pageCount = pageCount;
        this.authorId = authorId;
        this.genreId = genreId;
        this.bookDescription = bookDescription;
    }

    public String getBookId(){return bookId;}
    public String getQuantity(){return quantity;}
    public String getBookName(){return bookName;}
    public String getPageCount(){return pageCount;}
    public String getAuthorId(){return authorId;}
    public String getGenreId(){return genreId;}
    public String getBookDescription(){return bookDescription;}

    public void setBookId(String studentId){this.bookId = new String(bookId);}
    public void setQuantity(String quantity){this.quantity = new String(quantity);}
    public void setBookName(String bookName){this.bookName = new String(bookName);}
    public void setGender(String pageCount){this.pageCount = new String( pageCount);}
    public void setClas(String authorId){this.authorId = new String(authorId);}
    public void setGenreId(String genreId){this.genreId = new String(genreId);}
    public void setBookDescription(String bookDescription){this.bookDescription = new String(bookDescription);}
}
