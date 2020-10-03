package com.cortex.test.service;

import com.cortex.test.dao.LanguageDAO;
import com.cortex.test.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageDAO languageDAO;

    @Autowired
    public LanguageService(@Qualifier("postgres") LanguageDAO languageDAO) {
        this.languageDAO = languageDAO;
    }

    public int addLanguage(Language language) {
        return languageDAO.insertLanguage(language);
    }

    public List<Language> getAllLanguage() {
        return languageDAO.selectAllLanguage();
    }

    public Language getLanguageByName(String name) {
        return languageDAO.selectLanguageByName(name);
    }

    public int updateLanguage(String name, Language newLanguage) {
        return languageDAO.updateLanguageByName(name, newLanguage);
    }

    public int deleteLanguage(String name) {
        return languageDAO.deleteLanguageByName(name);
    }

}
