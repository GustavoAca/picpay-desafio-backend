package gustavo.acacio.desafiopicpay.picpay.service.transfer;

import gustavo.acacio.desafiopicpay.picpay.controller.dto.TransferDto;
import gustavo.acacio.desafiopicpay.picpay.core.BaseService;
import gustavo.acacio.desafiopicpay.picpay.entity.Transfer;
import gustavo.acacio.desafiopicpay.picpay.entity.Wallet;

import java.util.UUID;

public interface TransferService extends BaseService<Transfer, UUID> {
}
