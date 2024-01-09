package com.siggy.training.code.smells.auth;

import java.sql.SQLException;

public interface LoginDao {
    boolean login(String username, String password) throws SQLException;
}
