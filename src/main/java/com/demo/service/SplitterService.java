package com.demo.service;

import java.util.List;

import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

import com.demo.domain.Article;

public class SplitterService extends AbstractMessageSplitter {

	@SuppressWarnings("unchecked")
	@Override
	protected List<Article> splitMessage(Message<?> message) {
		// TODO Auto-generated method stub
		return (List<Article>)message.getPayload();
	}

//    public List<Message<Article>> handleMessage(List<Article> articleList) {
////        System.out.println("In JdbcMessageHandler:" + articleList);
//        final List<Message<Article>> messages = new ArrayList<>();
//        for (Article emailFragment : articleList) {
//            Message<Article> message = MessageBuilder.withPayload(emailFragment).build();
//            messages.add(message);
//        }
//        return messages;
//        
//    }
//    public List<Article> split(List<Article> articleList) {
//      System.out.println("In JdbcMessageHandler:" + articleList);
//      
//      return (List<Article>)articleList;
//      
//  }
}
