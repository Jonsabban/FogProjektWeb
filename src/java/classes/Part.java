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
public class Part {
    private String name;
    private int length;
    private int amount;
    private String partPackage;
    private String description;
    private Category category;

    public Part(String name, int length, int amount, String partPackage, String description, Category category) {
        this.name = name;
        this.length = length;
        this.amount = amount;
        this.partPackage = partPackage;
        this.description = description;
        this.category = category;
    }
}