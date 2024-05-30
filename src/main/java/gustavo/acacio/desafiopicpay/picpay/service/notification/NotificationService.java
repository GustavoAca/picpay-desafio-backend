package gustavo.acacio.desafiopicpay.picpay.service.notification;

import gustavo.acacio.desafiopicpay.picpay.entity.Transfer;

public interface NotificationService {
    void sendNotification(Transfer transferResult);
}
