package com.javarush.task.task36.MVC.model;

import com.javarush.task.task36.MVC.bean.User;
import com.javarush.task.task36.MVC.model.service.UserService;
import com.javarush.task.task36.MVC.model.service.UserServiceImpl;
import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();
    
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(userService.getUsersBetweenLevels (1,100));
        modelData.setUsers(getAllUsers ());
        modelData.setDisplayDeletedUserList(false);
    }
    @Override
    public void loadDeletedUsers(){
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }
    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }
    @Override
    public void deleteUserById(long id){
        userService.deleteUser (id);
        modelData.setUsers (getAllUsers ());
    }

    private List<User> getAllUsers(){
        List<User> users = userService.getUsersBetweenLevels(1, 100);
        return userService.filterOnlyActiveUsers (users);
    }

    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser (name, id, level);
        modelData.setUsers (getAllUsers ());
    }

}
