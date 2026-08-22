package com.steeltruedrum;

import com.steeltruedrum.model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3.1.5 Working with REST-API via RestTemplate
 *
 * @author Volkov Ivan
 * <ul>
 *     <li>Получение всех пользователей - …/api/users (GET)</li>
 *     <li>Добавление пользователя - …/api/users (POST)</li>
 *     <li>Изменение пользователя - …/api/users (PUT)</li>
 *     <li>Удаление пользователя - …/api/users /{id} (DELETE)</li>
 * </ul>
 *
 */

public class Consumer {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        // Адрес url по которому предоставляется доступ к API
        String url = "http://94.198.50.185:7081/api/users";
        StringBuilder result = new StringBuilder();

//      get sessionId (headers)
        ResponseEntity<String> responseGet = restTemplate.exchange(
                url, HttpMethod.GET, null, String.class);

        String sessionId = responseGet.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        System.out.println(sessionId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.COOKIE, sessionId);

//      get list of all users
        String getResponse = restTemplate.getForObject(url, String.class);
        System.out.println(getResponse);

//      save user with id = 3
        User james = new User(3L, "James", "Brown", (byte) 39);
        HttpEntity<User> postUserEntity = new HttpEntity<>(james, headers);

        ResponseEntity<String> responsePost = restTemplate.exchange(
                url, HttpMethod.POST, postUserEntity, String.class);
        String part1 = responsePost.getBody();
        result.append(part1);

//      update name set name = Thomas and lastName = Shelby where id = 3
        User thomas = new User(3L, "Thomas", "Shelby", (byte) 43);
        HttpEntity<User> putUserEntity = new HttpEntity<>(thomas, headers);
        ResponseEntity<String> responsePut = restTemplate.exchange(
                url, HttpMethod.PUT, putUserEntity, String.class);
        String part2 = responsePut.getBody();
        result.append(part2);

//      delete user where id = 3
        String deleteUrl = url + "/3";
        HttpEntity<Void> deleteUserEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseDelete = restTemplate.exchange(
                deleteUrl, HttpMethod.DELETE, deleteUserEntity, String.class);
        String part3 = responseDelete.getBody();
        result.append(part3);

//      getting final result
        System.out.println("\nФинальный 18-значный код для платформы:");
        System.out.println(result.toString());
    }
}
