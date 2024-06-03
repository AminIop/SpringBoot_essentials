package edu.demo.Ecom_app.services;

import edu.demo.Ecom_app.tools.dtos.user.UserDtoRequest;
import edu.demo.Ecom_app.tools.dtos.user.UserDtoResponse;

import java.util.List;

public interface UserService {
    public UserDtoResponse AddUser(UserDtoRequest user);
    public List<UserDtoResponse> findAllUsers();
    public UserDtoResponse findUserById(int id);
    public boolean deleteUserById(int id);
    public boolean updateUser(int id,UserDtoRequest user);
    public UserDtoResponse findUserByEmail(String email);
}
