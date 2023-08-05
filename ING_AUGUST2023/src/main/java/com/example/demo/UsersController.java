package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("users")
public class UsersController {

    private UsersService usersService;

    UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    public void setUsersService(UsersService usersService) {

    }

    @GetMapping("/{username}/items/total")
    public Map<String, Integer> totalItemsBought(@PathVariable String username) {
        Map<String, Integer> result = new HashMap<>();
        System.out.println(username);
        result.put("total", this.usersService.getNumberOfItemsBought(username));
        return result;
    }
}
