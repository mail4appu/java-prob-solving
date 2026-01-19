package java8;

public class Product implements Comparable{
    private String name;
    private String type;
    private String description;
    private String price;
    private String os;


    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", os='" + os + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Product p=(Product)o;
        return p.getName().compareTo(getName());
    }
}
