package extra.bai7;

public class NaturalBook extends Book implements IBook {
    private int publishQuantity;
    public NaturalBook() {
    }

    public NaturalBook(String bookName, String yearPublic, String publisher, int publishQuantity) {
        super(bookName, yearPublic, publisher);
        this.publishQuantity = publishQuantity;
    }

    @Override
    public void display() {
        System.out.println(super.toString() + " quantity: " + this.publishQuantity);
    }
}
