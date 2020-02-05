package org.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCard {
    private Long cardId;
    private String password;
    private int cvv2;


}
