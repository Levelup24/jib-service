package com.levelup.jib.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * A Jib.
 */
@Entity
@Table(name = "jib")
public class Jib implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "balance", precision = 21, scale = 2, nullable = false)
    private BigDecimal balance;

    @NotNull
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @OneToMany(mappedBy = "jib")
    private Set<JibTransaction> jibTransactions = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Jib balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Jib customerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Set<JibTransaction> getJibTransactions() {
        return jibTransactions;
    }

    public Jib jibTransactions(Set<JibTransaction> jibTransactions) {
        this.jibTransactions = jibTransactions;
        return this;
    }

    public Jib addJibTransaction(JibTransaction jibTransaction) {
        this.jibTransactions.add(jibTransaction);
        jibTransaction.setJib(this);
        return this;
    }

    public Jib removeJibTransaction(JibTransaction jibTransaction) {
        this.jibTransactions.remove(jibTransaction);
        jibTransaction.setJib(null);
        return this;
    }

    public void setJibTransactions(Set<JibTransaction> jibTransactions) {
        this.jibTransactions = jibTransactions;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Jib)) {
            return false;
        }
        return id != null && id.equals(((Jib) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Jib{" +
            "id=" + getId() +
            ", balance=" + getBalance() +
            ", customerId=" + getCustomerId() +
            "}";
    }
}
