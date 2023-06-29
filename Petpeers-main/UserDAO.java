package com.petpeers.DAO;
import java.util.List;
import com.petpeers.modal.User;

public interface UserDAO {

		 public void getConnection();

		    public void closeConnection();

		    public List<User> findUser();

		    public boolean addUser(User user);
		    
		    public boolean updateUser(User user);
		    
		    public boolean deleteUser(User user);

		    public User findUser(int userid);	
	}


