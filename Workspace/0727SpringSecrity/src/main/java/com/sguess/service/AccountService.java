package com.sguess.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public String getAccountName() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return userName;
    }
}
