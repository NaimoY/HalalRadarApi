package com.halalradar.api.services;


import org.springframework.stereotype.Service;

@Service
public class CategoryService {


}

//public UserDto createUser(UserDto userDto) {
//        /*
//        Step 1: Create a JPA User (entity)
//        Step 2: Tell the UserRepository to store the JPA User
//        Step 3: Take the JPA User that the DB responds with and
//                send that back to the controller.
//         */
//    User user = userMapper.mapToUser(userDto);
//    Address address = addressMapper.mapToAddress(userDto.getAddressDto(), user);
//    user.setAddress(address);
//
//    User savedUser = userRepository.save(user);
//    return userMapper.mapToUserDto(savedUser);
//}