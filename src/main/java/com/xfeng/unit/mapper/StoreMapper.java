package com.xfeng.unit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfeng.unit.model.entity.Store;

import java.util.List;

/**
 * @author xuefeng.wang
 * @date 2020-08-28
 */
public interface StoreMapper extends BaseMapper<Store> {

    void batchSaveOrUpdate(List<Store> stores);
}
