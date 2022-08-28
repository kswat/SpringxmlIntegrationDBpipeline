package com.demo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

import com.demo.domain.Article;

public class Producer {

	public Article produce() {
        Article article = new Article();
        article.setId(1);
        article.setCategory("category");
        article.setAuthor("author");
        article.setName("name");
        article.setTags("tags");
        try {
        	article.setMsg(getFileAsString());
        }catch(Exception e) {}
        
        return article;
	}
	
	private String getFileAsString() throws URISyntaxException, ParserConfigurationException, SAXException, IOException {
		
		Resource resource = new ClassPathResource("data.xml");
		File file = resource.getFile(); 
		return getContent(file);
		
	}
	
	private  String getContent(File file) {
		String content = null;
        try {
//            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            content = Files.lines(file.toPath(), StandardCharsets.UTF_8)
                    .collect(Collectors.joining(System.lineSeparator()));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content ;
    }
	
}
