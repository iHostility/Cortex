package com.cortex.test.dao;

import com.cortex.test.model.Language;
import com.cortex.test.service.LanguageRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgres")
public class LanguageDataAccessService implements com.cortex.test.dao.LanguageDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LanguageDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertLanguage(Language language) {
        final String sql = "INSERT INTO language (name, description, rating) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, language.getName(), language.getDescription(), language.getRating());
        return 1;
    }

    @Override
    public List<Language> selectAllLanguage() {
        final String sql = "SELECT * FROM language";
        return jdbcTemplate.query(sql, new LanguageRowMapper());
    }

    @Override
    public Language selectLanguageByName(String name) throws EmptyResultDataAccessException {
        final String sql = "SELECT * FROM language WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new LanguageRowMapper());
    }

    @Override
    public int updateLanguageByName(String name, Language newLanguage) {
        final String sql = "UPDATE language SET description = ?, rating = ? WHERE name = ?";
        jdbcTemplate.update(sql, newLanguage.getDescription(), newLanguage.getRating(), name);
        return 1;
    }

    @Override
    public int deleteLanguageByName(String name) {
        final String sql = "DELETE FROM language WHERE name = ?";
        jdbcTemplate.update(sql, name);
        return 1;
    }
}