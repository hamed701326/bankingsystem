package org.bank.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditTransferRequest {
    private Long sourceCardId;
    private Long destinationCardId;
    private Long amount;
    private String description;


}
