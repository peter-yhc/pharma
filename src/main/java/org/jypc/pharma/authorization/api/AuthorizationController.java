package org.jypc.pharma.authorization.api;

import org.jypc.pharma.authorization.database.ApplicationUser;
import org.jypc.pharma.authorization.database.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes an endpoint at host:8080/admin/sign-up to create new ApplicationUsers
 **/
@RestController
@RequestMapping("/admin")
public class AuthorizationController {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }
}
