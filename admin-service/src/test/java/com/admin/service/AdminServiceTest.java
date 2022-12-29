package com.admin.service;

import com.admin.entity.Admin;
import com.admin.repository.AdminRepository;
import com.admin.service.impl.AdminServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks  // Creates the mock object of AdminServiceImpl and injects into that is marked with @Mock annotation
    private AdminServiceImpl adminService;

    @DisplayName("JUnit test for admin get by adminId and Password")
    @Test
    public void givenAdmin_whenFindByAdminIdAndAdminPassword_then() {
        Admin admin = new Admin();
        BDDMockito.given(adminRepository.getByAdminIdAndAdminPassword(admin.getAdminId(), admin.getAdminPassword()))
                .willReturn(admin);

        Admin receivedAdmin = adminService.getByAdminIdAndAdminPassword(admin.getAdminId(), admin.getAdminPassword());

        Assertions.assertThat(receivedAdmin).isNotNull();
    }
}
