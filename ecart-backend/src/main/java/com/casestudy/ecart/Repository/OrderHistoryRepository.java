package com.casestudy.ecart.Repository;

import com.casestudy.ecart.models.OrderHistory;
import com.casestudy.ecart.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
    List<OrderHistory> findAllByUsers(Users users);
}
