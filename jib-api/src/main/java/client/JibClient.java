package client;


import dto.JibDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "producer")
public interface JibClient {

    @PostMapping("/api/v1/wallets")
    JibDTO createJib(JibDTO jibDTO);
}
