package main;

import main.estates.Estate;
import main.people.Agent;
import main.utils.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;

public class Agency {
    private String name;
    private String address;
    private String phone;
    private HashMap<String, HashMap<String, TreeSet<Estate>>> estatesCatalogue;
    private double moneyBalance;
    private ArrayList<Agent> agents;

    public Agency(String name){
        if(Validator.isValidString(name)){
            this.name = name;
        }
        else{
            this.name = "Talents Estates";
        }

        this.address = "Sofia";
        this.phone = "0888223344";

        this.estatesCatalogue = new HashMap<>();
        this.estatesCatalogue.put("Apartment", new HashMap<>());
        this.estatesCatalogue.get("Apartment").put("Studio", new TreeSet<>());
        this.estatesCatalogue.get("Apartment").put("Garsionera", new TreeSet<>());
        this.estatesCatalogue.get("Apartment").put("Two-Rooms", new TreeSet<>());
        this.estatesCatalogue.get("Apartment").put("Three-Rooms", new TreeSet<>());
        this.estatesCatalogue.get("Apartment").put("Penthouse", new TreeSet<>());

        this.estatesCatalogue.put("House", new HashMap<>());
        this.estatesCatalogue.get("House").put("One-Floor", new TreeSet<>());
        this.estatesCatalogue.get("House").put("Whole-House", new TreeSet<>());

        this.estatesCatalogue.put("Parcel", new HashMap<>());
        this.estatesCatalogue.get("Parcel").put("Field", new TreeSet<>());
        this.estatesCatalogue.get("Parcel").put("Meadow", new TreeSet<>());
        this.estatesCatalogue.get("Parcel").put("Forest", new TreeSet<>());

        this.moneyBalance = 0;
        this.agents = new ArrayList<>();
    }

    public void addAgent(Agent a){
        this.agents.add(a);
    }

    public Agent generateRandomAgent(){
        Random r = new Random();
        return agents.get(r.nextInt(agents.size()));
    }

    public void addEstate(Estate estate){
        String kind = estate.getKind();
        String type = estate.getType();
        this.estatesCatalogue.get(kind).get(type).add(estate);
    }

    public void receiveMoney(double money, Agent agent){
        if(money > 0){
            double moneyForAgent = money/2;
            this.giveMoneyToAgent(agent, moneyForAgent);
            double moneyForAgency = money - moneyForAgent;
            this.moneyBalance += moneyForAgency;
        }
    }

    private void giveMoneyToAgent(Agent a, double money){
        a.receiveMoneyFromAgency(money);
    }

    public HashMap<String, HashMap<String, TreeSet<Estate>>> getEstatesCatalogue() {
        return estatesCatalogue;
    }

    public double getMoneyBalance() {
        return moneyBalance;
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public void printCatalogue(){
        for(String kind : this.estatesCatalogue.keySet()){
            System.out.println(kind);
            for(String type : this.estatesCatalogue.get(kind).keySet()){
                System.out.println("    " + type);
                for(Estate e : this.estatesCatalogue.get(kind).get(type)){
                    System.out.println(e);
                }
            }
        }
    }
}