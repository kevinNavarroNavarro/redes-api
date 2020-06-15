//package com.APIProject.apiProject.service.security;
//
//import com.APIProject.apiProject.domain.business.Supervisor;
//import com.APIProject.apiProject.domain.business.Supporter;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.Optional;
//
//import static com.APIProject.apiProject.commons.Constants.JWT_ID;
//import static com.APIProject.apiProject.commons.Constants.SECRET_KEY;
//
////import com.APIProject.apiProject.domain.security.Role;
//
//@Service
//public class SessionService {
//
//    //SessionService Supporter
//    @Autowired
//    private SSupporterService userService;
//
//    @Autowired
//    private PasswordEncoder encoder;
//
//    public boolean validateSupporter(String email, String password) {
//        Optional<Supporter> user = userService.findByEmail(email);
//        if (user.isPresent()) {
//            return encoder.matches(password, user.get().getPassword());
//        } else return false;
//    }
//
//    public String buildTokenSupporter(String username) {
//        Supporter user = userService.findByEmail(username).get();
//
//        String token = Jwts
//                .builder()
//                .setId(JWT_ID)
//                .setSubject(username)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 3_600_000))//1 hour
//                .signWith(SignatureAlgorithm.HS512,
//                        SECRET_KEY.getBytes()).compact();
//
//        return "Bearer " + token;
//
//    }
//
//    //SessionService Supporter
//    @Autowired
//    private SSupervisorService SSupervisorService;
//
//    public boolean validateSupervisor(String email, String password) {
//        Optional<Supervisor> user = SSupervisorService.findByEmail(email);
//        if (user.isPresent()) {
//            return encoder.matches(password, user.get().getPassword());
//        } else return false;
//    }
//
//    public String buildTokenSupervisor(String username) {
//        Supervisor user = SSupervisorService.findByEmail(username).get();
//
////        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
////                .commaSeparatedStringToAuthorityList(user.getRoles().stream()
////                        .map(Role::getRole).collect(Collectors.joining(",")));
//        String token = Jwts
//                .builder()
//                .setId(JWT_ID)
//                .setSubject(username)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 3_600_000))//1 hour
//                .signWith(SignatureAlgorithm.HS512,
//                        SECRET_KEY.getBytes()).compact();
//
//        return "Bearer " + token;
//
//    }
//}
