package models;

import java.util.ArrayList;

/**
 * Created by Guest on 1/9/18.
 */
public class Kombucha {
    private String name;
    private String color;
    private String taste;
    private String smell;
    private int price;
    private int id;
    private static ArrayList instances = new ArrayList<>();

    public Kombucha(String name, String color, String taste, String smell, int price) {
        this.name = name;
        this.color = color;
        this.taste = taste;
        this.smell = smell;
        this.price = price;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() { return this.name; }

    public String getColor() {
        return this.color;
    }

    public String getTaste() {
        return this.taste;
    }

    public String getSmell() {
        return this.smell;
    }

    public int getPrice() {
        return this.price;
    }

    public int getId(){
        return this.id;
    }

    public static ArrayList<Kombucha> getAll(){
        return instances;
    }

    public static void clearAllKombucha() {
        instances.clear();
    }

    public static Object findById(int id){
        return instances.get(id-1);
    }
}
