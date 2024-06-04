package edu.demo.Ecom_app.services.implimentations;

import edu.demo.Ecom_app.entities.Address;
import edu.demo.Ecom_app.entities.User;
import edu.demo.Ecom_app.repositories.UserRepository;
import edu.demo.Ecom_app.services.AddressService;
import edu.demo.Ecom_app.services.UserService;
import edu.demo.Ecom_app.tools.dtos.address.AddressDto;
import edu.demo.Ecom_app.tools.dtos.user.UserDtoRequest;
import edu.demo.Ecom_app.tools.dtos.user.UserDtoResponse;
import edu.demo.Ecom_app.tools.mappers.AddressMapper;
import edu.demo.Ecom_app.tools.mappers.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressService addressService;

    public UserServiceImpl(UserRepository userRepository, AddressService addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }

    @Override
    @Transactional
    public UserDtoResponse AddUser(UserDtoRequest userDtoRequest) {
        User user = UserMapper.fromUserDtoRequestToUser(userDtoRequest);
        Address address = addressService.AddAddressInternalVersion(user.getAddress());
        user.getAddress().setId(address.getId());
        userRepository.save(user);
        return UserMapper.fromUserToUserDtoResponse(user);
    }

    @Override
    public List<UserDtoResponse> findAllUsers() {
        List<UserDtoResponse> usersResponse = new ArrayList<>();
        userRepository.findAll().forEach(user->{
            usersResponse.add(UserMapper.fromUserToUserDtoResponse(user));
        });
        return usersResponse;
        //another approach to convert list from User to UserResponseDto
        //List<UserDtoResponse> users = userRepository.findAll().stream().map(UserMapper::fromUserToUserDtoResponse).collect(Collectors.toList());

    }

    @Override
    public UserDtoResponse findUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserMapper::fromUserToUserDtoResponse).orElse(null);
    }

    @Override
    public boolean deleteUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            try {
                userRepository.delete(user.get());
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(int id, UserDtoRequest userDtoRequest) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            User userToUpdate = UserMapper.fromUserDtoRequestToUser(userDtoRequest);
            userToUpdate.setId(id);
            try{
                userRepository.save(userToUpdate);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public UserDtoResponse findUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        return user.map(UserMapper::fromUserToUserDtoResponse).orElse(null);
    }
}
