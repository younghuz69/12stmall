package stmall.domain;

import java.util.*;
import lombok.Data;
import stmall.infra.AbstractEvent;

@Data
public class DeliveryCanceled extends AbstractEvent {

    private Long id;
    private Long ProductID;
    private Integer qty;
    private String Address;
    private String CustomerID;
    private Long OrderID;
    private String ProductName;
    private Long UserID;
    private String status;
}
