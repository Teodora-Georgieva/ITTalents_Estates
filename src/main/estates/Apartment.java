package main.estates;

import main.people.Seller;
import main.utils.Constants;
import main.utils.Generator;

public class Apartment extends Estate{
    private String typeOfConstruction;

    public Apartment(double price, String type, Seller seller) {
        super(price, type, seller);
        this.typeOfConstruction = Generator.generateTypeOfConstruction();
    }

    @Override
    boolean validatePrice(double price) {
        return price >= 70000 && price <= 150000;
    }

    @Override
    String getValidTypes() {
        String validTypes = String.join("", Constants.APARTMENT_TYPES);
        return validTypes;
    }

    @Override
    String setDefaultType() {
        return "Two-Rooms";
    }

    @Override
    public String getKind() {
        return "Apartment";
    }
}