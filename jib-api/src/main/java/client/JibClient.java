package client;


import dto.JibDTO;
import exception.JibErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "jib",configuration = JibErrorDecoder.class)
public interface JibClient {

    @PostMapping("/api/jibs")
    JibDTO createJib(@RequestBody @Valid JibDTO jibDTO);
}
