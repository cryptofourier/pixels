package sever.code.goods.sevice;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sever.code.goods.model.Goods;
import sever.code.goods.repo.GoodsRepo;

import java.util.List;

@Service
@Transactional
public class GoodsService {

    @Autowired
    private GoodsRepo goodsRepo;

    public List<Goods> getGoodsListByIds(List<Long> ids) {
        return goodsRepo.findAllById(ids);
    }

    public Goods createGoods(Goods goods) {
        return goodsRepo.save(goods);
    }

    public Goods getGoodsById(long id) {
        return goodsRepo.findById(id).orElse(null);
    }

    public List<Goods> getAllGoods() {
        return goodsRepo.findAll();
    }

    public Goods updateGoods(Goods goods) {
        return goodsRepo.save(goods);
    }

    public void deleteGoodsById(long id) {
        goodsRepo.deleteById(id);
    }
}