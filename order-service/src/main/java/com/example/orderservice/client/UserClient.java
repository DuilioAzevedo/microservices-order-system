package com.example.orderservice.client;

import com.example.orderservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service", url = "https://upgraded-chainsaw-p6q6x5w9wvwfrg4w-8080.app.github.dev")
public interface UserClient {

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id") Long id);
}