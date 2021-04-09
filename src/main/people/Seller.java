package main.people;

import main.estates.Estate;

import java.util.Objects;

public class Seller extends Client{
    private Estate estateToSell;

    public Seller(String name, double money) {
        super(name, money);
    }

    @Override
    public void register() {
        Agent agent = this.getAgency().generateRandomAgent();
        agent.addSeller(this);
        this.setAgent(agent);
        this.getAgency().addEstate(this.estateToSell);
    }

    /*
    @Override
    public boolean equals(Object o) {
        //super.equals(o);
        //System.out.println("Calling equals() of Seller");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Seller seller = (Seller) o;
        return Objects.equals(estateToSell, seller.estateToSell);
    }
*/
    //@Override
    /*
    public int hashCode() {
        //super.hashCode();
        //System.out.println("Calling hashCode() of Seller");
        return Objects.hash(super.hashCode(), estateToSell);
    }
*/
    public void setEstateToSell(Estate estateToSell) {
        this.estateToSell = estateToSell;
    }

}