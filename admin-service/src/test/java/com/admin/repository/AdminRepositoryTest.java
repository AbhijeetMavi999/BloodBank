package com.admin.repository;

import com.admin.entity.Admin;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;

    @DisplayName("JUnit test for get admin by adminId and password")
    @Test
    public void givenAdmin_whenFindByEmailAndPassword_thenReturnAdmin() {

        Admin admin = Admin.builder()
                .adminId("abhijeet")
                .adminPassword("password@123")
                .build();

        adminRepository.save(admin);

        Admin receivedAdmin = adminRepository.getByAdminIdAndAdminPassword(admin.getAdminId(), admin.getAdminPassword());

        Assertions.assertThat(receivedAdmin).isNotNull();
    }
}
