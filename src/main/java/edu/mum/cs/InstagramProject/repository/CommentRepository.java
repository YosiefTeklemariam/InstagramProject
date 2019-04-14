package edu.mum.cs.InstagramProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.mum.cs.InstagramProject.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

}
