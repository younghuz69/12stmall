package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmall.StockApplication;
import stmall.domain.StockDecreased;
import stmall.domain.StockIncreased;

@Entity
@Table(name = "Stock_table")
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private Integer stock;

    @PostUpdate
    public void onPostUpdate() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();

        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();
    }

    public static StockRepository repository() {
        StockRepository stockRepository = StockApplication.applicationContext.getBean(
            StockRepository.class
        );
        return stockRepository;
    }

    public static void stockDecrease(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        StockDecreased stockDecreased = new StockDecreased(stock);
        stockDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);

            StockDecreased stockDecreased = new StockDecreased(stock);
            stockDecreased.publishAfterCommit();

         });
        */

    }

    public static void stockIncrease(DeliveryCanceled deliveryCanceled) {
        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        StockIncreased stockIncreased = new StockIncreased(stock);
        stockIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCanceled.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);

            StockIncreased stockIncreased = new StockIncreased(stock);
            stockIncreased.publishAfterCommit();

         });
        */

    }
}
