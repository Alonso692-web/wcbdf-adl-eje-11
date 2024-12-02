package com.upiiz.securitydb.repositories;

import com.upiiz.securitydb.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
}
