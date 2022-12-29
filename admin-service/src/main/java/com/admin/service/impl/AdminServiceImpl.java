package com.admin.service.impl;

import com.admin.entity.Admin;
import com.admin.exception.AdminNotFoundException;
import com.admin.repository.AdminRepository;
import com.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin getByAdminIdAndAdminPassword(String adminId, String adminPassword) {
        log.info("getByAdminIdAndAdminPassword() method of AdminService is called");
        Admin receiveAdmin = adminRepository.getByAdminIdAndAdminPassword(adminId, adminPassword);
        if(receiveAdmin == null) {
            log.warn("Admin not found");
            throw new AdminNotFoundException("Admin not found!");
        }
        return receiveAdmin;
    }
}
