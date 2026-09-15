package br.com.ewerton.cadastro_de_contatos.controller;

import br.com.ewerton.cadastro_de_contatos.dto.ContactRequestDto;
import br.com.ewerton.cadastro_de_contatos.dto.ContactResponseDto;
import br.com.ewerton.cadastro_de_contatos.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactResponseDto addContact(@RequestBody ContactRequestDto contactRequestDto) {
        return contactService.save(contactRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContactResponseDto> findAllContacts() {
        return contactService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactResponseDto findById(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactResponseDto updateContact(@PathVariable Long id, @RequestBody ContactRequestDto contactRequestDto) {
        return contactService.update(id, contactRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Long id) {
        contactService.delete(id);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<ContactResponseDto> findByName(@RequestParam String name) {
        return contactService.findByName(name);
    }
}
