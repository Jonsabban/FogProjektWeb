package classes;

public class Order {
    
    private int oID;
    private int cID;
    private int partID;
    private int partLengh;
    private int partAmount;
    private String partDescription;

    public Order(int oID, int cID, int partID, int partLengh, int partAmount, String partDescription) {
        this.oID = oID;
        this.cID = cID;
        this.partID = partID;
        this.partLengh = partLengh;
        this.partAmount = partAmount;
        this.partDescription = partDescription;
    }

    public int getoID() {
        return oID;
    }

    public int getcID() {
        return cID;
    }

    public int getPartID() {
        return partID;
    }

    public int getPartLengh() {
        return partLengh;
    }

    public int getPartAmount() {
        return partAmount;
    }

    public String getPartDescription() {
        return partDescription;
    }
    
    

}
