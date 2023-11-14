package com.techbridge.sams.club.repositories;


import com.techbridge.sams.club.user.User;
import com.techbridge.sams.club.role.Role;
import com.techbridge.sams.club.user.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepo repo;


    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        Role roleAdmin = entityManager.find(Role.class, 1);
        User na = new User("name@codejava.net", "nam2020", "Ha Minh", "Nam");

        na.addRole(null);
        User savedUser = repo.save(na);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers() {
        Iterable<User> listUsers = repo.findAll();
        listUsers.forEach(user -> System.out.println(user));

    }

    @Test
    public void testGetUserById() {
        User userNam = repo.findById(1).get();
        assertThat(userNam).isNotNull();
    }


    @Test
    public void testGetUserByEmail() {
        String email = "look@gmail.com";
        User user = repo.getUserByEmail(email);

        assertThat(user).isNotNull();
    }

    @Test
    public void testCountById() {
        Integer id = 1;
        Long countById = repo.countById(id);
        assertThat(countById).isNotNull();
    }

    @Test
    public void testCreateNewUserWithTwoRoles() {
        Role roleAdmin = entityManager.find(Role.class,1);
        User user = new User("lo@gmail.com", "look1991@", "look", "look");

        user.addRole(roleAdmin);
        User savedUser = repo.save(user);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    void testEnableUser() {
        Integer id = 7;
        repo.updateEnabledStatus(id, true);

        User user = repo.findById(id).get();
        Assertions.assertThat(user.isEnabled()).isTrue();
    }
}