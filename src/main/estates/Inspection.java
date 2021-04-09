package main.estates;

import main.people.Agent;
import main.people.Buyer;

public class Inspection {
    private Estate estate;
    private Agent agent;
    private Buyer buyer;
    private String date;

    public Inspection(Estate estate, Agent agent, Buyer buyer) {
        this.estate = estate;
        this.agent = agent;
        this.buyer = buyer;
        this.date = "15-03-2021";
    }

    public Estate getEstate() {
        return estate;
    }
}