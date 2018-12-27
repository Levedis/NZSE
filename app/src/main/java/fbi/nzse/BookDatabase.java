package fbi.nzse;

import java.util.Vector;

public class BookDatabase {

    private static BookDatabase instance;
    private BookDatabase(){};
    public static synchronized BookDatabase getInstance(){
        if(instance == null) {
            instance = new BookDatabase();
        }
        return instance;
    }
    public Vector<Globals.Book> allBooks;
    public void addBook(Globals.Book addedBook) {
        allBooks.add(addedBook);
    }
}
