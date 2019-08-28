package com.javarush.task.task36.MVC;

import com.javarush.task.task36.MVC.controller.Controller;
import com.javarush.task.task36.MVC.model.MainModel;
import com.javarush.task.task36.MVC.model.Model;
import com.javarush.task.task36.MVC.view.EditUserView;
import com.javarush.task.task36.MVC.view.UsersView;

public class Solution {
    public static void main(String[] args) {

        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        EditUserView editUserView = new EditUserView();

        usersView.setController(controller);
        editUserView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);


        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged ("Kokoko", 125, 6);
        usersView.fireEventShowDeletedUsers();

    }
}