//package com.APIProject.apiProject.api;
//
//import com.APIProject.apiProject.domain.model.IssueModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@Service
//public class IssueClientService {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    private final String ROOT_URI = "http://e185ce9b.ngrok.io/api/Issue/";
//
//    public List<IssueModel> finAll() {
//        ResponseEntity<IssueModel[]> response = restTemplate.getForEntity(ROOT_URI, IssueModel[].class);
//        return Arrays.asList(response.getBody());
//    }
//
//    public IssueModel findById(int id) {
//        ResponseEntity<IssueModel> response =
//                restTemplate.getForEntity(ROOT_URI
//                        + "/" + id, IssueModel.class);
//        return response.getBody();
//    }
//
////    public IssueModel add(Usuario person) {
////        ResponseEntity<IssueModel> response =
////                restTemplate.postForEntity(ROOT_URI,
////                        person, IssueModel.class);
////        return response.getBody();
////    }
//
//    public void update(IssueModel issue, int id) {
//        restTemplate
//                .put(ROOT_URI+ "/" + id, issue, IssueModel.class);
//    }
//
//    public void delete(Integer id) {
//        restTemplate.delete(ROOT_URI + id);
//
//    }
//}

