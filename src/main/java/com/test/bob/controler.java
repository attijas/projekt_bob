package com.test.bob;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class controler {
    @GetMapping("/siema")
    public String sayhello(){
        return "Hobsiak  pije piwo i zjadl kebaba pati";
    }

    @GetMapping("/kalkulator")
    public String poprostu(@RequestParam int a, @RequestParam int b){
        int suma = a+b;
        return "suma:" + suma;
    }
}
