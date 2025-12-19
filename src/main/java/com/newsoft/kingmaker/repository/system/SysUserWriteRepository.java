package com.newsoft.kingmaker.repository.system;

import com.newsoft.kingmaker.entity.system.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserWriteRepository extends JpaRepository<SysUser, Long> {
    boolean existsByUsername(String username);
}
