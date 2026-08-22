package com.steeltruedrum;

import org.springframework.web.client.RestTemplate;

/**
 * 3.1.5 Working with REST-API via RestTemplate
 * @author Volkov Ivan
 * */

public class Consumer {
    public static void main(String[] args) {
        // Адрес url по которому предоставляется доступ к API
        String url = "http://94.198.50.185:7081/api/users";

        RestTemplate restTemplate = new RestTemplate();


//        1. Get list of all users


//        2. save session id

//        3. save user with id = 3

//        4. update name set name = Thomas and lastName = Shelby where id = 3

//        5. delete user where id = 3

//        6. getting final result
    }
}
