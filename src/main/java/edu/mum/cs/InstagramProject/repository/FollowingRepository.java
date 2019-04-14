package edu.mum.cs.InstagramProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.mum.cs.InstagramProject.domain.Following;


public interface FollowingRepository extends MongoRepository<Following, String> {

}

