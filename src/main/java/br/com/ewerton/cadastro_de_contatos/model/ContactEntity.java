package br.com.ewerton.cadastro_de_contatos.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_contact")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;
    
    private String phone;

    private String address;

    @CreatedDate // Faz com que o Spring injete a data/hora atual no momento do save
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
