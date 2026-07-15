package com.arenagrajau.site.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactRequest {

    @NotBlank(message = "Informe o nome do responsavel.")
    @Size(max = 120)
    private String nome;

    @NotBlank(message = "Informe um telefone/WhatsApp para retorno.")
    @Size(max = 30)
    private String telefone;

    @Email(message = "Informe um e-mail valido.")
    @Size(max = 150)
    private String email;

    @NotBlank(message = "Escreva uma mensagem.")
    @Size(max = 1000)
    private String mensagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
