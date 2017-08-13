package com.kpi.diploma.smartroads;

import com.kpi.diploma.smartroads.model.document.Role;
import com.kpi.diploma.smartroads.model.document.User;
import com.kpi.diploma.smartroads.model.title.Documents;
import com.kpi.diploma.smartroads.repository.RoleRepository;
import com.kpi.diploma.smartroads.repository.UserRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
@Slf4j
public class SmartRoadsApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final MongoClient mongoClient;

	@Autowired
	public SmartRoadsApplication(UserRepository userRepository,
								 RoleRepository roleRepository,
								 MongoClient mongoClient) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.mongoClient = mongoClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(SmartRoadsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		mongoClient.getDatabase("smartroads")
				.getCollection(Documents.USER).deleteMany(new Document());

		User user1 = new User("email1", "pass1");
		Role test1 = new Role("test1");
		Role test2 = new Role("test2");
		user1.getRoles().add(test1);
		user1.getRoles().add(test2);
		user1.setEnable(true);
		userRepository.save(user1);

		log.info("users was loaded '{}'", userRepository.findAll().size());
	}
}
