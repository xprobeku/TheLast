package edu.mum.service;


import edu.mum.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

	public User searchUser(String searchString);

	public List<User> getAllUsers();

    public Optional<User> getByUserId(Long id);

    public User getByUserName(String userName);
	void updateUserStatus(User user);
    void deleteUserById(long userId);
}
