package com.xietong.mapper;

import com.xietong.model.entity.ProductDO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDOMapper {
    //插入一条记录
    public int insert(ProductDO productDO);

    public int delete(int id);
    //查询全部
    public List<ProductDO> list();
    //查询某一行记录
    public List<ProductDO> getById(int id);
    //不管更改除主键与有效性之外哪一项属性，都使用这一方法，前提是前端返回完整的除有效性意外的数据
    public int update(ProductDO productDO);
    //更改数据有效性
    public int updateEffective(int id,int effective);
}
