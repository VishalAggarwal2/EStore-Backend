package com.onlineStore.EStore.Controller;

import com.onlineStore.EStore.DTO.ApiResponseMessage;
import com.onlineStore.EStore.Excptions.CustomExpectation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;


class  tempUser{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String  name;
    private String email;

}

@Controller
@RequestMapping("/test")
public class TestController {


    @GetMapping("/{message}")
    public ResponseEntity<ApiResponseMessage> messagetest(@PathVariable String message) throws CustomExpectation {
        if (message.equals("throw")) {
            throw new CustomExpectation("Custom exception thrown by myself");
        }

        System.out.println("Test Message");
        ApiResponseMessage messageResponse = ApiResponseMessage.builder()
                .message(message)
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }



    @GetMapping
    @ResponseBody
   public   LinkedList<tempUser>  check(){
        tempUser u = new tempUser();
        u.setName("vishal lnmiit");
        u.setEmail("test@gmail.com");

        tempUser u2 = new tempUser();
        u2.setName("vishal aggarwal");
        u2.setEmail("test2@gmail.com");
        System.out.println("called");

        LinkedList<tempUser> uuli= new LinkedList<tempUser>();
       uuli.add(u2);
       uuli.add(u);

        return uuli;
    }
}
