package com.example.task_3_1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.task_3_1_2.model.User;
import com.example.task_3_1_2.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String printUsers(Model model) {
        model.addAttribute("list", userService.getAllUsers());
        return "users-table";
    }

    @GetMapping(value = "/edit-table")
    public String editUsers(Model model) {
        model.addAttribute("list", userService.getAllUsers());
        return "edit-table";
    }

    @GetMapping(value = "/add-user")
    public String getAddingPage() {
        return "add-user";
    }

    @GetMapping(value = "/successfully-added")
    public String getConfirmationOfAdding(@RequestParam(value = "name") String name,
                                          @RequestParam(value = "lastName") String lastName,
                                          @RequestParam(value = "age") int age) {
        User user = new User(name, lastName, age);
        userService.add(user);
        return "successfully-added";
    }

    @GetMapping(value = "/delete-user")
    public String getDeletingPage(Model model) {
        model.addAttribute("list", userService.getAllUsers());
        return "delete-user";
    }

    @GetMapping(value = "/successfully-deleted")
    public String getConfirmationOfDeleting(@RequestParam(value = "id") int id) {
        userService.remove(id);
        return "successfully-deleted";
    }

    @GetMapping(value = "/update-user")
    public String getUpdatingPage(Model model) {
        model.addAttribute("list", userService.getAllUsers());
        return "update-user";
    }

    @GetMapping(value = "/successfully-updated")
    public String getConfirmationOfUpdating(@RequestParam(value = "id") int id,
                                            @RequestParam(value = "name") String name,
                                            @RequestParam(value = "lastName") String lastName,
                                            @RequestParam(value = "age") int age) {
        User user = new User(name, lastName, age);
        user.setId(id);
        userService.update(user);
        return "successfully-updated";
    }
}
