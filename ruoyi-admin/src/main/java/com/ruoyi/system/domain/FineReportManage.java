package com.ruoyi.system.domain;

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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFineReportName(String fineReportName) 
    {
        this.fineReportName = fineReportName;
    }

    public String getFineReportName() 
    {
        return fineReportName;
    }
    public void setFineReportUrl(String fineReportUrl) 
    {
        this.fineReportUrl = fineReportUrl;
    }

    public String getFineReportUrl() 
    {
        return fineReportUrl;
    }
    public void setFineReportOp(String fineReportOp) 
    {
        this.fineReportOp = fineReportOp;
    }

    public String getFineReportOp() 
    {
        return fineReportOp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fineReportName", getFineReportName())
            .append("fineReportUrl", getFineReportUrl())
            .append("fineReportOp", getFineReportOp())
            .toString();
    }
}
