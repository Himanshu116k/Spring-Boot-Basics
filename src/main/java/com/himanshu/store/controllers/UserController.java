package com.himanshu.store.controllers;

import com.himanshu.store.dtos.UserDto;
import com.himanshu.store.repositories.UserRepository;
import com.himanshu.store.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    //Get
    public Iterable<UserDto> getAllUsers(){

        return userRepository.findAll()
                .stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){

       var user =  userRepository.findById(id).orElse(null);
       if(user ==null){
//           return  new ResponseEntity<>(HttpStatus.NOT_FOUND,"USER NOT FOUND IN DB",404)
             return  ResponseEntity.notFound().build();
       }

//       return new ResponseEntity<>( user,HttpStatus.OK);
        UserDto userDto = new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );

        return ResponseEntity.ok(userDto);
    }
}
