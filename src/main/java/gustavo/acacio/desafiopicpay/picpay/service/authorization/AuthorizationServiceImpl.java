package gustavo.acacio.desafiopicpay.picpay.service.authorization;

import gustavo.acacio.desafiopicpay.picpay.client.AuthorizationClient;
import gustavo.acacio.desafiopicpay.picpay.controller.dto.TransferDto;
import gustavo.acacio.desafiopicpay.picpay.entity.Transfer;
import gustavo.acacio.desafiopicpay.picpay.exception.PicPayException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService{

    private final AuthorizationClient authorizationClient;

    public AuthorizationServiceImpl(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transfer){
        var resp =  authorizationClient.isAuthorized();
        if(resp.getStatusCode().isError()){
            throw new PicPayException();
        }

        return resp.getBody().authorized();
    }
}
