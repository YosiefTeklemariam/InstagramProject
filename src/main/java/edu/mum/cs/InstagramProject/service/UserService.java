package edu.mum.cs.InstagramProject.service;

import java.util.List;
import edu.mum.cs.InstagramProject.domain.User;

public interface UserService {
	
	public User getUser(String userId);

	public User saveUser(User user);

	public User updateUser(User user);

	public User deleteUser(String userId);

	public List<User> getUserList();
	
}
