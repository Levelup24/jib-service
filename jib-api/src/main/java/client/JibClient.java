package client;


import dto.JibDTO;
import exception.JibErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "jib",configuration = JibErrorDecoder.class, url = "${jib.host}")
public interface JibClient {

    @PostMapping(value = "/api/jibs")
    JibDTO createJib(@RequestBody @Valid JibDTO jibDTO);

    @GetMapping("/api/jibs/{id}")
    JibDTO getJib(@PathVariable Long id);
}
