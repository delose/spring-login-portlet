package ph.talas.all.listing.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ph.talas.all.listing.domain.User;
import ph.talas.all.listing.exception.UserNotFound;
import ph.talas.all.listing.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;
	
	@Override@Transactional
	public User add(User user) {
		User addUser = user;
		return userRepository.save(addUser);
	}

	@Override
	@Transactional(rollbackFor=UserNotFound.class)
	public User delete(int id) throws UserNotFound {
		User deletedUser = userRepository.findOne(id);
		if (deletedUser == null)
			throw new UserNotFound();
		userRepository.delete(deletedUser);
		return deletedUser;
	}

	@Override
	@Transactional(rollbackFor=UserNotFound.class)
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=UserNotFound.class)
	public User update(User user) throws UserNotFound {
		User updatedUser = userRepository.findOne(user.getId());
		
		if (updatedUser == null)
			throw new UserNotFound();
		
		updatedUser.setName(user.getName());
		return updatedUser;
	}

	@Override
	@Transactional
	public User findById(int id) {
		return userRepository.findOne(id);
	}
	
	@Override
	@Transactional
	public User login(String username, String userpassword) {
		
		for (User user : findAll())
			if (user.getName().equals(username) && user.getPassword().equals(userpassword))
				return user;
		
		return null;
	}

}
