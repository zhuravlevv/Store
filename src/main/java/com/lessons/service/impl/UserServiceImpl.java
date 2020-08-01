package com.lessons.service.impl;

import com.lessons.entity.User;
import com.lessons.repository.UserRepository;
import com.lessons.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        try {
            return userRepository.findById(id).orElseThrow(Exception::new);
        } catch (Exception e){
            System.out.println("User with id = "+ id +" doesn't exist");
        }
        return null;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User newUser, Integer id) {
        try {
            User user = userRepository.findById(id).orElseThrow(Exception::new);
            user.setMail(newUser.getMail());
            user.setPassword(newUser.getPassword());
            user.setName(newUser.getName());
            user.setSurname(newUser.getSurname());
            user.setBalance(newUser.getBalance());

        } catch (Exception e){
            System.out.println("User with id = "+ id +" doesn't exist");
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }


}
