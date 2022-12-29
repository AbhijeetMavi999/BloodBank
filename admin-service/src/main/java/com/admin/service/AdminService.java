package com.admin.service;

import com.admin.entity.Admin;

public interface AdminService {

    public Admin getByAdminIdAndAdminPassword(String adminId, String adminPassword);
}
