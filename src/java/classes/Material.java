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
public class Material {
    private String name;
    private int length;
    private int amount;
    private String MPackage;
    private String description;
    private Category category;

    public Material(String name, int length, int amount, String MPackage, String description, Category category) {
        this.name = name;
        this.length = length;
        this.amount = amount;
        this.MPackage = MPackage;
        this.description = description;
        this.category = category;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }
    
    
}