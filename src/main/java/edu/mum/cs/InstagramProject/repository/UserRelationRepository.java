package edu.mum.cs.InstagramProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.mum.cs.InstagramProject.domain.UserRelation;

public interface UserRelationRepository extends MongoRepository<UserRelation, String>  {

}
