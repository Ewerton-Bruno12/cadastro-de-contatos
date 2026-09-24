package br.com.ewerton.cadastro_de_contatos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ContactRequestDto (
    @NotBlank(message = "Nome é obrigatório")
    String name,
    @Email(message = "Email inválido")
    String email,
    @Pattern(
            regexp = "^\\d{10,11}$",
            message = "Telefone inválido. Use apenas números com DDD (10 ou 11 dígitos)"
    )
    String phone,
    String address
) {}
