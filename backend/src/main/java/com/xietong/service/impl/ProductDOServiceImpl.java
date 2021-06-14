package com.xietong.service.impl;

import com.xietong.mapper.ProductDOMapper;
import com.xietong.model.entity.ProductDO;
import com.xietong.service.intf.ProductDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductDOServiceImpl implements ProductDOService {
    @Autowired
    private ProductDOMapper productDOMapper;
    @Override
    public int insert(ProductDO productDO) {
        return productDOMapper.insert(productDO);
    }

    @Override
    public int delete(int id) {
        return productDOMapper.delete(id);
    }

    @Override
    public List<ProductDO> list() {
        return productDOMapper.list();
    }

    @Override
    public List<ProductDO> getById(int id) {
        return productDOMapper.getById(id);
    }

    @Override
    public int update(ProductDO productDO) {
        return productDOMapper.update(productDO);
    }

    @Override
    public int updateEffective(int id, int effective) {
        return productDOMapper.updateEffective(id,effective);
    }
}
