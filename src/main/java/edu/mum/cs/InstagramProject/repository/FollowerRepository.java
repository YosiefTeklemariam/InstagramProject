package edu.mum.cs.InstagramProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.mum.cs.InstagramProject.domain.Follower;

public interface FollowerRepository extends MongoRepository<Follower, String> {

}
