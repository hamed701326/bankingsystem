package org.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bank.config.PersistentEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCard extends PersistentEntity<Long> {
    private String password;
    private int cvv2;
    @OneToMany()
    private List<Transaction> transactions;
    //bidirectional
    @ManyToOne()
    private Account account;

    private  boolean isActive;
    @Temporal(TemporalType.DATE)
    private Date expiredDate;


}
