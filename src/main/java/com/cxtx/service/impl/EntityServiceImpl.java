package com.cxtx.service.impl;

import com.cxtx.dao.EntityDao;
import com.cxtx.entity.Entities;
import com.cxtx.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("EntityService")
public class EntityServiceImpl implements EntityService {

    @Autowired
    private EntityDao entityDao;
    @Override

    public Entities findById(Long id) {

        return entityDao.findOne(id);
    }

    @Override
    public Entities findByName(String name) {
        if (name == null){
            System.out.println("3");
            return  null;
            //System.out.println("0");
        }
        else
        {
            //List<Entities temp =entityDao.findByName(name);
            //if(temp.size()!=0)
                //return temp.get(0);
            System.out.println("1");

            System.out.println(entityDao.findByName(name));
            return entityDao.findByName(name);

        }
    }

    @Override
    public Entities addEntity(Entities entity) {
        if (entity == null){
            return  null;
        }
        else return entityDao.save(entity);

    }
}
