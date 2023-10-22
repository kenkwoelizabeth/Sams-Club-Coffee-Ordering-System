package com.techbridge.sams.club.menuItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

        }
