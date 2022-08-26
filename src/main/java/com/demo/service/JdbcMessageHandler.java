package com.demo.service;

import java.util.List;

import com.demo.domain.Article;

public class JdbcMessageHandler {

    public void handleMessage(List<Article> articleList) {
        System.out.println("In JdbcMessageHandler:" + articleList);
    }
}