package Reto4Ciclo4.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;

import Reto4Ciclo4.model.User;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<User,Integer> {
    Optional<User> findByEmail(String email);
    Optional<User>findByEmailAndPassword(String email, String password);
    Optional<User>findByNameOrEmail(String name, String email);
    List<User>findByMonthBirthtDay(String monthBirthtDay);
}
