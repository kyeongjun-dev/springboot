package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Autowired
    private MongoTemplate mongoTemplate;

	@RequestMapping("/one")
	String home() {
		// find 쿼리
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("kkj"));
		// query.cursorBatchSize(100);
		List<String> documents = mongoTemplate.find(query, String.class, "employees");

        // 조회된 문서 출력
        StringBuilder result = new StringBuilder("MongoDB Documents:\n");
        documents.forEach(document -> result.append(document).append("\n"));

        return "Number of MongoDB Documents: " + documents.size();
	}

	@RequestMapping("/all")
	String all() {
		// find all 쿼리
		Query query = new Query();
		query.cursorBatchSize(100);
		List<String> documents = mongoTemplate.find(query, String.class, "employees");

        // 조회된 문서 출력
        // StringBuilder result = new StringBuilder("MongoDB Documents:\n");
        // documents.forEach(document -> result.append(document).append("\n"));

        return "Number of MongoDB Documents: " + documents.size();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
