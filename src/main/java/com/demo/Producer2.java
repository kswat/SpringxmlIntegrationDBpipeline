package com.demo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.demo.domain.Article;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Producer2 {

	String articles = "[{\"id\": 1, \"name\": \"SpringIntegration Example\", \"category\": \"spring\", \"tags\":\"spring,integration\", \"author\":\"Joe\", \"sent\":0},"
			+ "{\"id\": 2, \"name\": \"NamedParameterJdbcTemplate Example\", \"category\": \"spring\", \"tags\":\"spring,jdbcTemplate\", \"author\":\"Sam\", \"sent\":0},"
			+ "{\"id\": 3, \"name\": \"MVC Example\", \"category\": \"spring\", \"tags\":\"spring 5\", \"author\":\"Joe\", \"sent\":0}]";
	//"id": 1, "name": "SpringIntegration Example", "category": "spring", "tags":"spring,integration", "author":"Joe", "sent":0

	
//	("\"id\":", name, category, tags, author, sent) values (1, "SpringIntegration Example", "spring", "spring,integration", "Joe", 0);
//	(id, name, category, tags, author, sent) values (2, "NamedParameterJdbcTemplate Example", "spring", "spring,jdbcTemplate", "Sam", 0);
//	(id, name, category, tags, author, sent) values (3, "MVC Example", "spring", "spring", "Joe", 0);
	
	public List<Article> produce() {
		ObjectMapper mapper = new ObjectMapper();
		Article[] asArray = null;
		try {
			asArray = mapper.readValue(articles, Article[].class);
			
			Arrays.asList(asArray).stream().forEach(a -> a.setMsg(getFileAsString()));
			//.collect(Collectors.toList());
			
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return Arrays.asList(asArray);
		
//        String testJson = "{\n" + "  \"user\": {\n" + "    \"0\": {\n" + "      \"firstName\": \"Monica\",\n" + "      \"lastName\": \"Belluci\"\n" + "    },\n" + "    \"1\": {\n" + "      \"firstName\": \"John\",\n" + "      \"lastName\": \"Smith\"\n" + "    },\n" + "    \"2\": {\n" + "      \"firstName\": \"Owen\",\n" + "      \"lastName\": \"Hargreaves\"\n" + "    }\n" + "  }\n" + "}";
//        User readValue = mapper.readValue(testJson, User.class);
//        System.out.println("readValue = " + readValue);
        
//        Article article = new Article();
//        article.setId(1);
//        article.setCategory("category");
//        article.setAuthor("author");
//        article.setName("name");
//        article.setTags("tags");
//        try {
//        	article.setMsg(getFileAsString());
//        }catch(Exception e) {}
//        
//        return article;
	}
	
	private String getFileAsString()  {
		
		File xmlFile = null;
		try {
			xmlFile = getFileFromResource("data.xml");
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getContent(xmlFile);
		
//		printFile(xmlFile);
//		// parsing XML file to get as String using DOM Parser
//        DocumentBuilderFactory dbFactory 
//             = DocumentBuilderFactory.newInstance();
//        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
//        Document xmlDom = docBuilder.parse(xmlFile);
//        
//        String xmlAsString = xmlDom.toString(); 
//        // this will not print what you want
////        System.out.println("XML as String using DOM Parser : ");
//        System.out.println(xmlAsString);
//        return xmlAsString;
	}
	
	private  String getContent(File file) {
		String content = null;
//        List<String> lines;
        try {
//            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
//            lines.forEach(System.out::println);
            content = Files.lines(file.toPath(), StandardCharsets.UTF_8)
                    .collect(Collectors.joining(System.lineSeparator()));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content ;

    }
	
    private File getFileFromResource(String fileName) throws URISyntaxException, IOException {

//        ClassLoader classLoader = getClass().getClassLoader();
//        URL resource = classLoader.getResource(fileName);
//        if (resource == null) {
//            throw new IllegalArgumentException("file not found! " + fileName);
//        } else {
//
//            // failed if files have whitespaces or special characters
//            //return new File(resource.getFile());
//
//            return new File(resource.toURI());
//        }

//        File file = new File(
//        		getClass().getClassLoader().getResource(fileName).getFile()
//        	);
//        

    	
    	Resource resource = new ClassPathResource(fileName);

    	InputStream input = resource.getInputStream();

    	File file = resource.getFile();
    	
    	return file;
    }
}
