package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {

        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    UserService userService;
    @Autowired
    NotificationService notificationService;

    public User processRegistration(String name, int age, String email){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setEmail(email);
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("Пользователь "+ user.getName() + "добавлен в реппозиторий");

        return user;

    }
}
