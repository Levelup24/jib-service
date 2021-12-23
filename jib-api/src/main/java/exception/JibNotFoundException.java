package exception;

import org.springframework.http.HttpStatus;

public class JibNotFoundException extends RuntimeException{

    public JibNotFoundException(String in_jib_nist) {
        super(in_jib_nist);
    }

}
