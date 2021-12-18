package Reto4Ciclo4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Reto4Ciclo4.model.User;
import Reto4Ciclo4.repository.UserRepository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author tatianadiaz
 */
@Service
public class UserService {
    /**
     * Variable que representa el servicio de Usuario
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * Obtener Lista de todos los usuarios
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }
    /**
     * Obtener usuarios por su id
     * @param id
     * @return
     */
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    /**
     * Mwetodo para guardar nuevo usuario
     */
    public User save(User user){
        if (user.getId()== null){
            return user;
        }else {
            Optional<User> dbUser=userRepository.getUser(user.getId());
            if (dbUser.isEmpty()){
                if (emailExists(user.getEmail())==false){
                    return userRepository.save(user);
                }else{
                    return user;
                }
            }else {
                return user;
            }
        }
    }
    /**
     * Mwetodo para actualizar un usuario
     */
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> dbUser = userRepository.getUser(user.getId());
            if (!dbUser.isEmpty()) {
                if (user.getIdentification() != null) {
                    dbUser.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    dbUser.get().setName(user.getName());
                }
                if (user.getBirthtDay()!= null){
                    dbUser.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay()!= null){
                    dbUser.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null) {
                    dbUser.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    dbUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    dbUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    dbUser.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    dbUser.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    dbUser.get().setType(user.getType());
                }
                userRepository.update(dbUser.get());
                return dbUser.get();
            }else{
                return user;
            }
        }
        return user;
    }
    /**
     * Mwetodo para revisar si un email existe
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public boolean delete(int userId) {
     return getUser(userId).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);

    }
    /**
     * Metodo para autenticar un usuario
     */
    public User authenticateUser(String email, String password){
        Optional<User>user=userRepository.authenticateUser(email, password);
        if (user.isEmpty()){
            return new User();
        }
        return user.get();
    }

    public List<User>getByMonthBirthDay(String monthBirthDay){
        return userRepository.getByMonthBirthtDay(monthBirthDay);
    }
}


