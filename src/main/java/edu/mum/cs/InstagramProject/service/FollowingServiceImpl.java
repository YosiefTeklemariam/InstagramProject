package edu.mum.cs.InstagramProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.InstagramProject.domain.User;
import edu.mum.cs.InstagramProject.repository.FollowingRepository;

@Service
public class FollowingServiceImpl implements FollowingService {
	@Autowired
	FollowingRepository followingRepository;

	public FollowingServiceImpl() {

	}

	@Override
	public User getFollowing(String FollowingId) {
		User following = followingRepository.findById(FollowingId).orElse(null);
		return following;
	}

	@Override
	public User saveFollowing(User Following) {
		followingRepository.save(Following);
		return Following;
	}

	@Override
	public User updateFollowing(User following) {
		User oldFollowing = getFollowing(following.getUserId());
		if (!oldFollowing.equals(null)) {
			followingRepository.delete(oldFollowing);
			followingRepository.save(following);
			return following;
		}
		return null;
	}

	@Override
	public User deleteFollowing(String followingId) {
		User oldFollowing = new User();
		List<String> followerList = new ArrayList<>();
		followerList.add(followingId);
		oldFollowing.setFollowers(followerList);
		if (oldFollowing != null) {
			followingRepository.delete(oldFollowing);
			return oldFollowing;
		}
		return null;
	}

	@Override
	public List<User> getFollowingList(String userID) {

		return followingRepository.findAll();
	}

}
