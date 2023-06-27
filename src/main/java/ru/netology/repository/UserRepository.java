package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static ru.netology.repository.Authorities.*;

@Repository
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        users = new CopyOnWriteArrayList<>();
        users.add(new User("Kristina", "1998", Arrays.asList(READ, WRITE, DELETE)));
        users.add(new User("Evgeniy", "1995", Arrays.asList(READ, WRITE)));
        users.add(new User("Grigory", "1997", Arrays.asList(READ, DELETE)));
        users.add(new User("Alexander", "1994", List.of(DELETE)));
        users.add(new User("Tatyna", "1975", Arrays.asList(WRITE, DELETE)));
        users.forEach(System.out::println);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = Collections.emptyList();
        for (User p : users) {
            if (p.getUser().equals(user) && p.getPassword().equals(password))
                authorities = p.getAuthoritiesList();
        }
        return authorities;
    }
}
