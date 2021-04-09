package main.estates;

import main.people.Seller;
import main.utils.Constants;
import main.utils.Generator;

public class House extends Estate{
    private int parkingPlaces;
    private double yardArea;
    private String typeOfConstruction;

    public House(double price, String type, Seller seller) {
        super(price, type, seller);
        this.parkingPlaces = 2;
        this.yardArea = 500;
        this.typeOfConstruction = Generator.generateTypeOfConstruction();
    }

    @Override
    boolean validatePrice(double price) {
        return price >= 50000 && price <= 80000;
    }

    @Override
    String getValidTypes() {
        String validTypes = String.join("", Constants.HOUSE_TYPES);
        return validTypes;
    }

    @Override
    String setDefaultType() {
        return "Whole-House";
    }

    @Override
    public String getKind() {
        return "House";
    }
}