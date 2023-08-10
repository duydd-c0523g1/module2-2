package extra.bai7;

public class SocialBook extends Book implements IBook{
    private String author;
    public SocialBook() {
    }

    public SocialBook(String bookName, String yearPublic, String publisher, String author) {
        super(bookName, yearPublic, publisher);
        this.author = author;
    }

    @Override
    public void display() {
        System.out.println(super.toString() + " author: " + this.author);
    }
}
