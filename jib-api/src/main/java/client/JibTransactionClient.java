package client;

import dto.JibTransactionDTO;
import exception.JibErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "jib-transaction",configuration = JibErrorDecoder.class, url = "${jib.host}")
public interface JibTransactionClient {

    @PostMapping("/api/jib-transactions")
    JibTransactionDTO createTransaction(@RequestBody @Valid JibTransactionDTO jibTransactionDTO);
}
