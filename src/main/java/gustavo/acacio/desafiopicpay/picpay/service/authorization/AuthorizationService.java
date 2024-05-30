package gustavo.acacio.desafiopicpay.picpay.service.authorization;

import gustavo.acacio.desafiopicpay.picpay.controller.dto.TransferDto;
import gustavo.acacio.desafiopicpay.picpay.entity.Transfer;

public interface AuthorizationService {

    public boolean isAuthorized(TransferDto transfer);
}
