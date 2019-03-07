package com.example.Service;

public interface UserService {
    public void  createUser(String name,int age);
    void deleteByUsername(String name);
    Integer getAllUsersCount();
    void  deleteAllUser();
}
