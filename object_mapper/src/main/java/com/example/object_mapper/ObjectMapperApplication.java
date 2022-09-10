package com.example.object_mapper;

import com.example.object_mapper.dto.Car;
import com.example.object_mapper.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ObjectMapperApplication {

    public static void main(String[] args) throws JsonProcessingException {

//        SpringApplication.run(ObjectMapperApplication.class, args);
        System.out.println("main");

        ObjectMapper objectMapper = new ObjectMapper();

        // objectMapper에 사용할 객체
        User user = new User();
        user.setName("홍길동");
        user.setAge(26);

        Car car1 = new Car();
        car1.setName("K9");
        car1.setCarNumber("11가 1234");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("XM3");
        car2.setCarNumber("22가 3456");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setCars(carList);

//        System.out.println(user);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("name : " + _name);
        System.out.println("age : " + _age);

        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) cars;

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println("cars : " + _cars);

        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "steve");
        objectNode.put("age", 20);
        System.out.println(objectNode.toPrettyString());
    }

}
