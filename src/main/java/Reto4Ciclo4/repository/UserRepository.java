package Reto4Ciclo4.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto4Ciclo4.model.User;
import Reto4Ciclo4.repository.crud.UserCrudRepository;

import java.util.List;
import java.util.Optional;

/*
 *
 * @autor tatianadiaz
 */

@Repository

public class UserRepository {
    @Autowired

/*acceso a la consulta de los usuarios general*/
    private UserCrudRepository userCrudRepository;
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    /*acceso consulta de los usuarios por identificador*/
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    /*acceso a guardar los usuarios*/
    public User save(User user){
        return userCrudRepository.save(user);
    }
    
    /*acceso a actualizar los usuarios*/
    public void update(User user){
        userCrudRepository.save(user);
    }

    /*acceso a eliminar los usuarios*/
    public void delete(User user){
        userCrudRepository.delete(user);
    }

    /*acceso a validar emails*/
    public boolean emailExists(String email){
        Optional<User> user=userCrudRepository.findByEmail(email);
        return user.isPresent();
    }

    /*acceso a autenticación de usuarios*/
    public Optional<User>authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /*acceso a consulta de mes de nacimiento*/
    public List<User>getByMonthBirthtDay(String monthBirthtDay){
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
}
