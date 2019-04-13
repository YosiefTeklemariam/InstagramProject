package edu.mum.cs.InstagramProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.InstagramProject.domain.Following;
import edu.mum.cs.InstagramProject.repository.FollowingRepository;

public class FollowingServiceImpl implements FollowingService{
	@Autowired
	FollowingRepository followingRepository;
	public FollowingServiceImpl() {

	}
	@Override
	public Following getFollowing(String FollowingId) {
		Following following = followingRepository.findById(FollowingId).orElse(null);
		return following;
	}

	@Override
	public Following saveFollowing(Following Following) {
		followingRepository.save(Following);
		return Following;
	}

	@Override
	public Following updateFollowing(Following Following) {
		Following oldFollowing = getFollowing(Following.getId());
		if(!oldFollowing.equals(null)) {
			followingRepository.delete(oldFollowing);
			followingRepository.save(Following);
			return Following;
		}
		return null;
	}

	@Override
	public Following deleteFollowing(String FollowingId) {
		Following oldFollowing= getFollowing(FollowingId);
		if(oldFollowing!=null) {
			followingRepository.delete(oldFollowing);
			return oldFollowing;
		}
		return null;
	}


	@Override
	public List<Following> getFollowingList(String userID) {

		return followingRepository.findAll();
	}


}
