package gustavo.acacio.desafiopicpay.picpay.service.notification;

import gustavo.acacio.desafiopicpay.picpay.client.NotificationClient;
import gustavo.acacio.desafiopicpay.picpay.entity.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationClient notificationClient;

    public NotificationServiceImpl(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transfer transfer){
        try{
            logger.info("Sending notification");
            var resp = notificationClient.sendNotification(transfer);
            if(resp.getStatusCode().isError()){
                logger.error("Error while sending notification, status code is not OK");
            }
        } catch (Exception e){
            logger.error("Error while sending notification");
        }
    }
}
