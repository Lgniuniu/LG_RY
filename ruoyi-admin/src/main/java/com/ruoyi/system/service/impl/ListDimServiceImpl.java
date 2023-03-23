package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ListDimMapper;
import com.ruoyi.system.domain.ListDim;
import com.ruoyi.system.service.IListDimService;

/**
 * 维度列表Service业务层处理
 * 
 * @author tls
 * @date 2023-03-23
 */
@Service
public class ListDimServiceImpl implements IListDimService 
{
    @Autowired
    private ListDimMapper listDimMapper;

    /**
     * 查询维度列表
     * 
     * @param dim 维度列表主键
     * @return 维度列表
     */
    @Override
    public ListDim selectListDimByDim(String dim)
    {
        return listDimMapper.selectListDimByDim(dim);
    }

    /**
     * 查询维度列表列表
     * 
     * @param listDim 维度列表
     * @return 维度列表
     */
    @Override
    public List<ListDim> selectListDimList(ListDim listDim)
    {
        return listDimMapper.selectListDimList(listDim);
    }

    /**
     * 新增维度列表
     * 
     * @param listDim 维度列表
     * @return 结果
     */
    @Override
    public int insertListDim(ListDim listDim)
    {
        return listDimMapper.insertListDim(listDim);
    }

    /**
     * 修改维度列表
     * 
     * @param listDim 维度列表
     * @return 结果
     */
    @Override
    public int updateListDim(ListDim listDim)
    {
        return listDimMapper.updateListDim(listDim);
    }

    /**
     * 批量删除维度列表
     * 
     * @param dims 需要删除的维度列表主键
     * @return 结果
     */
    @Override
    public int deleteListDimByDims(String[] dims)
    {
        return listDimMapper.deleteListDimByDims(dims);
    }

    /**
     * 删除维度列表信息
     * 
     * @param dim 维度列表主键
     * @return 结果
     */
    @Override
    public int deleteListDimByDim(String dim)
    {
        return listDimMapper.deleteListDimByDim(dim);
    }
}
