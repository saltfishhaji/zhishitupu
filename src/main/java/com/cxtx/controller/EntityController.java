package com.cxtx.controller;

import com.cxtx.entity.Entities;
import com.cxtx.model.ServiceResult;
import com.cxtx.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jinchuyang on 16/10/19.
 */
@Controller
public class EntityController extends ApiController{
    @Autowired
    private EntityService entityService;

    /**
     * 用户登录
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/chaxun", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult chaxun(@RequestBody String name) throws Exception{
        System.out.println("2");
        checkParameter(name!=null,"name cannot be empty!");
        Entities entityGet = entityService.findByName(name);
        return ServiceResult.success(entityGet);
    }
}
