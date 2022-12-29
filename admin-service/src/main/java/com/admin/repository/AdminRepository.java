package com.admin.repository;

import com.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    Admin getByAdminIdAndAdminPassword(String adminId, String adminPassword);
}
