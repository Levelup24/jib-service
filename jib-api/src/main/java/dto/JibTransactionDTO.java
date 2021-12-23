package dto;

import enumeration.TransactionType;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


public class JibTransactionDTO implements Serializable {

    private Long id;

    @NotNull
    private Long jibId;

    @NotNull
    private TransactionType transactionType;

    @NotNull
    private BigDecimal transactionAmount;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Long getJibId() {
        return jibId;
    }

    public void setJibId(Long jibId) {
        this.jibId = jibId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JibTransactionDTO jibTransactionDTO = (JibTransactionDTO) o;
        if (jibTransactionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), jibTransactionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "JibTransactionDTO{" +
            "id=" + getId() +
            ", jibId=" + getJibId() +
            ", transactionType='" + getTransactionType() + "'" +
            ", transactionAmount=" + getTransactionAmount() +
            ", jibId=" + getJibId() +
            "}";
    }
}
