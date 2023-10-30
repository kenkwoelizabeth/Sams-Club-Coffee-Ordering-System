package com.techbridge.sams.club.menuItemOrder;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemOrderRepository extends JpaRepository<MenuItemOrder, Long> {


}
