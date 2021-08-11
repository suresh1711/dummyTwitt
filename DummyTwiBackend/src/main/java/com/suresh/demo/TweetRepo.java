package com.suresh.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.suresh.demo.model.Tweets;

@RepositoryRestResource(collectionResourceRel = "tweet",path="tweet")
@CrossOrigin
public interface TweetRepo extends JpaRepository<Tweets, Integer> {

}
