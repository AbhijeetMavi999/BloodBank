package com.admin.controller;

import com.admin.entity.Admin;
import com.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/{adminId}/{adminPassword}")
    public ResponseEntity<Admin> getByAdminIdAndAdminPassword(@PathVariable("adminId") String adminId, @PathVariable("adminPassword") String adminPassword) {
        log.info("getByAdminIdAndAdminPassword() method of AdminController is called");
        Admin receiveAdmin = adminService.getByAdminIdAndAdminPassword(adminId, adminPassword);
        return new ResponseEntity<>(receiveAdmin, HttpStatus.OK);
    }
}
