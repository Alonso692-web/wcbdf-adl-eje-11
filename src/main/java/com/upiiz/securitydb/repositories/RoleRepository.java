package com.upiiz.securitydb.repositories;

import com.upiiz.securitydb.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
