package com.arenagrajau.site.controller;

import com.arenagrajau.site.dto.ContactRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Endpoint de contato da escolinha.
 * Nao existe banco de dados: a mensagem e validada e registrada no log do
 * servidor. Se no futuro quiser receber por e-mail, basta injetar um
 * JavaMailSender aqui dentro do metodo receberMensagem().
 */
@RestController
@RequestMapping("/api")
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        return ResponseEntity.ok(Map.of(
                "status", "ok",
                "servico", "Arena Grajau - API",
                "horario", LocalDateTime.now().toString()
        ));
    }

    @PostMapping("/contato")
    public ResponseEntity<Map<String, Object>> receberMensagem(@Valid @RequestBody ContactRequest dados) {
        log.info("Novo contato recebido | nome={} | telefone={} | email={} | mensagem={}",
                dados.getNome(), dados.getTelefone(), dados.getEmail(), dados.getMensagem());

        return ResponseEntity.ok(Map.of(
                "sucesso", true,
                "mensagem", "Recebemos sua mensagem! Nossa equipe vai te responder em breve."
        ));
    }
}
