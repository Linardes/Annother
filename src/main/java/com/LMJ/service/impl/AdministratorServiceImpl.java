package com.LMJ.service.impl;

import com.LMJ.dao.AdministratorMapper;
import com.LMJ.pojo.Administrator;
import com.LMJ.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//@Service只能写在实现类上，不能写在接口上
@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper;
    @Override
    public Administrator getAdministrator(String name) {
        Administrator administrator=administratorMapper.getAdministratorByName(name);
        return administrator;
    }
}
