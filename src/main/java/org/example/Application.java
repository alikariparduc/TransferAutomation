package org.example;

import org.example.Transaction.TransactionCrate;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String username = UserInfo.transferUser;
        LogoutController.logoutKontrolEt(username);
        TransactionCrate.Crated();

    }
}
