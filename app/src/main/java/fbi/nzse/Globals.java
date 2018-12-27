package fbi.nzse;

import android.app.Application;

import java.util.Vector;

public class Globals extends Application {
    private String currentBook;

    public String getCurrentBook() {
        return this.currentBook;
    }
    public void setCurrentBook(String mBook) {
        this.currentBook = mBook;
    }
    public int findCurrentBook() {
        int i;
        for(i = 0; i < bookDatabase.size();i++) {
            if(currentBook == bookDatabase.elementAt(i).name) {
                return i;
            }
        }
        return -1;
    }

    //public BookDatabase myBooks = BookDatabase.getInstance();

    public Vector<Book> bookDatabase = new Vector<Book>();

    public void addBook(Book mBook) {
        bookDatabase.add(mBook);
    }

    public void fillDatabase() {
        Book book1 = new Book(
                "A Song of Ice and Fire",
                "Long ago, in a time forgotten, a preternatural event threw the seasons out of balance. In a land where summers can last decades and winters a lifetime, trouble is brewing. The cold is returning, and in the frozen wastes to the north of Winterfell, sinister forces are massing beyond the kingdom’s protective Wall. To the south, the king’s powers are failing—his most trusted adviser dead under mysterious circumstances and his enemies emerging from the shadows of the throne. At the center of the conflict lie the Starks of Winterfell, a family as harsh and unyielding as the frozen land they were born to. Now Lord Eddard Stark is reluctantly summoned to serve as the king’s new Hand, an appointment that threatens to sunder not only his family but the kingdom itself.",
                "George R.R. Martin",
                "1996");
        bookDatabase.add(book1);
    }


    public class Book {

        public String name;

        public String details;

        public String author;

        public String pubYear;



        public Vector<Exemplar> exemplarVector = new Vector<Exemplar>();


        public Book(String mName, String mDetails, String mAuthor, String mPubYear) {

            this.name = mName;
            this.details = mDetails;
            this.author = mAuthor;
            this.pubYear = mPubYear;

            for(int i=0; i<4;i++) {
                this.exemplarVector.add(new Exemplar());
            }


        }

        public boolean rent() {
            for(int i = 0; i<exemplarVector.size();i++) {
                if(exemplarVector.elementAt(i).isAusgeliehen() == false) {
                    exemplarVector.elementAt(i).setAusgeliehen(true);
                    return exemplarVector.elementAt(i).isAusgeliehen();
                }
            }
            return false;
        }

        public class Exemplar {
            private boolean ausgeliehen;
            public Exemplar() {
                this.ausgeliehen = false;
            }

            public void setAusgeliehen(boolean ausgeliehen) {
                this.ausgeliehen = ausgeliehen;
            }

            public boolean isAusgeliehen() {
                return ausgeliehen;
            }

        }

    }


}

