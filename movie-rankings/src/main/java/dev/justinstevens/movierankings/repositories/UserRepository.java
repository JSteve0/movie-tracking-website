package dev.justinstevens.movierankings.repositories;

import dev.justinstevens.movierankings.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    @Query(value = "{username: '?0'}")
    User findByUsername(String username);

    @Query(value = "{email: '?0'}")
    User findByEmail(String email);

}
