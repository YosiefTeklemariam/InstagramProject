package edu.mum.cs.InstagramProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.InstagramProject.domain.UserRelation;
import edu.mum.cs.InstagramProject.repository.UserRelationRepository;

public class UserRelationServiceImpl implements UserRelationService {

	@Autowired
	UserRelationRepository userRelationRepository;

	public UserRelationServiceImpl() {
		super();
	}

	@Override
	public UserRelation getUserRelation(String UserRelationId) {
		UserRelation userRelation = userRelationRepository.findById(UserRelationId).orElse(null);
		return userRelation;
	}

	@Override
	public UserRelation saveUserRelation(UserRelation userRelation) {
		userRelationRepository.save(userRelation);
		return userRelation;
	}

	@Override
	public UserRelation updateUserRelation(UserRelation userRelation) {
		UserRelation oldUserRelation = getUserRelation(userRelation.getUserRelationId());
		if (!oldUserRelation.equals(null)) {
			userRelationRepository.delete(oldUserRelation);
			userRelationRepository.save(userRelation);
			return userRelation;
		} else {
			return null;
		}
	}

	@Override
	public UserRelation deleteUserRelation(String userRealtionId) {
		UserRelation oldUserRelation = getUserRelation(userRealtionId);
		if (oldUserRelation != null) {
			userRelationRepository.delete(oldUserRelation);
			return oldUserRelation;
		} else {
			return null;
		}
	}

	@Override
	public List<UserRelation> getUserRelation() {
		return userRelationRepository.findAll();
	}

	

}
