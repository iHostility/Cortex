package com.cortex.test.service;

import com.cortex.test.model.Language;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageRowMapper implements RowMapper<Language> {

    @Override
    public Language mapRow(ResultSet rs, int rowNum) throws SQLException {

        Language language = new Language(
                rs.getString("NAME"),
                rs.getString("DESCRIPTION"),
                rs.getInt("RATING"));
        return language;
    }
}
