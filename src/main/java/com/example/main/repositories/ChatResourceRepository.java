package com.example.main.repositories;

import com.example.main.models.ChatResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatResourceRepository extends MongoRepository<ChatResource, String> {

}
