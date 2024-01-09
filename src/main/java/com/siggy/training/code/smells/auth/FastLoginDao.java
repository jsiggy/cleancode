package com.siggy.training.code.smells.auth;

import java.sql.SQLException;

public class FastLoginDao implements LoginDao {
    @Override
    public boolean login(String username, String password) throws SQLException {
        // do some cool stuff here and then return true or false
        return false;
    }
}
