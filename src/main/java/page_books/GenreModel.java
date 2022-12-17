package page_books;

public class GenreModel {
    private String genreId;
    private String genreName;

    public GenreModel(String genreId, String genreName){
        this.genreId =  genreId;
        this.genreName = genreName;
    }

    public String getGenreId(){return genreId;}
    public String getGenreName(){return genreName;}

    public void setGenreId(String genreId){this.genreId = new String(genreId);}
    public void setGenreName(String genreName){this.genreName = new String(genreName);}
}
