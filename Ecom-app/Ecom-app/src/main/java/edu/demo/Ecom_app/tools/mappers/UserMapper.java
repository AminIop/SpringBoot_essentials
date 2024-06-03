package edu.demo.Ecom_app.tools.mappers;

import edu.demo.Ecom_app.entities.User;
import edu.demo.Ecom_app.tools.dtos.user.UserDtoRequest;
import edu.demo.Ecom_app.tools.dtos.user.UserDtoResponse;
import org.springframework.beans.BeanUtils;

public class UserMapper {

    public static User fromUserDtoRequestToUser(UserDtoRequest userDtoRequest){
        User user = new User();
        BeanUtils.copyProperties(userDtoRequest, user);
        return user;
    }

    public static UserDtoResponse fromUserToUserDtoResponse(User user){
        UserDtoResponse userDtoResponse = new UserDtoResponse();
        BeanUtils.copyProperties(user, userDtoResponse);
        return userDtoResponse;
    }
}
