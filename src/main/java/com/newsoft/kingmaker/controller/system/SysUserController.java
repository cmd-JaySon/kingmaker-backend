package com.newsoft.kingmaker.controller.system;

import com.newsoft.kingmaker.common.resp.Result;
import com.newsoft.kingmaker.dto.system.SysUserReadDTO;
import com.newsoft.kingmaker.dto.system.SysUserWriteDTO;
import com.newsoft.kingmaker.service.system.SysUserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sys/user")
public class SysUserController {
    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @PostMapping
    public Result<Long> createUser(@Valid @RequestBody SysUserWriteDTO dto) {
        Long id = sysUserService.create(dto);
        return Result.success(id);
    }

    @GetMapping
    public Result<List<SysUserReadDTO>> getActiveUsers() {
        List<SysUserReadDTO> activeUsers = sysUserService.getActiveUsers();
        return Result.success(activeUsers);
    }
}
