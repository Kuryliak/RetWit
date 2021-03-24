package com.example.help.me.Service;

import com.example.help.me.Models.Role;
import com.example.help.me.Models.User;
import com.example.help.me.Repository.UserRepository;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);
    }

    public void updateUser(User user, String password, String username) {
        String userPassword = user.getPassword();
        String userName = user.getUsername();

        Boolean passwordChanged = (password != null);

        if (passwordChanged) {
            user.setPassword(password);
            userRepository.save(user);
        }
        Boolean userNameChanged = (username != null);

        if (userNameChanged) {
            user.setUsername(username);
            userRepository.save(user);
        }
    }
}
