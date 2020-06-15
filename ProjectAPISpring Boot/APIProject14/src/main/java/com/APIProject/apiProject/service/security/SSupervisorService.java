//package com.APIProject.apiProject.service.security;
//
//@Service
//public class SSupervisorService implements UserDetailsService {
//
//    @Autowired
//    private SupervisorRepository repository;
//
//    public Supervisor save(Supervisor user) {
//        return repository.save(user);
//    }
//
//    public Supervisor update(Supervisor user) {
//        find(user.getId());
//        return repository.save(user);
//    }
//
//    public void delete(Integer id) {
//        repository.deleteById(id);
//    }
//
//    public List<Supervisor> findAll() {
//        return repository.findAll();
//    }
//
//    public Supervisor find(Integer id) {
//        return repository
//                .findById(id)
//                .orElseThrow(
//                        () -> new RecordNotFoundException(Supervisor.class, id));
//    }
//
//    public Optional<Supervisor> findByEmail(String email) {
//        return repository.findByEmail(email);
//    }
//
//    public Supervisor findEmail(String email) {
//        return repository.findEmail(email);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Supervisor user = findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not exists"));
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList());
//    }
//}
