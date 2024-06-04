package edu.demo.Ecom_app.controllers;

import edu.demo.Ecom_app.services.AddressService;
import edu.demo.Ecom_app.services.UserService;
import edu.demo.Ecom_app.tools.dtos.user.UserDtoRequest;
import edu.demo.Ecom_app.tools.dtos.user.UserDtoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService, AddressService addressService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDtoResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers() , HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDtoResponse> getUserById(@PathVariable int id) {
        UserDtoResponse userDtoResponse = userService.findUserById(id);
        if (userDtoResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDtoResponse, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> adduser(@RequestBody UserDtoRequest userDtoRequest) {
        UserDtoResponse userDtoResponse = userService.AddUser(userDtoRequest);
        if(userDtoResponse != null) {
            return new ResponseEntity<>(userDtoResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("User not Added", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        boolean isDeleted = userService.deleteUserById(id);
        if(isDeleted) {
            return new ResponseEntity<>("User deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("user not found with id = "+id,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Map<String,Object>> updateUser(@PathVariable int id, @RequestBody UserDtoRequest userDtoRequest) {
        boolean isUpdated = userService.updateUser(id,userDtoRequest);
        Map<String, Object> map = new HashMap<>();
        if(isUpdated) {
            map.put("Is updated", true);
            map.put("data", userDtoRequest);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        map.put("Is updated", false);
        return  new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }


}
