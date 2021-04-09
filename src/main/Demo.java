package main;

import main.estates.Apartment;
import main.estates.Estate;
import main.estates.House;
import main.estates.Parcel;
import main.people.Agent;
import main.people.Buyer;
import main.people.Seller;
import main.utils.Generator;

import java.util.ArrayList;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        Agency talentsEstates = new Agency("Talents Estates");
        for (int i = 0; i < 5; i++) {
            String name = "Agent" + (i+1);
            talentsEstates.addAgent(new Agent(name));
        }

        ArrayList<Seller> sellers = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            String sellerName = "Seller" + (i+1);
            double money = Generator.generateRandomBudget(5000, 20000);
            Seller seller = new Seller(sellerName, money);
            seller.setAgency(talentsEstates);
            int num = r.nextInt(3);
            Estate estate = null;
            double price;
            String type;

            switch (num){
                case 0:
                    price = Generator.generatePriceForEstate(70000, 150000);
                    type = Generator.generateTypeForApartment();
                    estate = new Apartment(price, type, seller);
                    break;
                case 1:
                    price = Generator.generatePriceForEstate(50000, 80000);
                    type = Generator.generateTypeForHouse();
                    estate = new House(price, type, seller);
                    break;
                case 2:
                    price = Generator.generatePriceForEstate(30000, 85000);
                    type = Generator.generateTypeForParcel();
                    estate = new Parcel(price, type, seller);
                    break;
            }

            seller.setEstateToSell(estate);
            seller.register();
            sellers.add(seller);
            talentsEstates.addEstate(estate);
        }

        System.out.println("Printing catalogue with estates: ");
        talentsEstates.printCatalogue();
        System.out.println();

        ArrayList<Buyer> buyers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String name = "Buyer" + (i+1);
            double budget = Generator.generateRandomBudget(30000, 150000);
            Buyer buyer = new Buyer(name, budget);
            buyer.setAgency(talentsEstates);
            buyers.add(buyer);
            buyer.register();
            int counter = 0;
            while (counter < 4){
                String kind = Generator.generateKindOfEstate();
                String type = Generator.generateTypeOfEstate(kind);
                ArrayList<Estate> estates = new ArrayList<>();
                estates.addAll(talentsEstates.getEstatesCatalogue().get(kind).get(type));
                if (estates.size() > 0){
                    int idx = r.nextInt(estates.size());
                    Estate estate = estates.get(idx);
                    //Estate estate = talentsEstates.getEstatesCatalogue().get(kind).get(type).first();
                    buyer.declareInspection(estate);
                    counter++;
                }
            }

            if(buyer.getInspections().size() == 0){
                System.out.println("The buyer hasn't made any inspections so he cannot purchase an estate");
            }
            else {
                int idx = r.nextInt(buyer.getInspections().size());
                Estate estateToPurchase = buyer.getInspections().get(idx).getEstate();
                System.out.println("class of estateToPurchase: " + estateToPurchase.getClass());
                buyer.declarePurchase(estateToPurchase);
            }
        }

        System.out.println("Showing agency money balance: ");
        System.out.println(talentsEstates.getMoneyBalance());
        System.out.println();

        System.out.println("Showing agents sorted by money balance descending: ");
        talentsEstates.getAgents().sort((a1, a2) -> ((Double)a2.getMoney()).compareTo((Double)a1.getMoney()));
        for(Agent a : talentsEstates.getAgents()){
            System.out.println(a);
        }
    }
}