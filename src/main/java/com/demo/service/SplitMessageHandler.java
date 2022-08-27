package com.demo.service;

import java.util.List;

import com.demo.domain.Article;

public class SplitMessageHandler {

    public void handleMessage(Article articleList) {
        System.out.println("In JdbcMessageHandler:" + articleList);
    }
}