package co.kr.wokreshop.backpac.repository;

import co.kr.wokreshop.backpac.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By bohyun on 2021/11/15
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
