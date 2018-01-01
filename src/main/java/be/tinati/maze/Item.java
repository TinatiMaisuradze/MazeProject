package be.tinati.maze;

public class Item {

    private String Visualisation;


    public Item(String Visualisation) {
        this.Visualisation = Visualisation;

    }

    public String getVisualisation() {
        return Visualisation;
    }

    public static Item valueOf(String itemName) {
        switch (itemName) {
            case "start":
                return new Start();
            case "end":
                return new End();
            case "key":
                return new Key();
            case "hammer":
                return new Hammer();
            case "trophy":
                return new Trophy();
            case "no":
                return new NoItem();
            default:
                throw new IllegalArgumentException("This item does not exist");
        }
    }
}