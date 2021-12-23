package exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JibErrorDecoder implements ErrorDecoder {

    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 401:
                return new RuntimeException();
            case 404:
                return new RuntimeException();
            case 403:
                return new RuntimeException();
            default:
                return new RuntimeException();
        }
    }
}
