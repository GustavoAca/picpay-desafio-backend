package gustavo.acacio.desafiopicpay.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends PicPayException{
    private Long id;

    public WalletNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Wallet not found");
        pb.setDetail(String.format("There is no wallet with id %d.", id));
        return super.toProblemDetail();
    }
}
