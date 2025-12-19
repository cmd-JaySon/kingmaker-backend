package com.newsoft.kingmaker.repository.system;

import com.newsoft.kingmaker.dto.system.SysUserReadDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SysUserReadRepositoryImpl implements SysUserReadRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<SysUserReadDTO> queryActiveUsers() {
        return em.createQuery(
                "SELECT new com.newsoft.kingmaker.dto.system.SysUserReadDTO(u.id, u.username, u.realName, u.enabled) " +
                        "FROM SysUser u WHERE u.enabled = true",
                SysUserReadDTO.class
        ).getResultList();
    }
}
