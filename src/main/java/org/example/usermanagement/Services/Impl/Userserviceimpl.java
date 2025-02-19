package org.example.usermanagement.Services.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.usermanagement.Dto.Userdto;
import org.example.usermanagement.Model.Userdomain;
import org.example.usermanagement.Reposatory.Userrepo;
import org.example.usermanagement.Services.Userservice;
import org.example.usermanagement.Utils.APIResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Userserviceimpl implements Userservice {
    @Autowired
    private ModelMapper modelmapper;

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Userrepo userrepo;

    public APIResponse<String> save(Userdto userdto) {
        Userdomain userdomain = modelmapper.map(userdto, Userdomain.class);
        System.out.println(userdomain.toString());
        userrepo.save(userdomain);
        try {
            String userdomainJson = new ObjectMapper().writeValueAsString(userdomain);
            jmsTemplate.convertAndSend("queue-one",userdomainJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new APIResponse<>("User saved successfully");
    }
}
