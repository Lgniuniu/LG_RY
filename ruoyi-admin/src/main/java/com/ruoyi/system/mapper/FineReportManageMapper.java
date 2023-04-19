package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FineReportManage;

/**
 * 报表路径管理Mapper接口
 * 
 * @author 林淦
 * @date 2023-04-18
 */
public interface FineReportManageMapper 
{
    /**
     * 查询报表路径管理
     * 
     * @param id 报表路径管理主键
     * @return 报表路径管理
     */
    public FineReportManage selectFineReportManageById(Long id);

    /**
     * 查询报表路径管理列表
     * 
     * @param fineReportManage 报表路径管理
     * @return 报表路径管理集合
     */
    public List<FineReportManage> selectFineReportManageList(FineReportManage fineReportManage);

    /**
     * 新增报表路径管理
     * 
     * @param fineReportManage 报表路径管理
     * @return 结果
     */
    public int insertFineReportManage(FineReportManage fineReportManage);

    /**
     * 修改报表路径管理
     * 
     * @param fineReportManage 报表路径管理
     * @return 结果
     */
    public int updateFineReportManage(FineReportManage fineReportManage);

    /**
     * 删除报表路径管理
     * 
     * @param id 报表路径管理主键
     * @return 结果
     */
    public int deleteFineReportManageById(Long id);

    /**
     * 批量删除报表路径管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFineReportManageByIds(Long[] ids);
}
