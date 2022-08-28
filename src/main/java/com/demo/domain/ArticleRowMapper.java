package com.demo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ArticleRowMapper implements RowMapper<Article> {

    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
                        
        Article article = new Article();
        article.setId(rs.getInt("id"));
        article.setCategory(rs.getString("category"));
        article.setAuthor(rs.getString("author"));
        article.setName(rs.getString("name"));
        article.setTags(rs.getString("tags"));
        article.setMsg(rs.getString("msg"));
        return article;
    }
}