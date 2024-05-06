package com.beans.users.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/auth/management")
public class ManagementController {
    @GetMapping()
    public String get() {
        return "GET:: management controller";
    }

    @PostMapping()
    public String post() {
        return "POST:: management controller";
    }

    @PutMapping()
    public String put() {
        return "PUT:: management controller";
    }

    @DeleteMapping()
    public String delete() {
        return "DELETE:: management controller";
    }
}
