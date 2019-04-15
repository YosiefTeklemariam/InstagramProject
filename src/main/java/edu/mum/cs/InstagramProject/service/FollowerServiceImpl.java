package edu.mum.cs.InstagramProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.InstagramProject.domain.User;
import edu.mum.cs.InstagramProject.dto.FollowerDTO;
import edu.mum.cs.InstagramProject.repository.FollowerRepository;
import edu.mum.cs.InstagramProject.repository.UserRepository;

@Service
public class FollowerServiceImpl implements FollowerService {

	@Autowired
	private FollowerRepository followerRepository;

	@Autowired
	private UserRepository userRepository;

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

	@Override
	public User addFollower(FollowerDTO follower) {
		Optional<User> userOptional = userRepository.findById(follower.getUserId());
		User user = null;

		if (userOptional.get() != null) {
			user = userOptional.get();
			List<String> followerList = user.getFollowers();
			if (followerList == null) {
				List<String> newFollowerList = new ArrayList<>();
				newFollowerList.add(follower.getFollowerId());
			} else {
				followerList.add(follower.getFollowerId());
			}
			userRepository.save(user);

			User following = addFollowing(follower);
			if (user != null) {
				userRepository.save(following);
			}
			return user;
		}
		return user;
	}

	private User addFollowing(FollowerDTO follower) {
		Optional<User> followerOptional = userRepository.findById(follower.getFollowerId());
		User user = null;
		if (followerOptional.get() != null) {
			user = followerOptional.get();
			List<String> followingList = user.getFollowings();
			if (followingList == null) {
				List<String> newFollowerList = new ArrayList<>();
				newFollowerList.add(follower.getUserId());
			} else {
				followingList.add(follower.getUserId());
			}
			return user;
		}
		return user;
	}

}
