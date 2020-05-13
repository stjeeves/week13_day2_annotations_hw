package com.example.codeclan.adminservice.components;

import com.example.codeclan.adminservice.models.File;
import com.example.codeclan.adminservice.models.Folder;
import com.example.codeclan.adminservice.models.User;
import com.example.codeclan.adminservice.repositories.FileRepository;
import com.example.codeclan.adminservice.repositories.FolderRepository;
import com.example.codeclan.adminservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private FileRepository fileRepository;

    public void run(ApplicationArguments args){
        userRepository.deleteAll();
        folderRepository.deleteAll();
        fileRepository.deleteAll();

        User james = new User("James");
        userRepository.save(james);

        User phoebe = new User("Phoebe");
        userRepository.save(phoebe);

        User max = new User("Max");
        userRepository.save(max);

        Folder hr = new Folder("HR", james);
        folderRepository.save(hr);

        Folder finance = new Folder("Finance", phoebe);
        folderRepository.save(finance);

        Folder admin = new Folder("Admin", max);
        folderRepository.save(admin);

        Folder recruitment = new Folder("Recruitment", max);
        folderRepository.save(recruitment);

        File dispute1 = new File("dispute1", ".txt", 12, hr);
        fileRepository.save(dispute1);

        File dispute2 = new File("dispute2", ".txt", 12, hr);
        fileRepository.save(dispute2);

        File finance1 = new File("finance1", ".jpg", 20, finance);
        fileRepository.save(finance1);

        File finance2 = new File("finance2", ".txt", 21, finance);
        fileRepository.save(finance2);

        File notes1 = new File("notes1", ".word", 12, admin);
        fileRepository.save(notes1);

        File notes2 = new File("notes2", ".word", 15, admin);
        fileRepository.save(notes2);

        File interview1 = new File("interview1", ".vid", 100, recruitment);
        fileRepository.save(interview1);

        File interview2 = new File("interview2", ".vid", 90, recruitment);
        fileRepository.save(interview2);




    }
}
