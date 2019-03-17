package ro.fiipractic.mycinema.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {


    @GetMapping(value = "/hello1")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping(value = "/hello2")
    public String helloWorld2() {
        return "hello world 2";
    }

    @PostMapping(value = "/number/{number}")
    public String printMyNumber(@PathVariable("number") Integer myNumber) {
        return "My number is " + myNumber;
    }

    @PostMapping(value = "/name")
    public String printMyName(@RequestBody String myName) {
        return "My name is " + myName;
    }

    //asaasasa
}
