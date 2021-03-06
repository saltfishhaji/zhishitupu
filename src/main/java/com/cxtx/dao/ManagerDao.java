package com.cxtx.dao;

import com.cxtx.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jinchuyang on 16/10/19.
 */
public interface ManagerDao extends JpaRepository<Manager,Long>{
    Manager findByTelAndPasswordAndAlive(String tel, String password, int alive);
}
