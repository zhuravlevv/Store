package com.lessons.service;

import com.lessons.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    public User getById(Integer id);

    public User save(User user);

    public User update(User newUser, Integer id);

    public void delete(Integer id);
}
