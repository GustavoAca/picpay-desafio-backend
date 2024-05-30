package gustavo.acacio.desafiopicpay.picpay.client;

import gustavo.acacio.desafiopicpay.picpay.client.dto.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "authorization-client",
        url = "${client.authorization-service.url}")
public interface AuthorizationClient {
    @GetMapping
    ResponseEntity<AuthorizationResponse> isAuthorized();
}
