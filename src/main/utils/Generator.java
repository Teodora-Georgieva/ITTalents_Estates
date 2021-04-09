package main.utils;

import java.util.Random;

public abstract class Generator {
    private static String[] typesOfConstruction = {"EPK", "Tuhla", "Panel", "Kirpich"};
    private static Random r = new Random();

    public static String generateTypeOfConstruction(){
        return typesOfConstruction[r.nextInt(typesOfConstruction.length)];
    }

    public static double generateRandomBudget(int min, int max){

        return (double)(r.nextInt(max - min + 1) + min);
    }

    public static double generatePriceForEstate(int min, int max){
        return (double)(r.nextInt(max - min + 1) + min);
    }

    public static String generateTypeForApartment(){
        return Constants.APARTMENT_TYPES[r.nextInt(Constants.APARTMENT_TYPES.length)];
    }

    public static String generateTypeForHouse(){
        return Constants.HOUSE_TYPES[r.nextInt(Constants.HOUSE_TYPES.length)];
    }

    public static String generateTypeForParcel(){
        return Constants.PARCEL_TYPES[r.nextInt(Constants.PARCEL_TYPES.length)];
    }

    public static String generateKindOfEstate(){
        int num = r.nextInt(3);
        switch (num){
            case 0: return "Apartment";
            case 1: return "House";
            default: return "Parcel";
        }
    }

    public static String generateTypeOfEstate(String kind){
        if(kind.equals("Apartment")){
            return generateTypeForApartment();
        }
        else if(kind.equals("House")){
            return generateTypeForHouse();
        }
        else{
            return generateTypeForParcel();
        }
    }
}