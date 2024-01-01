package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOptions;

import java.util.List;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Autowired
    private MongoTemplate mongoTemplate;

	@RequestMapping("/")
	String home() {
		// // // // // //
		// find 쿼리
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("kkj"));
		// query.addCriteria(Criteria.where("keywords.keyword").is("t").and("cdIdx").is(2));
		// query.cursorBatchSize(100);
		// List<String> documents = mongoTemplate.findAll(String.class, "employees");
		List<String> documents = mongoTemplate.find(query, String.class, "employees");
		// // // // // //

        // 조회된 문서 출력
        StringBuilder result = new StringBuilder("MongoDB Documents:\n");
        documents.forEach(document -> result.append(document).append("\n"));

        return result.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
