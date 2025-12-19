package com.newsoft.kingmaker.repository.system;

import com.newsoft.kingmaker.dto.system.SysUserReadDTO;

import java.util.List;

public interface SysUserReadRepository {
    List<SysUserReadDTO> queryActiveUsers();
}
