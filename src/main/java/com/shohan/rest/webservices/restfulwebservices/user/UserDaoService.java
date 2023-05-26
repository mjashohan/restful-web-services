package com.shohan.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//DAO means Data Access Object
@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(1000)));
        users.add(new User(++userCount, "Hawwa", LocalDate.now().minusYears(900)));
        users.add(new User(++userCount, "Ibrahim", LocalDate.now().minusYears(189)));
    }


    public List<User> findAll() {
        return users;
    }

    public User save (User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
}
