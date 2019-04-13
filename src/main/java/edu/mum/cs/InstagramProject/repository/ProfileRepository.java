package edu.mum.cs.InstagramProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.mum.cs.InstagramProject.domain.Profile;

public interface ProfileRepository  extends MongoRepository<Profile, String>{

}
