package br.com.ewerton.cadastro_de_contatos.dto;

import java.time.LocalDateTime;

public record ContactResponseDto (
    Long id,
    String name,
    String email,
    String phone,
    String address,
    LocalDateTime createdAt
){}
