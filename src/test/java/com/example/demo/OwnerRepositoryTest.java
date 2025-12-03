package com.example.demo;

import com.example.demo.domain.Owner;
import com.example.demo.domain.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository repo;

    @Test
    void saveAndFindOwner() {
        Owner o = new Owner("Lucy", "Smith");
        repo.save(o);

        var found = repo.findById(o.getOwnerid());
        assertThat(found).isPresent();
        assertThat(found.get().getFirstname()).isEqualTo("Lucy");
    }

    @Test
    void deleteAllOwners() {
        repo.save(new Owner("Mike", "White"));
        repo.deleteAll();
        assertThat(repo.count()).isZero();
    }
}