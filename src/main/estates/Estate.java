package main.estates;

import main.people.Agent;
import main.people.Seller;

import java.util.Objects;

public abstract class Estate implements Comparable<Estate>{
    private String description;
    private String address;
    private double price;
    private double area;
    private Agent agent;
    private String type;
    private Seller seller;

    Estate(double price, String type, Seller seller){
        if(validatePrice(price)){
            this.price = price;
        }
        else{
            this.price = 70000;
        }

        if(validateType(type)){
            this.type = type;
        }
        else{
            this.type = setDefaultType();
        }

        this.description = "nice estate";
        this.address = "Sofia";
        this.area = 200;
        this.seller = seller;
    }

    abstract boolean validatePrice(double price);
    abstract String getValidTypes();
    abstract String setDefaultType();
    public abstract String getKind();

    boolean validateType(String type){
        return getValidTypes().contains(type);
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public String getType() {
        return type;
    }

    @Override
    public int compareTo(Estate o) {
        return ((Double)(o.getPrice())).compareTo((Double)(this.getPrice()));
    }

    public double getPrice() {
        return price;
    }

    public Seller getSeller() {
        return seller;
    }

    @Override
    public String toString() {
        return "Estate{" +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", seller=" + seller.getName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            System.out.println("in equals() of Estate : this == o");
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            System.out.println("in equals() of Estate :");
            if(o == null){
                System.out.println("o == null");
            }
            else if(getClass() != o.getClass()){
                System.out.println("this. class: " + getClass());
                System.out.println("o.classs: " + o.getClass());
                System.out.println("getClass() != o.getClass()");
            }
            return false;
        }
        Estate estate = (Estate) o;
        return Double.compare(estate.price, price) == 0 &&
                Objects.equals(agent, estate.agent) &&
                Objects.equals(type, estate.type) &&
                Objects.equals(seller, estate.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, agent, type, seller);
    }
}