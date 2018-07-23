package com.sguess.dao.impl;

import com.sguess.dao.IStatusDao;
import org.springframework.stereotype.Repository;

@Repository
public class StatusDaoImpl implements IStatusDao {
    @Override
    public boolean isPause() {
        return true;
    }
}
