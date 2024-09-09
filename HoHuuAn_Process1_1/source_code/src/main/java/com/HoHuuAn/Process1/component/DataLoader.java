package com.HoHuuAn.Process1.component;

import com.HoHuuAn.Process1.model.ERole;
import com.HoHuuAn.Process1.model.Role;
import com.HoHuuAn.Process1.model.User;
import com.HoHuuAn.Process1.repository.RoleRepository;
import com.HoHuuAn.Process1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty() ) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }
        if (roleRepository.findByName(ERole.ROLE_USER).isEmpty() ) {
            roleRepository.save(new Role(ERole.ROLE_USER));
        }
        if (roleRepository.findByName(ERole.ROLE_EDITOR).isEmpty() ) {
            roleRepository.save(new Role(ERole.ROLE_EDITOR));
        }

        if(userRepository.getUserByUsername("admin").isEmpty()){
            User admin = new User("admin",passwordEncoder.encode("admin"),true);
            userRepository.save(admin);
            userRepository.addUserRole(admin.getId(), 1L);
            userRepository.addUserRole(admin.getId(), 2L);
            userRepository.addUserRole(admin.getId(), 3L);
        }

        if(userRepository.getUserByUsername("user").isEmpty()){
            User user = new User("user",passwordEncoder.encode("user"),true);
            userRepository.save(user);
            userRepository.addUserRole(user.getId(), 2L);
        }

        if(userRepository.getUserByUsername("editor").isEmpty()){
            User editor = new User("editor",passwordEncoder.encode("editor")    ,true);
            userRepository.save(editor);
            userRepository.addUserRole(editor.getId(), 3L);
            userRepository.addUserRole(editor.getId(), 2L);
        }
    }
}