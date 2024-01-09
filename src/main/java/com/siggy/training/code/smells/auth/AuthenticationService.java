package com.siggy.training.code.smells.auth;

import java.sql.SQLException;

public class AuthenticationService {
    private LoginDao loginDao = new FastLoginDao();

    public boolean authenticate(String username, String password) throws SQLException {
        try {
            return loginDao.login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
