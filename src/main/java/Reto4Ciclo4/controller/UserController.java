package Reto4Ciclo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import Reto4Ciclo4.model.User;
import Reto4Ciclo4.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })

/**
 *
 * @author tatianadiaz
 */
public class UserController {
    /**
     * Clase controladora de rutas
     */
    @Autowired

    /**
	* instacia de servicio a usar
	*/

    private UserService userService;

    /**
     * Método para obtener el listado de Usuarios existentes
     *
     * @return listado de Usuarios formato JSON
     */

    @GetMapping("/all")

    /**
	* método para listar todos los usuarios
	*/
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Método para obtener el listado de Usuarios existentes
     *
     */
    @GetMapping("/{id}")

    /**
	* método para ubicar usuarios por id
	*/

    public Optional<User> getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    
    @PostMapping("/new")

    /**
	* método para agregar usuarios
	*/
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * Método para actualizar un Usuario
     *
     */

    @PutMapping("/update")
    /**
	* método para actualizar un usuario
	*/

    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    
    @DeleteMapping("/{id}")
      /**
	* método para eliminar usuario
	*/
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    /**
     * Método para Consultar un Email
     *
     * @param email Consultado
     * @return Usuario en formato JSON
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    
    @GetMapping("/emailExist/{email}")
    /**
	* método para validar email de usuario
	*/
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }

    @GetMapping("/birthday/{monthBirthDay}")
    /**
	* método para listar por mes de nacimiento de los usuarios
	*/
    public List<User> getByMonthBirthtDay(@PathVariable("monthBirthDay") String monthBirthDay) {
        return userService.getByMonthBirthDay(monthBirthDay);
    }
}
