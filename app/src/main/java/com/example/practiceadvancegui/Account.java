package com.example.practiceadvancegui;

import java.util.ArrayList;

public class Account {
    String name;
    String address;

    public Account(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public static ArrayList<Account> GetAccounts(){
        ArrayList<Account> tmp = new ArrayList<>();
        tmp.add(new Account("Tom", "Hanks"));
        tmp.add(new Account("Tom", "Hanks"));
        tmp.add(new Account("Tom", "Hanks"));
        tmp.add(new Account("Tom", "Hanks"));
        tmp.add(new Account("Tom", "Hanks"));
        tmp.add(new Account("Tom", "Hanks"));
        tmp.add(new Account("Tom", "Hanks"));
        tmp.add(new Account("Tom", "Hanks"));
        return  tmp;
    }
}
