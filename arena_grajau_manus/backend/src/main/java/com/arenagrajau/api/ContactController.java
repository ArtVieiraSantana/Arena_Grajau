package com.arenagrajau.api;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @PostMapping
    public Map<String, String> sendContact(@RequestBody Map<String, String> contactData) {
        System.out.println("Recebido contato de: " + contactData.get("name"));
        // Como solicitado sem banco de dados, apenas simulamos o recebimento
        return Map.of("status", "success", "message", "Mensagem recebida com sucesso!");
    }
}
