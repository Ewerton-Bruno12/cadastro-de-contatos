package br.com.ewerton.cadastro_de_contatos.service;

import br.com.ewerton.cadastro_de_contatos.dto.ContactRequestDto;
import br.com.ewerton.cadastro_de_contatos.dto.ContactResponseDto;
import br.com.ewerton.cadastro_de_contatos.exception.EmailAlreadyExistsException;
import br.com.ewerton.cadastro_de_contatos.exception.ResourceNotFoundException;
import br.com.ewerton.cadastro_de_contatos.model.ContactEntity;
import br.com.ewerton.cadastro_de_contatos.repository.IContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final IContactRepository contactRepository;

    @Transactional(readOnly = true)
    public List<ContactResponseDto> findAll() {
        return contactRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public ContactResponseDto findById(Long id) {
        return contactRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Contato com o ID " + id + " não foi encontrado"));
    }

    @Transactional
    public ContactResponseDto save(ContactRequestDto contactRequestDto) {
        if (contactRepository.existsByEmail(contactRequestDto.email())) {
            throw new EmailAlreadyExistsException(("O e-mail '" + contactRequestDto.email() + "' já está cadastrado."));
        }

        ContactEntity newContact = ContactEntity.builder()
                .name(contactRequestDto.name())
                .email(contactRequestDto.email())
                .phone(contactRequestDto.phone())
                .address(contactRequestDto.address())
                .build();

        ContactEntity savedContact = contactRepository.save(newContact);
        return toDto(savedContact);
    }

    @Transactional
    public ContactResponseDto update(Long id, ContactRequestDto contactRequestDto) {
        ContactEntity existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado"));

        existingContact.setName(contactRequestDto.name());
        existingContact.setEmail(contactRequestDto.email());
        existingContact.setPhone(contactRequestDto.phone());
        existingContact.setAddress(contactRequestDto.address());

        ContactEntity updatedContact = contactRepository.save(existingContact);
        return toDto(updatedContact);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new ResourceNotFoundException("Contato não encontrada");
        }

        contactRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<ContactResponseDto> findByName(String name) {
        return contactRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::toDto)
                .toList();
    }

    public ContactResponseDto toDto(ContactEntity contact) {
        return new ContactResponseDto(
                contact.getId(),
                contact.getName(),
                contact.getEmail(),
                contact.getPhone(),
                contact.getAddress(),
                contact.getCreatedAt()
        );
    }

}
