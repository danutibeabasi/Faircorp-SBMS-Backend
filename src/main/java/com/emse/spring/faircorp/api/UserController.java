package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.UserDaoCustom;
import com.emse.spring.faircorp.model.Role;
import com.emse.spring.faircorp.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserDaoCustom userDaoCustom;

    public UserController(UserDaoCustom userDaoCustom) {
        this.userDaoCustom = userDaoCustom;
    }

    /**
     * Returns a list of all users.
     *
     * @return a list of all users
     */
    @GetMapping
    public ResponseEntity<List<User>> findUsers() {
        return ResponseEntity.ok().body(userDaoCustom.getUsers());
    }

    /**
     * Returns a user with the given username.
     *
     * @param username the username of the user to be retrieved
     * @return the user with the given username
     */
    @GetMapping(path = "/{username}")
    public ResponseEntity<User> findUser(@PathVariable String username) {
        return ResponseEntity.ok().body(userDaoCustom.getUser(username));
    }

    /**
     * Saves a new user.
     *
     * @param user the user to be saved
     * @return the saved user
     */
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userDaoCustom.saveUser(user));
    }

    /**
     * Saves a new role.
     *
     * @param role the role to be saved
     * @return the saved role
     */
    @PostMapping("/saverole")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.ok().body(userDaoCustom.saveRole(role));
    }

    /**
     * Assigns a role to a user.
     *
     * @param form the form containing the username and role name
     */
    @PostMapping("/addrole")
    public void addRoleToUser(@RequestBody addRoleToUserForm form) {
        userDaoCustom.addRoleToUser(form.getUsername(), form.getRoleName());
    }

}


class addRoleToUserForm {
    private String username;
    private String roleName;
    public addRoleToUserForm(String username, String roleName) {
        this.username = username;
        this.roleName = roleName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
