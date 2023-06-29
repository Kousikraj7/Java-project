package com.petpeers.modal;

import java.io.Serializable;

public class Pet implements Serializable {
    @Override
    public String toString() {
        return "Pet [petId=" + petId + ", speciesName=" + speciesName + ", petName=" + petName + ", price=" + price
                + "]";
    }
    private static final long serialVersionUID = 1L;
    private int petId;
    private String speciesName;
    private String petName;
    private float price;
    
    public Pet(String speciesName, String petName, float price) {
		super();
		this.speciesName = speciesName;
		this.petName = petName;
		this.price = price;
	}
	public Pet() {
        super();
    }
    public Pet(int petId, String speciesName, String petName, float price) {
        super();
        this.petId = petId;
        this.speciesName = speciesName;
        this.petName = petName;
        this.price = price;
    }
    public int getPetId() {
        return petId;
    }
    public void setPetId(int petId) {
        this.petId = petId;
    }
    public String getSpeciesName() {
        return speciesName;
    }
    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
    public String getPetName() {
        return petName;
    }
    public Pet(int petId) {
        super();
        this.petId = petId;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }


 
}