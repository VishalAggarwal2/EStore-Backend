package com.onlineStore.EStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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



    @GetMapping
    @ResponseBody
   public   LinkedList<tempUser>  check(){
        tempUser u = new tempUser();
        u.setName("vishal");
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
