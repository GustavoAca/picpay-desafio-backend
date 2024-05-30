package gustavo.acacio.desafiopicpay.picpay.controller;

import gustavo.acacio.desafiopicpay.picpay.controller.dto.TransferDto;
import gustavo.acacio.desafiopicpay.picpay.entity.Transfer;
import gustavo.acacio.desafiopicpay.picpay.service.transfer.TransferComponent;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    private final TransferComponent transferComponent;

    @Autowired
    public TransferController(TransferComponent transferComponent) {
        this.transferComponent = transferComponent;
    }

    @PostMapping
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDto dto){
        return ResponseEntity.ok(transferComponent.transfer(dto));
    }
}
