package com.unla.ps_tp_airbnb.model;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.unla.ps_tp_airbnb.serviceInterface.UserService;
import jakarta.annotation.PostConstruct;

@Component
public class PasswordSeeder {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@PostConstruct
	public void encryptAndSaveUsers() {
		String[][] users = { { "1", "2025-04-09", "carlos@host.com", "Carlos", "1234", "HOST" },
				{ "2", "2025-04-09", "lucia@guest.com", "Lucía", "abcd", "GUEST" },
				{ "3", "2025-04-09", "julian@host.com", "Julián", "asdf", "HOST" },
				{ "4", "2025-04-09", "maria@guest.com", "María", "zxcv", "GUEST" },
				{ "5", "2025-04-09", "sofia@guest.com", "Sofía", "qwer", "GUEST" } };

		for (String[] user : users) {
			User newUser = new User();
			newUser.setId(Long.parseLong(user[0]));
			newUser.setCreatedAt(LocalDate.parse(user[1]));
			newUser.setEmail(user[2]);
			newUser.setName(user[3].trim());
			newUser.setPasswordHash(encoder.encode(user[4]));
			newUser.setRole(User.Role.valueOf(user[5]));
			userService.save(newUser);
			System.out.printf("Usuario guardado: %s (%s)\n", newUser.getName(), newUser.getEmail());
		}
	}
}
