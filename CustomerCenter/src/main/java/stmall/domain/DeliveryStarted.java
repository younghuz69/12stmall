package stmall.domain;

import java.util.*;
import lombok.Data;
import stmall.infra.AbstractEvent;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long ProductID;
    private Integer qty;
    private String Address;
    private String CustomerID;
    private Long OrderID;
    private String ProductName;
    private String status;
}
