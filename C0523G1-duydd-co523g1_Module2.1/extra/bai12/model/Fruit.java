package extra.bai12.model;

public class Fruit {
    private int id;
    private String name;
    private String type;
    private String dom; // dom = Date of manufacture
    private String exp; // exp = Expiration date
    private String origin;
    private int price;
    public Fruit() {
    }
    public Fruit(String name, String type, String dom, String exp, String origin, int price) {
        this.name = name;
        this.type = type;
        this.dom = dom;
        this.exp = exp;
        this.origin = origin;
        this.price = price;
    }
    public Fruit(int id, String name, String type, String dom, String exp, String origin, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dom = dom;
        this.exp = exp;
        this.origin = origin;
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + this.id
                + "\nName: " + this.name
                + "\nType: " + this.type
                + "\nDate of manufacture: " + this.dom
                + "\nExpiration date: " + this.exp
                + "\nOrigin: " + this.origin
                + "\nPrice per kilogram: " + "$" + this.price
                + "\n-----------------------------------";
    }
}
