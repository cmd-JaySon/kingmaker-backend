package com.newsoft.kingmaker.service.system;

import com.newsoft.kingmaker.dto.system.SysUserReadDTO;
import com.newsoft.kingmaker.dto.system.SysUserWriteDTO;
import com.newsoft.kingmaker.entity.system.SysUser;
import com.newsoft.kingmaker.repository.system.SysUserReadRepository;
import com.newsoft.kingmaker.repository.system.SysUserWriteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SysUserService {
    private final SysUserWriteRepository sysUserWriteRepo;
    private final SysUserReadRepository sysUserReadRepo;

    public SysUserService(SysUserWriteRepository sysUserWriteRepo, SysUserReadRepository sysUserReadRepo) {
        this.sysUserWriteRepo = sysUserWriteRepo;
        this.sysUserReadRepo = sysUserReadRepo;
    }

    public Long create(SysUserWriteDTO dto) {
        if (sysUserWriteRepo.existsByUsername(dto.username())) {
            throw new IllegalArgumentException("用户名已存在");
        }
        SysUser user = new SysUser();
        user.setUsername(dto.username());
        user.setPassword(dto.password());
        user.setRealName(dto.realName());
        user.setCreatedAt(LocalDateTime.now());
        sysUserWriteRepo.save(user);
        return user.getId();
    }

    public List<SysUserReadDTO> getActiveUsers() {
        return sysUserReadRepo.queryActiveUsers();
    }
}
