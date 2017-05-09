/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author vfgya_000
 */
public class Material
{
    // definere variablerne
    private int id;
    private String type;
    private int length;
    private int amount;
    private String MPackage;
    private String description;
    private int caID;

    // laver en constructor
    public Material(int id, String type, int length, int amount, String MPackage, String description, int caID)
    {
        this.id = id;
        this.type = type;
        this.length = length;
        this.amount = amount;
        this.MPackage = MPackage;
        this.description = description;
        this.caID = caID;
    }
    
    // getter og setter

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
    
    
    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public String getMPackage()
    {
        return MPackage;
    }

    public void setMPackage(String MPackage)
    {
        this.MPackage = MPackage;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getCaID()
    {
        return caID;
    }

    public void setCaID(int caID)
    {
        this.caID = caID;
    }
    
    
}
