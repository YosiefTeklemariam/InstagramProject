package edu.mum.cs.InstagramProject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.InstagramProject.domain.Follower;
import edu.mum.cs.InstagramProject.repository.FollowerRepository;

public class FollowerServiceImpl implements FollowerService {

	@Autowired
	FollowerRepository followerRepository;
	
	public FollowerServiceImpl() {
		
	}

	@Override
	public Follower getFollower(String followerId) {
		Follower follower = followerRepository.findById(followerId).orElse(null);
		return follower;
	}

	@Override
	public Follower saveFollower(Follower follower) {
		followerRepository.save(follower);
		return follower;
	}

	@Override
	public Follower updateFollower(Follower follower) {
		Follower oldfollower = getFollower(follower.getFollowerId());
		if (!oldfollower.equals(null)) {
			followerRepository.delete(oldfollower);
			followerRepository.save(follower);
			return follower;
		} else {
			return null;
		}
	}

	@Override
	public Follower deleteFollower(String followerId) {
		Follower oldFollower = getFollower(followerId);
		if (oldFollower != null) {
			followerRepository.delete(oldFollower);
			return oldFollower;
		} else {
			return null;
		}
	}

	@Override
	public List<Follower> getFollowerList(String followerId) {
		return followerRepository.findAll();
	}

}
