package edu.mum.cs.InstagramProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.InstagramProject.domain.User;
import edu.mum.cs.InstagramProject.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	

	public UserServiceImpl() {
		super();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElse(null);
		return user;
	}

	@Override
	public User saveUser(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		User oldUser = getUser(user.getUserId());
		if (!oldUser.equals(null)) {
			userRepository.delete(oldUser);
			userRepository.save(user);
			return user;
		} else {
			return null;
		}
	}

	@Override
	public User deleteUser(String userId) {
		User oldUser = getUser(userId);
		if (oldUser != null) {
			userRepository.delete(oldUser);
			return oldUser;
		} else {
			return null;
		}
	}

	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
			}


}
