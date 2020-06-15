//package com.APIProject.apiProject.controller.security;
//
//import com.APIProject.apiProject.domain.business.Supervisor;
//import com.APIProject.apiProject.domain.business.Supporter;
//import com.APIProject.apiProject.dto.SupervisorDTO;
//import com.APIProject.apiProject.dto.SupporterDTO;
//import com.APIProject.apiProject.dto.security.LoginDTO;
//import com.APIProject.apiProject.exceptions.security.InvalidCredentialsException;
//import com.APIProject.apiProject.service.security.SSupervisorService;
//import com.APIProject.apiProject.service.security.SSupporterService;
//import com.APIProject.apiProject.service.security.SessionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin
//public class SessionController {
//
//    @Autowired
//    private SessionService sessionService;
//
//    @Autowired
//    private SSupervisorService  supervisorService;
//
//    @Autowired
//    private SSupporterService supporterService;
//
//    @RequestMapping(method = RequestMethod.POST, path = "/api/loginSupporter")
//    public SupporterDTO.Response loginSupporter(@RequestBody LoginDTO user) {
//        if (sessionService.validateSupporter(user.getUserName(), user.getPassword())) {
//            String token = sessionService.buildTokenSupporter(user.getUserName());
//            SupporterDTO.Response result = new SupporterDTO.Response();
//            result.setEmail(user.getUserName());
//            result.setToken(token);
//            Supporter supporter = supporterService.findEmail(user.getUserName());
//            result.setId(supporter.getId());
//            result.setName(supporter.getName());
//            result.setFirstSurname(supporter.getFirstSurname());
//            result.setSecondSurname(supporter.getSecondSurname());
//            return result;
//        }
//        throw new InvalidCredentialsException();
//    }
//
//    @RequestMapping(method = RequestMethod.POST, path = "/api/loginSupervisor")
//    public SupervisorDTO.Response loginSupervisor(@RequestBody LoginDTO user) {
//        if (sessionService.validateSupervisor(user.getUserName(), user.getPassword())) {
//            String token = sessionService.buildTokenSupervisor(user.getUserName());
//            SupervisorDTO.Response result = new SupervisorDTO.Response();
//            result.setEmail(user.getUserName());
//            result.setToken(token);
//            Supervisor supervisor = supervisorService.findEmail(user.getUserName());
//            result.setId(supervisor.getId());
//            result.setName(supervisor.getName());
//            result.setFirstSurname(supervisor.getFirstSurname());
//            result.setSecondSurname(supervisor.getSecondSurname());
//            return result;
//        }
//        throw new InvalidCredentialsException();
//    }
//}