package com.petpeers.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.petpeers.controller.AddPetServlet;
import com.petpeers.modal.Pet;
 
 
public class PetDaoImpl implements PetDao {
    static Connection conn;
    static Logger LOGGER = LogManager.getLogger(PetDaoImpl.class);
    @Override
        public void getConnection() {
            if (conn == null) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/petpeers", "root", "root");
                    LOGGER.info("Database is Connected");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    LOGGER.info("Error in Database Connections");
                }
            }
        }
     @Override
        public void closeConnection() {
            try {
                conn.close();
                LOGGER.info("Database is Closed");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                LOGGER.debug("Error in Database closing");
            }
 
        }
     public List<Pet> findPet() {
            getConnection();
            List<Pet> PetList = new ArrayList<>();
            String queryStr = "select * from Pet";
            Statement stmt;
            try {
                stmt = conn.createStatement();
                LOGGER.info("Datas are Fetching from Database");
                // 3.Execute SQL Statements
                // 4.GET ResultSet
                ResultSet rs = stmt.executeQuery(queryStr);
 
                while (rs.next()) {
                    Pet tempPet = new Pet();
 
                    tempPet.setPetId(rs.getInt("petId"));
                    tempPet.setSpeciesName(rs.getString("speciesName"));
                    tempPet.setPetName(rs.getString("petName"));
                    tempPet.setPrice(rs.getFloat("price"));
                    PetList.add(tempPet);
                    LOGGER.debug("Data are fetched from Database");
                }
                stmt.close();
 
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                LOGGER.debug("Error in fetching data from database");
            }
            return PetList;
        }
 
     @Override
        public boolean addPet(Pet pet) {
            getConnection();
            PreparedStatement prestmt1;
            try {
            	 LOGGER.debug("A record is going to insert in a table");
                prestmt1 = conn.prepareStatement("insert into pet(SpeciesName,PetName,Price) values(?,?,?) ");
               // prestmt1.setInt(1, pet.getPetId());// 1 specifies the first parameter in the query
                prestmt1.setString(1, pet.getSpeciesName());
                prestmt1.setString(2, pet.getPetName());
                prestmt1.setFloat(3, pet.getPrice());
                prestmt1.executeUpdate();
                System.out.println("A new record is successfully Inserted !");
                LOGGER.info("A new record inserted");
                prestmt1.close();
                LOGGER.info("connections closed");
                return true;
            } catch (Exception e) {
                return false;
       }
        }
 
        @Override
        public Pet findPet(int petId) {
            getConnection();
            String queryStr = "select * from pet where petId='" + petId + "'";
            Statement stmt;
            try {
                stmt = conn.createStatement();
 
                // 3.Execute SQL Statements
                // 4.GET ResultSet
                ResultSet rs = stmt.executeQuery(queryStr);
                Pet tempPet = new Pet();
                while (rs.next()) {
                    tempPet.setPetId(rs.getInt("petId"));
                    tempPet.setSpeciesName(rs.getString("speciesname"));
                    tempPet.setPetName(rs.getString("petname"));
                    tempPet.setPrice(rs.getFloat("price"));
 
                }
                stmt.close();
                return tempPet;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public boolean deletePet (Pet pet) {
            getConnection();
            String sql = "delete from Pet where  petId= '" + pet.getPetId() + "'";
            Statement stmt;
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                System.out.println("pet is Deleted");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return true;
        }
        @Override
        public boolean editPet(Pet pet) {
            getConnection();
            PreparedStatement prestmt1;
            try {
                prestmt1 = conn.prepareStatement("update pet set petid=?,speciesName=?,petName=?,price=? where petid="+ pet.getPetId());
                prestmt1.setInt(1, pet.getPetId());
                prestmt1.setString(2,pet.getSpeciesName());
                prestmt1.setString(3,pet.getPetName());
                prestmt1.setFloat(4,pet.getPrice());
                prestmt1.executeUpdate();
                System.out.println("A new record is successfully Updated !");
                prestmt1.close();
                return true;
            } catch (Exception e) {
                return false;
            }
        }

 
    }