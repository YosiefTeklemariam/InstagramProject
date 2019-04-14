package edu.mum.cs.InstagramProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.mum.cs.InstagramProject.domain.Following;
import edu.mum.cs.InstagramProject.domain.Post;

public interface FollowingRepository extends MongoRepository<Following, String> {

}

