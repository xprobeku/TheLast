package edu.mum.service.impl;


import edu.mum.domain.User;
import edu.mum.repository.UserRepository;
import edu.mum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User searchUser(String searchString) {
        return repository.findByUserName(searchString);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getByUserId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void updateUserStatus(User user) {

    }

    @Override
    public void deleteUserById(long userId) {

    }
}
