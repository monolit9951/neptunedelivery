package com.neptunes.security;

//import com.gmail.merikbest2015.ecommerce.domain.User;
//import com.gmail.merikbest2015.ecommerce.repository.UserRepository;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;


//@Service("userDetailsServiceImpl")
//@RequiredArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
//        if (user.getActivationCode() != null) {
//            throw new LockedException("Email not activated");
//        }
//        return UserPrincipal.create(user);
//    }
//}
