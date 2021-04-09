package main.people;

import main.estates.Inspection;

import java.util.ArrayList;
import java.util.HashSet;

public class Agent extends Person{
    private HashSet<Buyer> buyers;
    private HashSet<Seller> sellers;
    private ArrayList<Inspection> inspections;

    public Agent(String name) {
        super(name, 0);
        this.buyers = new HashSet<>();
        this.sellers = new HashSet<>();
        this.inspections = new ArrayList<>();
    }

    public void addSeller(Seller s){
        this.sellers.add(s);
    }

    public void addBuyer(Buyer b){
        this.buyers.add(b);
    }

    public void addInspection(Inspection i){
        this.inspections.add(i);
    }

    public void receiveMoneyFromAgency(double money){
        if(money > 0){
            this.money += money;
        }
    }

    @Override
    public String toString() {
        return "agent name: " + this.getName() + ", money balance: " + this.money;
    }



}