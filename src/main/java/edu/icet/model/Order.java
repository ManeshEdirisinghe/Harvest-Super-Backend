package edu.icet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Order {
    private String orderId;
    private LocalDate date;
    private String custID;

    public Object getCustId() {
        return null;
    }

    public void setCustId(String custID) {
        // TODO document why this method is empty
    }
}