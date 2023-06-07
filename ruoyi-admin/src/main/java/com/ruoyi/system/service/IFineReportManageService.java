package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FineReportManage;

/**
 * 报表路径Service接口
 *
 * @author 林淦
 * @date 2023-05-15
 */
public interface IFineReportManageService
{
    /**
     * 查询报表路径
     *
     * @param id 报表路径主键
     * @return 报表路径
     */
    public FineReportManage selectFineReportManageById(Long id);

    /**
     * 查询报表路径列表
     *
     * @param fineReportManage 报表路径
     * @return 报表路径集合
     */
    public List<FineReportManage> selectFineReportManageList(FineReportManage fineReportManage);

    /**
     * 新增报表路径
     *
     * @param fineReportManage 报表路径
     * @return 结果
     */
    public int insertFineReportManage(FineReportManage fineReportManage);

    /**
     * 修改报表路径
     *
     * @param fineReportManage 报表路径
     * @return 结果
     */
    public int updateFineReportManage(FineReportManage fineReportManage);

    /**
     * 批量删除报表路径
     *
     * @param ids 需要删除的报表路径主键集合
     * @return 结果
     */
    public int deleteFineReportManageByIds(Long[] ids);

    /**
     * 删除报表路径信息
     *
     * @param id 报表路径主键
     * @return 结果
     */
    public int deleteFineReportManageById(Long id);
}
