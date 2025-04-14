package edu.iu.p566.prime_service.service;

import edu.iu.p566.prime_service.model.Customer;
import edu.iu.p566.prime_service.repository.AuthenticationDBRepository;
import edu.iu.p566.prime_service.repository.AuthenticationFileRepository;
import edu.iu.p566.prime_service.repository.IAuthenticationRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class AuthenticationService implements IAuthenticationService, UserDetailsService {
    AuthenticationDBRepository authenticationRepository;

    public AuthenticationService(AuthenticationDBRepository authenticationRepository){
        this.authenticationRepository = authenticationRepository;
    }
    @Override
    public Customer register(Customer customer) throws IOException{
        BCryptPasswordEncoder bc =new BCryptPasswordEncoder();
        String passwordEncoded = bc.encode(customer.getPassword());
        customer.setPassword(passwordEncoded);
        return authenticationRepository.save(customer);
    }

    @Override
    public boolean login(String username, String password) throws IOException {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Customer customer = authenticationRepository.findByUsername(username);
            if(customer==null){
                throw new UsernameNotFoundException("");
            }
            return User
                    .withUsername(username)
                    .password(customer.getPassword())
                    .build();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
