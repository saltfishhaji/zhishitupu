package com.cxtx.dao;

import com.cxtx.entity.Entities;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/*public interface EntityDao extends JpaRepository<Entities,Long>{
    public Entities findById(Long id);
    public List<Entities> findByName(String name);

}*/

public interface EntityDao extends JpaRepository<Entities,Long>{
    public Entities findById(Long id);
    public Entities findByName(String name);

}