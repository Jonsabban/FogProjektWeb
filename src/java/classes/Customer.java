package classes;

public class Customer {
    
    private int cID;
    private String cName;
    private String cAddress;
    private int cZipcode;
    private int cPhone;
    private String cEmail;

    public Customer(int cID, String cName, String cAddress, int cZipcode, int cPhone, String cEmail) {
        this.cID = cID;
        this.cName = cName;
        this.cAddress = cAddress;
        this.cZipcode = cZipcode;
        this.cPhone = cPhone;
        this.cEmail = cEmail;
    }


    public int getcID() {
        return cID;
    }

    public String getcName() {
        return cName;
    }

    public String getcAddress() {
        return cAddress;
    }

    public int getcZipcode() {
        return cZipcode;
    }

    public int getcPhone() {
        return cPhone;
    }

    public String getcEmail() {
        return cEmail;
    }

}
