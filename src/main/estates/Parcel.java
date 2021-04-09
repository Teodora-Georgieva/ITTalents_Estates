package main.estates;

import main.people.Seller;
import main.utils.Constants;

import java.util.Random;

public class Parcel extends Estate{
    private boolean isInRegulation;

    public Parcel(double price, String type, Seller seller) {
        super(price, type, seller);
        Random r = new Random();
        this.isInRegulation = r.nextBoolean();
    }

    @Override
    boolean validatePrice(double price) {
        return price >= 30000 && price <= 85000;
    }

    @Override
    String getValidTypes() {
        String validTypes = String.join("", Constants.PARCEL_TYPES);
        return validTypes;
    }

    @Override
    String setDefaultType() {
        return "Field";
    }

    @Override
    public String getKind() {
        return "Parcel";
    }
}