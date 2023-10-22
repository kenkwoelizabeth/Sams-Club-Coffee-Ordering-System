package com.techbridge.sams.club.order;

import com.techbridge.sams.club.menuItem.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{


}
