package stmall.domain;

import java.util.*;
import lombok.Data;
import stmall.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long ProductID;
    private Long UserID;
    private Integer qty;
    private String Address;
    private String ProductName;
}
