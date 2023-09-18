package sever.code.goods.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sever.code.goods.model.Goods;

@Repository
public interface GoodsRepo extends JpaRepository<Goods, Long> {
}
