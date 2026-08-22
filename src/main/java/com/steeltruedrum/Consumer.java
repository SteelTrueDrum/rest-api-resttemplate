package com.steeltruedrum;

import com.steeltruedrum.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3.1.5 Working with REST-API via RestTemplate
 * @author Volkov Ivan
 * <ul>
 *     <li>Получение всех пользователей - …/api/users (GET)</li>
 *     <li>Добавление пользователя - …/api/users (POST)</li>
 *     <li>Изменение пользователя - …/api/users (PUT)</li>
 *     <li>Удаление пользователя - …/api/users /{id} (DELETE)</li>
 * </ul>
 * */

public class Consumer {
    public static void main(String[] args) {
        // Адрес url по которому предоставляется доступ к API
        String url = "http://94.198.50.185:7081/api/users";
        String result = null;



        RestTemplate restTemplate = new RestTemplate();

//        1. Get list of all users
        List<User> userList = new ArrayList<>();
        String getResponse = restTemplate.getForObject(url, String.class);
        System.out.println(getResponse);

//        2. get and save session id (get object ResponseEntity)

//        3. save user with id = 3
        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("id", "3");
        jsonToSend.put("name", "James");
        jsonToSend.put("lastName", "Brown");
        jsonToSend.put("age", "39");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);

        String postResponse = restTemplate.postForObject(url, request, String.class);

//        4. update name set name = Thomas and lastName = Shelby where id = 3
//        restTemplate.put();
//        5. delete user where id = 3
//        restTemplate.delete();

//        6. getting final result
    }
}
