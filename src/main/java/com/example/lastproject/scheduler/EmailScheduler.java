package com.example.lastproject.scheduler;


import com.example.lastproject.config.AdminConfig;
import com.example.lastproject.domain.Mail;
import com.example.lastproject.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    private static final String SUBJECT = "Tasks: Once a day email";
    private final SimpleEmailService simpleEmailService;

    private final AdminConfig adminConfig;
    private String task = "tasks";

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        if(size == 1){
            task = "task";
        }

        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        "Currently in database you got: " + size + task,
                        null
                )
        );
    }
}
