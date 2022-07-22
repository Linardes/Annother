package com.LMJ.service;

import com.LMJ.pojo.Administrator;
import org.springframework.stereotype.Service;

public interface AdministratorService {
    public Administrator getAdministrator(String name);
}
