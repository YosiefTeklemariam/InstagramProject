package edu.mum.cs.InstagramProject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.InstagramProject.domain.User;
import edu.mum.cs.InstagramProject.repository.FollowerRepository;

public class FollowerServiceImpl implements FollowerService {

	@Autowired
	FollowerRepository followerRepository;
	
	public FollowerServiceImpl() {
		
	}

	@Override
	public User getFollower(String followerId) {
		User follower = followerRepository.findById(followerId).orElse(null);
		return follower;
	}

	@Override
	public User saveFollower(User follower) {
		followerRepository.save(follower);
		return follower;
	}

	@Override
	public User updateFollower(User follower) {
		User oldfollower = getFollower(follower.getUserId());
		if (!oldfollower.equals(null)) {
			followerRepository.delete(oldfollower);
			followerRepository.save(follower);
			return follower;
		} else {
			return null;
		}
	}

	@Override
	public User deleteFollower(String followerId) {
		User oldFollower = getFollower(followerId);
		if (oldFollower != null) {
			followerRepository.delete(oldFollower);
			return oldFollower;
		} else {
			return null;
		}
	}

	@Override
	public List<User> getFollowerList(String followerId) {
		return followerRepository.findAll();
	}

}
