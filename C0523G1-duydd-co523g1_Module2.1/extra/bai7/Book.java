package extra.bai7;

public abstract class Book implements IBook {
    private String bookName;
    private String yearPublic;
    private String publisher;
    public Book() {
    }

    public Book(String bookName, String yearPublic, String publisher) {
        this.bookName = bookName;
        this.yearPublic = yearPublic;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", yearPublic='" + yearPublic + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
