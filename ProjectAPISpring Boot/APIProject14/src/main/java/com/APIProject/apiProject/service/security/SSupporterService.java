//package com.APIProject.apiProject.service.security;
//
//import com.APIProject.apiProject.domain.business.Supporter;
//import com.APIProject.apiProject.exceptions.RecordNotFoundException;
//import com.APIProject.apiProject.repository.SupporterRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class SSupporterService implements UserDetailsService {
//
//    @Autowired
//    private SupporterRepository repository;
//
//    public Supporter save(Supporter user) {
//        return repository.save(user);
//    }
//
//    public Supporter update(Supporter user) {
//        find(user.getId());
//        return repository.save(user);
//    }
//
//    public void delete(Integer id) {
//        repository.deleteById(id);
//    }
//
//    public List<Supporter> findAll() {
//        return repository.findAll();
//    }
//
//
//    public Supporter find(Integer id) {
//        return repository
//                .findById(id)
//                .orElseThrow(
//                        () -> new RecordNotFoundException(Supporter.class, id));
//    }
//
//    public Optional<Supporter> findByEmail(String email) {
//        return repository.findByEmail(email);
//    }
//
//    public Supporter findEmail(String email) {
//        return repository.findEmail(email);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Supporter user = findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not exists"));
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList());
//    }
//}
