package org.bank.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class CardPasswordInfo {
    private Date expirationDate;
    private int cvv2;
    private String secondPassword;

}
