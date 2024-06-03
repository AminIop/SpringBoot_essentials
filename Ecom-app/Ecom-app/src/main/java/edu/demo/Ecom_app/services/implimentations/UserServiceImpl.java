package edu.demo.Ecom_app.services.implimentations;

import edu.demo.Ecom_app.services.UserService;
import edu.demo.Ecom_app.tools.dtos.user.UserDtoRequest;
import edu.demo.Ecom_app.tools.dtos.user.UserDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public UserDtoResponse AddUser(UserDtoRequest user) {
        return null;
    }

    @Override
    public List<UserDtoResponse> findAllUsers() {
        return List.of();
    }

    @Override
    public UserDtoResponse findUserById(int id) {
        return null;
    }

    @Override
    public boolean deleteUserById(int id) {
        return false;
    }

    @Override
    public boolean updateUser(int id, UserDtoRequest user) {
        return false;
    }

    @Override
    public UserDtoResponse findUserByEmail(String email) {
        return null;
    }
}
