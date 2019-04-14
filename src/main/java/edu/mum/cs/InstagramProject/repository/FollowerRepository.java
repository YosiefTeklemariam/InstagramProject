package edu.mum.cs.InstagramProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.mum.cs.InstagramProject.domain.User;

public interface FollowerRepository extends MongoRepository<User, String> {

}
