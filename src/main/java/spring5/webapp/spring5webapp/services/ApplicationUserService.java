package spring5.webapp.spring5webapp.services;

import java.util.Set;
import spring5.webapp.spring5webapp.domain.ApplicationUser;

public interface ApplicationUserService {
	Set<ApplicationUser> getUsers();
}
