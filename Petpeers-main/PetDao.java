package com.petpeers.DAO;

import java.util.List;

import com.petpeers.modal.Pet;

public interface PetDao {
	public void getConnection();

    public void closeConnection();

    public List<Pet> findPet();

    public boolean addPet(Pet pet);
    
    public boolean deletePet (Pet pet);

    public Pet findPet(int petid);

	boolean editPet(Pet pet);	
	
	
}
