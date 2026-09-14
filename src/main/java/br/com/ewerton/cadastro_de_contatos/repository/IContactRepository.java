package br.com.ewerton.cadastro_de_contatos.repository;

import br.com.ewerton.cadastro_de_contatos.model.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContactRepository extends JpaRepository<ContactEntity, Long> {

    List<ContactEntity> findByNameContainingIgnoreCase(String name);
}
