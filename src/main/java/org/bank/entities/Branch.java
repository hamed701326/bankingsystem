package org.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Branch {
    private int branchId;
    private String branchName;
    private String bankName;
    private String MangerName;

}
