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


    //get all users
    @GetMapping  // (1)
    public ResponseEntity<List<User>> findUsers() {
        return ResponseEntity.ok().body(userDaoCustom.getUsers());
    }

    //get a user by Usernmae
    @GetMapping(path = "/{username}")
    public ResponseEntity<User> findUser(@PathVariable String username) {
        return ResponseEntity.ok().body(userDaoCustom.getUser(username));
    }

    //Save a user
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userDaoCustom.saveUser(user));
    }
    //Save a user with a role
    @PostMapping("/saverole")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.ok().body(userDaoCustom.saveRole(role));
    }

    //Assign a role to a user
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
