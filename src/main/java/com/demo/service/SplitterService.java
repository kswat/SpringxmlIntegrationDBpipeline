package com.demo.service;

import java.util.List;

import org.springframework.messaging.Message;

import com.demo.domain.Article;

public class SplitterService  {

//    public List<Message<Article>> handleMessage(List<Article> articleList) {
////        System.out.println("In JdbcMessageHandler:" + articleList);
//        final List<Message<Article>> messages = new ArrayList<>();
//        for (Article emailFragment : articleList) {
//            Message<Article> message = MessageBuilder.withPayload(emailFragment).build();
//            messages.add(message);
//        }
//        return messages;    
//    }
    public List<Article> split(Message<?> message) {
           
      return (List<Article>)message.getPayload();
      
  }
}
