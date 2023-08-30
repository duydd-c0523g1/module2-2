package extra.custom_mvc.model;

public class Product {
    private int id;
    private String name;
    private String manuDate;
    private String expDate;

    public Product() {
    }

    public Product(int id, String name, String manuDate, String expDate) {
        this.id = id;
        this.name = name;
        this.manuDate = manuDate;
        this.expDate = expDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManuDate() {
        return manuDate;
    }

    public void setManuDate(String manuDate) {
        this.manuDate = manuDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manuDate='" + manuDate + '\'' +
                ", expDate='" + expDate + '\'' +
                '}';
    }
}
