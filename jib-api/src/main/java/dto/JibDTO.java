package dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.levelup.jib.domain.Jib} entity.
 */
public class JibDTO implements Serializable {

    private Long id;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private Long customerId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JibDTO jibDTO = (JibDTO) o;
        if (jibDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), jibDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "JibDTO{" +
            "id=" + getId() +
            ", balance=" + getBalance() +
            ", customerId=" + getCustomerId() +
            "}";
    }
}
