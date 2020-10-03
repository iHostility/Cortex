/*
THIS FILE CONTAINS ENDPOINT HANDLERS
 */
package com.cortex.test.api;

import com.cortex.test.model.*;
import com.cortex.test.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RequestMapping(value = "/language")
@RestController
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    //Получить список каталога языков программирования
    //Запрос get: http://localhost:8080/language
    @GetMapping
    public HttpEntity<List<Language>> returnAllLanguage() {
        Request request = new Request(languageService.getAllLanguage());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new HttpEntity<>(request.getLanguages(), headers);
    }

    //Получить описание языка программирования по ключу “Java/C#/....”
    //Запрос get: http://localhost:8080/language/{Java/C#...}
    @GetMapping(path = "{name}")
    public HttpEntity getLanguageByName(@PathVariable("name") String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        final State state = new State("false");
        try {
            Language language = languageService.getLanguageByName(name);
            return new HttpEntity<>(language, headers);
        } catch (EmptyResultDataAccessException e) {
            return new HttpEntity<>(state, headers);
        }
    }

    //Добавить новый язык программирования, endpoint должен валидировать поля:
    //- “name”, возможные значения (Java, JavaScript, C#, C++, Python)
    //- “rating”, целое число от 1 до 5
    //Запрос post: http://localhost:8080/language
    @PostMapping
    public HttpEntity<Response> addLanguage(@NonNull @Valid @RequestBody Language language) {
        languageService.addLanguage(language);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        final Response responseAdd = new Response("ok",
                new Body(language.getName(),
                        language.getDescription(),
                        language.getRating()));
        return new HttpEntity<>(responseAdd, headers);
    }

    //Редактирование элемента в справочнике
    //Запрос put: http://localhost:8080/language/{Java/C#...}
    @PutMapping(path = "{name}")
    public HttpEntity<Response> updateLanguageByName(@PathVariable("name") String name, @NonNull @RequestBody Language languageToUpdate) {
        languageService.updateLanguage(name, languageToUpdate);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        final Response responseAdd = new Response("ok",
                new Body(name,
                        languageToUpdate.getDescription(),
                        languageToUpdate.getRating()));
        return new HttpEntity<>(responseAdd, headers);
    }

    //Удаление элемента в справочнике
    //Запрос delete: http://localhost:8080/language/{Java/C#...}
    @DeleteMapping(path = "{name}")
    public HttpEntity<State> deleteLanguageByName(@PathVariable("name") String name) {
        languageService.deleteLanguage(name);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        final State state = new State("ok");
        return new HttpEntity<>(state, headers);
    }
}
