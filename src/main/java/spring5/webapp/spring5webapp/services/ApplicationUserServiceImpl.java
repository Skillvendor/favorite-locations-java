package spring5.webapp.spring5webapp.services;

import org.springframework.stereotype.Service;
import spring5.webapp.spring5webapp.domain.ApplicationUser;
import spring5.webapp.spring5webapp.repositories.ApplicationUserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {
	final ApplicationUserRepository userRepository;
	
	public ApplicationUserServiceImpl(ApplicationUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Set<ApplicationUser> getUsers() {
		Set<ApplicationUser> usersSet = new HashSet<>();
		userRepository.findAll().iterator().
		forEachRemaining(usersSet::add);
		return usersSet;
	}
}
