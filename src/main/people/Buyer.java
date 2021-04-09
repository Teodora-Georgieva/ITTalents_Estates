package main.people;

import main.estates.Estate;
import main.estates.Inspection;
import main.utils.Validator;

import java.util.ArrayList;
import java.util.Objects;

public class Buyer extends Client{
    private ArrayList<Inspection> inspections;

    public Buyer(String name, double budget) {
        super(name, budget);
        if(Validator.isValidBudget(budget)){
            this.money = budget;
        }
        else{
            this.money = 70000;
        }

        this.inspections = new ArrayList<>();
    }

    @Override
    public void register() {
        Agent agent = this.getAgency().generateRandomAgent();
        agent.addBuyer(this);
        this.setAgent(agent);
    }

    public void declareInspection(Estate estate){
        if(estate.getPrice() < this.money){
            Inspection inspection = new Inspection(estate, this.getAgent(), this);
            this.addInspection(inspection);
            this.getAgent().addInspection(inspection);
            System.out.println(this.getName() + " declared inspection");
        }
        else{
            System.out.println(this.getName() + " doesn't have enough money for this estate so he cannot declare inspection.");
        }
    }

    public void declarePurchase(Estate estate){
        boolean containsEstate = false;
        for (Inspection i : this.inspections) {
            if(i.getEstate().equals(estate)){
                containsEstate = true;
            }
        }

        if(containsEstate){
            double moneyForAgencyFromBuyer = 3.0/100 * estate.getPrice();
            this.getAgency().receiveMoney(moneyForAgencyFromBuyer, this.getAgent());
            this.money-=estate.getPrice();

            double moneyForAgencyFromSeller =  3.0/100 * estate.getPrice();
            this.getAgency().receiveMoney(moneyForAgencyFromSeller, this.getAgent());
            estate.getSeller().money-= moneyForAgencyFromSeller;
            System.out.println("Purchase of an estate is made!");
        }
        else{
            System.out.println(this.getName() + " cannot buy this estate because it is not in his list of inspections.");
        }
    }

    /*
    @Override
    public boolean equals(Object o) {
        //System.out.println("Calling equals() of Buyer");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Buyer buyer = (Buyer) o;
        return money == buyer.money &&
                Objects.equals(inspections, buyer.inspections);
    }

    @Override
    public int hashCode() {
        //System.out.println("Calling hashCode() of Buyer");
        return Objects.hash(super.hashCode(), money, inspections);
    }


     */
    private void addInspection(Inspection i){
        this.inspections.add(i);
    }

    public ArrayList<Inspection> getInspections() {
        return inspections;
    }
}