package mira.space.jsonignoretest.controller;

import mira.space.jsonignoretest.model.Passport;
import mira.space.jsonignoretest.model.User;
import mira.space.jsonignoretest.model.repository.PassportRepository;
import mira.space.jsonignoretest.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class DefaultController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PassportRepository passportRepository;

    @PostMapping("user")
    public ResponseEntity<User> createUser() {
        User user = new User();
        user.setAge(28);
        user.setName("Mira");
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("passport")
    public ResponseEntity<Passport> createPassport() {
        Passport passport = new Passport();
        Optional<User> user = userRepository.findById(userRepository.count());
        passport.setNumber("AAA111BBB222");
        passport.setOwner(user.get());
        return ResponseEntity.ok(passportRepository.save(passport));
    }

    @GetMapping("passport")
    public ResponseEntity<Passport> getPassport() {
        return ResponseEntity.ok(passportRepository.findById(passportRepository.count()).get());
    }
}
