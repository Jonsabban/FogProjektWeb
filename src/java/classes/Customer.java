package classes;

public class Customer {
    
    private int cID;
    private String cName;
    private String password;
    private String cAddress;
    private int cZipcode;
    private int cPhone;
    private String cEmail;

    public Customer(int cID, String cName, String password, String cAddress, int cZipcode, int cPhone, String cEmail)
    {
        this.cID = cID;
        this.cName = cName;
        this.password = password;
        this.cAddress = cAddress;
        this.cZipcode = cZipcode;
        this.cPhone = cPhone;
        this.cEmail = cEmail;
    }

    public int getcID()
    {
        return cID;
    }

    public void setcID(int cID)
    {
        this.cID = cID;
    }

    public String getcName()
    {
        return cName;
    }

    public void setcName(String cName)
    {
        this.cName = cName;
    }

    public String getcAddress()
    {
        return cAddress;
    }

    public void setcAddress(String cAddress)
    {
        this.cAddress = cAddress;
    }

    public int getcZipcode()
    {
        return cZipcode;
    }

    public void setcZipcode(int cZipcode)
    {
        this.cZipcode = cZipcode;
    }

    public int getcPhone()
    {
        return cPhone;
    }

    public void setcPhone(int cPhone)
    {
        this.cPhone = cPhone;
    }

    public String getcEmail()
    {
        return cEmail;
    }

    public void setcEmail(String cEmail)
    {
        this.cEmail = cEmail;
    }
    
    
}
