package sever.code.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sever.code.goods.model.Goods;
import sever.code.goods.sevice.GoodsService;
import sever.code.goods.util.IdsRequest;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping
    public ResponseEntity<Goods> createGoods(@RequestBody Goods goods) {
        Goods createdGoods = goodsService.createGoods(goods);
        return new ResponseEntity<>(createdGoods, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goods> getGoodsById(@PathVariable Long id) {
        Goods goods = goodsService.getGoodsById(id);
        if (goods != null) {
            return new ResponseEntity<>(goods, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Goods>> getAllGoods() {
        List<Goods> goodsList = goodsService.getAllGoods();
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goods> updateGoods(@PathVariable Long id, @RequestBody Goods goods) {
        Goods updatedGoods = goodsService.getGoodsById(id);
        if (updatedGoods != null) {
            goods.setId(id);
            updatedGoods = goodsService.updateGoods(goods);
            return new ResponseEntity<>(updatedGoods, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoodsById(@PathVariable Long id) {
        Goods goods = goodsService.getGoodsById(id);
        if (goods != null) {
            goodsService.deleteGoodsById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/list")
    public ResponseEntity<List<Goods>> getGoodsByIds(@RequestBody IdsRequest idsRequest) {
        //        {"ids": [1, 3]}
        List<Long> ids = idsRequest.getIds();
        List<Goods> goodsList = goodsService.getGoodsListByIds(ids);
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }
}
