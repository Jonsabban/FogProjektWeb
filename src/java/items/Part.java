/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

/**
 *
 * @author vfgya_000
 */ 
public class Part
{
    private int partId;
    private String type;
    private int length;
    private int packgageSize;
    private int unitName;
    private String Description;
    private Category category;

    public Part(int partId, String type, int length, int packgageSize, int unitName, String Description, Category category)
    {
        this.partId = partId;
        this.type = type;
        this.length = length;
        this.packgageSize = packgageSize;
        this.unitName = unitName;
        this.Description = Description;
        this.category = category;
    }

    public int getPartId()
    {
        return partId;
    }

    public void setPartId(int partId)
    {
        this.partId = partId;
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

    public int getPackgageSize()
    {
        return packgageSize;
    }

    public void setPackgageSize(int packgageSize)
    {
        this.packgageSize = packgageSize;
    }

    public int getUnitName()
    {
        return unitName;
    }

    public void setUnitName(int unitName)
    {
        this.unitName = unitName;
    }

    public String getDescription()
    {
        return Description;
    }

    public void setDescription(String Description)
    {
        this.Description = Description;
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
