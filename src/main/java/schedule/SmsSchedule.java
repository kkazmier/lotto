package schedule;

import com.app.lotto.client.LottoClient;
import com.app.lotto.controller.SMSController;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

@AllArgsConstructor
public class SmsSchedule {
    private final Logger logger = LoggerFactory.getLogger(SmsSchedule.class);

    private SMSController controller;
    private LottoClient client;

    @Scheduled(cron = "0 55 21 ? Tue,Thu,Sat")
    //@Scheduled(fixedDelay = 1000)
    public void sendLottoResults(){

    }
}
