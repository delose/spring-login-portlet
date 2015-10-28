package ph.talas.all.listing.service;

import java.util.List;

import ph.talas.all.listing.domain.User;
import ph.talas.all.listing.exception.UserNotFound;

public interface UserService {

	public User add(User user);
	public User delete(int id) throws UserNotFound;
	public List<User> findAll();
	public User update(User user) throws UserNotFound;
	public User findById(int id) throws UserNotFound;
	public User login(String username, String userpassword);
	
}
