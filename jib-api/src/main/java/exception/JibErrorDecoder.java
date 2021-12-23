package exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JibErrorDecoder implements ErrorDecoder {

    public Exception decode(String s, Response response) {

        switch (response.status()){
             case 404: {
                 System.out.println("*** jib nist");
                 return new JibNotFoundException("in jib nist");
             }
             default:
                return new RuntimeException();
        }
    }
}
