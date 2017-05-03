package classes;

public class OrderLine {

    private int oID;
    private int matID;
    private int matLength;
    private int matAmount;
    private String matDescription;

    public OrderLine(int oID, int matID, int matLength, int matAmount, String matDescription) {
        this.oID = oID;
        this.matID = matID;
        this.matLength = matLength;
        this.matAmount = matAmount;
        this.matDescription = matDescription;
    }

    public int getoID() {
        return oID;
    }

    public int getMatID() {
        return matID;
    }

    public int getMatLength() {
        return matLength;
    }

    public int getMatAmount() {
        return matAmount;
    }

    public String getMatDescription() {
        return matDescription;
    }

}
