package com.cortex.test.dao;

import com.cortex.test.model.Language;

import java.util.List;

public interface LanguageDAO {

    int insertLanguage(Language language);

    List<Language> selectAllLanguage();

    Language selectLanguageByName(String name);

    int updateLanguageByName(String name, Language language);

    int deleteLanguageByName(String name);
}
