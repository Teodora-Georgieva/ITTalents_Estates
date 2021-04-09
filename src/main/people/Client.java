package main.people;

import main.Agency;

public abstract class Client extends Person{
    private Agency agency;
    private Agent agent;

    Client(String name, double money) {
        super(name, money);
    }

    public abstract void register();

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Agent getAgent() {
        return agent;
    }
}