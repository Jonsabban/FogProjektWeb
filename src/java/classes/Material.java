package classes;

public class Material {

    private int partId;
    private String partType;
    private int partMinAmount;
    private String partPackage;
    private String partCategory;

    public Material(int partId, String partType, int partMinAmount, String partPackage, String partCategory) {
        this.partId = partId;
        this.partType = partType;
        this.partMinAmount = partMinAmount;
        this.partPackage = partPackage;
        this.partCategory = partCategory;
    }

    

    public int getId() {
        return partId;
    }

    public String getType() {
        return partType;
    }

    public int getMinAmount() {
        return partMinAmount;
    }

    public String getPackage() {
        return partPackage;
    }

    public String getCategory() {
        return partCategory;
    }

}
