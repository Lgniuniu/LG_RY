package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ListDim;

/**
 * 维度列表Mapper接口
 * 
 * @author tls
 * @date 2023-03-23
 */
public interface ListDimMapper 
{
    /**
     * 查询维度列表
     * 
     * @param dim 维度列表主键
     * @return 维度列表
     */
    public ListDim selectListDimByDim(String dim);

    /**
     * 查询维度列表列表
     * 
     * @param listDim 维度列表
     * @return 维度列表集合
     */
    public List<ListDim> selectListDimList(ListDim listDim);

    /**
     * 新增维度列表
     * 
     * @param listDim 维度列表
     * @return 结果
     */
    public int insertListDim(ListDim listDim);

    /**
     * 修改维度列表
     * 
     * @param listDim 维度列表
     * @return 结果
     */
    public int updateListDim(ListDim listDim);

    /**
     * 删除维度列表
     * 
     * @param dim 维度列表主键
     * @return 结果
     */
    public int deleteListDimByDim(String dim);

    /**
     * 批量删除维度列表
     * 
     * @param dims 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteListDimByDims(String[] dims);
}
