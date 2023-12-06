package Shop;

import java.util.Random;

public class Customer {
    private final long id;
    private String name;
    private int tier;

    public Customer( String name, int tier) {
        Random rndm = new Random();
        this.id = rndm.nextLong(10);
        this.name = name;
        this.tier = tier;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}
