package com.xfeng.unit.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.xfeng.unit.mapper.StoreMapper;
import com.xfeng.unit.model.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author xuefeng.wang
 * @date 2020-08-28
 */
@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreMapper storeMapper;

    public List<Store> sync(List<Store> stores) {
        List<String> existStoreCodes = stores.stream().map(Store::getCode).collect(Collectors.toList());
        LambdaQueryWrapper<Store> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Store::getCode, existStoreCodes);
        List<Store> oldStores = storeMapper.selectList(queryWrapper);
        Map<String, Store> exists = oldStores.stream().collect(Collectors.toMap(Store::getCode, Function.identity()));

        Date date = new Date();
        stores.forEach(item -> {
            item.setUpdatedTime(date);
            if (exists.containsKey(item.getCode())) {
                Store old = exists.get(item.getCode());
                item.setId(old.getId());
                item.setCreatedTime(old.getCreatedTime());
            } else {
                item.setCreatedTime(date);
            }
        });
        storeMapper.batchSaveOrUpdate(stores);

        return stores;
    }

    public List<Store> selectAll() {
        return storeMapper.selectList(null);
    }
}
