//package ru.arkhipov.MySecondTestAppSpringBoot.service;
//
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import ru.arkhipov.MySecondTestAppSpringBoot.model.Request;
//import ru.arkhipov.MySecondTestAppSpringBoot.model.Systems;
//
//
//@Service
//public class ModifySystemNameRequestService implements ModifyRequestService{
//
//    @Override
//    public void modify(Request request) {
//        request.setSystemName(Systems.valueOf("Service1"));
//
//        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
//
//        new RestTemplate().exchange("http://localhost:8084/feedback",
//                HttpMethod.POST,
//                httpEntity,
//                new ParameterizedTypeReference<>() {
//                });
//    }
//}
