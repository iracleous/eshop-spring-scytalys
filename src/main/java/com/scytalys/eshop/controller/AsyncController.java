package com.scytalys.eshop.controller;

import com.scytalys.eshop.service.HardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class AsyncController {
    private final HardService asyncService;

    @GetMapping("/async")
    public CompletableFuture<String> callAsyncMethod() {

        return asyncService.doSomethingHard();
    }
}
