package org.example.usermanagement.Controller;

import org.example.usermanagement.Dto.Userdto;
import org.example.usermanagement.Services.Userservice;
import org.example.usermanagement.Utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserAPI {

    @Autowired
    private Userservice userservice;

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("data")
    public ResponseEntity<APIResponse<String>> saveUser(@RequestBody Userdto user) {
        return new ResponseEntity<>(userservice.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/send")
    public ResponseEntity<APIResponse<String>> sendUser(@RequestParam String message) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
