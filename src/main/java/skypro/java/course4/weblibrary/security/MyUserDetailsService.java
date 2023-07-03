package skypro.java.course4.weblibrary.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import skypro.java.course4.weblibrary.controller.dto.UserDTO;
import skypro.java.course4.weblibrary.repository.UserRepository;
import skypro.java.course4.weblibrary.service.UserMapper;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MyUserDetails userDetails;

    public MyUserDetailsService(UserRepository userRepository,
                                UserMapper userMapper,
                                MyUserDetails userDetails) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userDetails = userDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = userRepository.findByLogin(username)
                .map(user -> userMapper.toDTO(user))
                .orElseThrow(()->new UsernameNotFoundException("Username %s not found!".formatted(username)));
        userDetails.setUserDTO(userDTO);
        return userDetails;
    }
}
