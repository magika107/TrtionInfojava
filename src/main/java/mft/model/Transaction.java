package mft.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@SuperBuilder

public class Transaction {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private String amount;
    private TransactionType transactionType;

}
