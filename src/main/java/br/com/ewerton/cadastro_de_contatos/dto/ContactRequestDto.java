package br.com.ewerton.cadastro_de_contatos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContactRequestDto (
    @NotBlank(message = "Nome é obrigatório")
    String name,
    @Email(message = "Email inválido")
    String email,
    String phone,
    String address
) {}
