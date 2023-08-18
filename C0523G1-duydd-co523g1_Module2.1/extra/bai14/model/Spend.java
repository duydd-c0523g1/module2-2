package extra.bai14.model;

public class Spend {
    private Integer id;
    private String name;
    private String spendDate;
    private float spendAmount;
    private String description;

    public Spend() {
    }
    public Spend(String name, String spendDate, float spendAmount, String description) {
        this.name = name;
        this.spendDate = spendDate;
        this.spendAmount = spendAmount;
        this.description = description;
    }

    public Spend(Integer id, String name, String spendDate, float spendAmount, String description) {
        this.id = id;
        this.name = name;
        this.spendDate = spendDate;
        this.spendAmount = spendAmount;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpendDate() {
        return spendDate;
    }

    public void setSpendDate(String spendDate) {
        this.spendDate = spendDate;
    }

    public float getSpendAmount() {
        return spendAmount;
    }

    public void setSpendAmount(float spendAmount) {
        this.spendAmount = spendAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Plan ID: " + this.id
                + "\nName: " + this.name
                + "\nDate: " + this.spendDate
                + "\nAmount: " + "$" + this.spendAmount
                + "\nDescription: " + this.description
                + "\n---------------------------";
    }
}
