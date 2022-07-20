package com.example.lastproject.scheduler;



import com.example.lastproject.domain.Credit;
import com.example.lastproject.domain.CreditStatus;
import com.example.lastproject.domain.Mail;
import com.example.lastproject.exception.UserNotFoundException;
import com.example.lastproject.service.CreditDbService;
import com.example.lastproject.service.SimpleEmailService;
import com.example.lastproject.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    private static final String SUBJECT = "Loan payment";
    private final SimpleEmailService simpleEmailService;
    private final CreditDbService creditDbService;
    private final UserDbService userDbService;
    private final String description = "Your time for loan payment ends in: ";
    private final LocalDate time = LocalDate.now();

    @Scheduled(cron = "24 0 0 * * *")
    public void sendInformationEmail() {
        List<Credit> creditList = creditDbService.getAllCredits();
        List<Credit> creditListToCheck = creditList.stream().
                filter(p-> p.getStatus().equals(CreditStatus.ACTIVE)).
                filter(p-> DAYS.between(p.getPaymentDate(), time) < 5).
                collect(Collectors.toList());

        for (Credit credit: creditListToCheck){
            Long userID = credit.getUserID();
            try {
                simpleEmailService.send(
                        new Mail(
                                userDbService.getUserById(userID).getEmail(),
                                SUBJECT,
                                description + DAYS.between(credit.getPaymentDate(), time),
                                "Information email. Last day free of charge for your loan Payment expires in " + DAYS.between(credit.getPaymentDate(), time)+" days"
                        )
                );
            }catch (UserNotFoundException e){

            }

        }



    }
}
