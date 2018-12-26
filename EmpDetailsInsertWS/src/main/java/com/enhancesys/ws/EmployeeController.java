package com.enhancesys.ws;

import org.bson.Document;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

	private final String sharedKey = "SHARED_KEY";

	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int CODE_SUCCESS = 100;
	private static final int AUTH_FAILURE = 102;
	// @Autowired
	// private DBUtils DBUtils;

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public BaseResponseImpl saveData(@RequestParam(value = "key") String key, @RequestBody EmployeeImpl request) {

		BaseResponseImpl response = new BaseResponseImpl();

		if (sharedKey.equalsIgnoreCase(key)) {
			int id = request.get_id();
			String name = request.getName();
			int salary = request.getSalary();

			response.setStatus(SUCCESS_STATUS);
			response.setCode(CODE_SUCCESS);

			System.out.println(
					"If condition " + "status : " + response.getStatus() + " status code :  " + response.getCode());

			if (response.getCode() == 100) {

				MongoClient mongoClient = new MongoClient("localhost", 27017);
				MongoDatabase database = mongoClient.getDatabase("employeedb");
				MongoCollection<Document> collection = database.getCollection("employes");

				Document document = new Document();
				document.append("_id", request.get_id());
				document.append("name", request.getName());
				document.append("salary", request.getSalary());

				collection.insertOne(document);
				// System.out.println(id + " " + name + " " + salary);
				System.out.println("document successfully inserted");
				mongoClient.close();
			}

			System.out.println(id + " " + name + " " + salary);
		} else {
			response.setStatus(ERROR_STATUS);
			response.setCode(AUTH_FAILURE);
			System.out.println("else condition " + response.getStatus() + " " + response.getCode());
		}
		return response;
	}
}
