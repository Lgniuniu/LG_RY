package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.DataSource;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报表路径管理对象 fine_report_manage
 * 
 * @author 林淦
 * @date 2023-04-18
 */

@Data
public class FineReportManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 报表名称 */
    @Excel(name = "报表名称")
    private String fineReportName;

    /** 报表路径 */
    @Excel(name = "报表路径")
    private String fineReportUrl;

    /** 预览模式 */
    @Excel(name = "预览模式")
    private String fineReportOp;

    /** 预览模式 */
    @Excel(name = "预览模式")
    private String fineReportType;
}
