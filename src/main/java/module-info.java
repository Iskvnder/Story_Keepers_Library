module com.example.story_keepers_library {

    requires javafx.controls;
    requires javafx.media;
    requires mysql.connector.j;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.story_keepers_library to javafx.fxml;
    exports com.example.story_keepers_library;

    opens page_sign_in to javafx.fxml;
    exports page_sign_in;

    opens page_main to javafx.fxml;
    exports page_main;

    opens page_books to javafx.fxml;
    exports page_books;

    opens page_students to javafx.fxml;
    exports page_students;

    opens page_borrows to javafx.fxml;
    exports page_borrows;

    opens DATABASE to javafx.fxml;
    exports DATABASE;
    exports DATABASE.DateFrom;
    opens DATABASE.DateFrom to javafx.fxml;
}
