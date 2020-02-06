package org.bank.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bank.config.PersistentEntity;

import javax.persistence.*;
import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaction extends PersistentEntity<Integer> {

    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Temporal(TemporalType.TIME)
    private Date time;
    private  Long CreditAmount;
    private boolean isSuccessfullyDone;


}
