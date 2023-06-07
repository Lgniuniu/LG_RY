package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FineReportManageMapper;
import com.ruoyi.system.domain.FineReportManage;
import com.ruoyi.system.service.IFineReportManageService;

/**
 * 报表路径Service业务层处理
 *
 * @author 林淦
 * @date 2023-05-15
 */
@Service
public class FineReportManageServiceImpl implements IFineReportManageService
{
    @Autowired
    private FineReportManageMapper fineReportManageMapper;

    /**
     * 查询报表路径
     *
     * @param id 报表路径主键
     * @return 报表路径
     */
    @Override
    public FineReportManage selectFineReportManageById(Long id)
    {
        return fineReportManageMapper.selectFineReportManageById(id);
    }

    /**
     * 查询报表路径列表
     *
     * @param fineReportManage 报表路径
     * @return 报表路径
     */
    @Override
    public List<FineReportManage> selectFineReportManageList(FineReportManage fineReportManage)
    {
        return fineReportManageMapper.selectFineReportManageList(fineReportManage);
    }

    /**
     * 新增报表路径
     *
     * @param fineReportManage 报表路径
     * @return 结果
     */
    @Override
    public int insertFineReportManage(FineReportManage fineReportManage)
    {
        return fineReportManageMapper.insertFineReportManage(fineReportManage);
    }

    /**
     * 修改报表路径
     *
     * @param fineReportManage 报表路径
     * @return 结果
     */
    @Override
    public int updateFineReportManage(FineReportManage fineReportManage)
    {
        return fineReportManageMapper.updateFineReportManage(fineReportManage);
    }

    /**
     * 批量删除报表路径
     *
     * @param ids 需要删除的报表路径主键
     * @return 结果
     */
    @Override
    public int deleteFineReportManageByIds(Long[] ids)
    {
        return fineReportManageMapper.deleteFineReportManageByIds(ids);
    }

    /**
     * 删除报表路径信息
     *
     * @param id 报表路径主键
     * @return 结果
     */
    @Override
    public int deleteFineReportManageById(Long id)
    {
        return fineReportManageMapper.deleteFineReportManageById(id);
    }
}
