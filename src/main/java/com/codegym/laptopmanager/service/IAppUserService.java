package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.AppUser;

public interface IAppUserService {
    AppUser getUserByUsername(String username);
}
