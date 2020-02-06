package org.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    private int accountId;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    @OneToMany()
    @JoinColumn(name = "account_id")
    private List<CreditCard> creditCards;
    @ManyToOne()
    private Branch branch;

}
