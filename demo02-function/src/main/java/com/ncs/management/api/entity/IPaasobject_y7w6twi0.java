package com.ncs.management.api.entity;

import com.clickpaas.ipaas.annotations.IPaasField;
import com.clickpaas.ipaas.annotations.IPaasObject;
import com.clickpaas.ipaas.model.BaseDefinition;

/**
 *  商品仓库
 */
@IPaasObject(objName = "t_object_y7w6twi0", appCode = "5876fddf-ee7c-4289-985a-a1bd1a0c5627", tenantId = "HW47")
public class IPaasobject_y7w6twi0 extends BaseDefinition {
    // 占用空间
    @IPaasField
    private String t_sumnumber;
    // 库存数量
    @IPaasField
    private Integer t_number;
    // 关联【京东】商品
    @IPaasField
    private Object t_item_name;
    private Object t_item_nameObj;
    // 关联【京东】仓库
    @IPaasField
    private Object t_treewarehouse;
    private Object t_treewarehouseObj;
    // 单位体积（m^3）
    @IPaasField
    private Double t_field_mtcfzpugav;
    // ID
    @IPaasField
    private String id;
    // 企业
    @IPaasField
    private Object enterpriseId;
    private Object enterpriseObj;
    // 负责人
    @IPaasField
    private Object responsibleUserId;
    private Object responsibleUserObj;
    // 负责人部门
    @IPaasField
    private Object responsibleDepartmentId;
    private Object responsibleDepartmentObj;
    // 删除状态
    @IPaasField
    private String isDeleted;
    // 创建人
    @IPaasField
    private Object createUserId;
    private Object createUserObj;
    // 应用
    @IPaasField
    private Object companyId;
    private Object companyObj;
    // 创建人部门
    @IPaasField
    private Object createDepartmentId;
    private Object createDepartmentObj;
    // 创建时间
    @IPaasField
    private String createdTime;
    // 修改人
    @IPaasField
    private Object modifyUserId;
    private Object modifyUserObj;
    // 修改人部门
    @IPaasField
    private Object modifyDepartmentId;
    private Object modifyDepartmentObj;
    // 租户
    @IPaasField
    private Object tenantId;
    private Object tenantObj;
    // 修改时间
    @IPaasField
    private String modifiedTime;

    public String getT_sumnumber() {
        return this.t_sumnumber;
    }

    public void setT_sumnumber(String t_sumnumber) {
        this.t_sumnumber = t_sumnumber;
    }

    public Integer getT_number() {
        return this.t_number;
    }

    public void setT_number(Integer t_number) {
        this.t_number = t_number;
    }

    public Object getT_item_name() {
        return this.t_item_name;
    }

    public void setT_item_name(Object t_item_name) {
        this.t_item_name = t_item_name;
    }

    public Object getT_item_nameObj() {
        return this.t_item_nameObj;
    }

    public void setT_item_nameObj(Object t_item_nameObj) {
        this.t_item_nameObj = t_item_nameObj;
    }

    public Object getT_treewarehouse() {
        return this.t_treewarehouse;
    }

    public void setT_treewarehouse(Object t_treewarehouse) {
        this.t_treewarehouse = t_treewarehouse;
    }

    public Object getT_treewarehouseObj() {
        return this.t_treewarehouseObj;
    }

    public void setT_treewarehouseObj(Object t_treewarehouseObj) {
        this.t_treewarehouseObj = t_treewarehouseObj;
    }

    public Double getT_field_mtcfzpugav() {
        return this.t_field_mtcfzpugav;
    }

    public void setT_field_mtcfzpugav(Double t_field_mtcfzpugav) {
        this.t_field_mtcfzpugav = t_field_mtcfzpugav;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getEnterpriseId() {
        return this.enterpriseId;
    }

    public void setEnterpriseId(Object enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Object getEnterpriseObj() {
        return this.enterpriseObj;
    }

    public void setEnterpriseObj(Object enterpriseObj) {
        this.enterpriseObj = enterpriseObj;
    }

    public Object getResponsibleUserId() {
        return this.responsibleUserId;
    }

    public void setResponsibleUserId(Object responsibleUserId) {
        this.responsibleUserId = responsibleUserId;
    }

    public Object getResponsibleUserObj() {
        return this.responsibleUserObj;
    }

    public void setResponsibleUserObj(Object responsibleUserObj) {
        this.responsibleUserObj = responsibleUserObj;
    }

    public Object getResponsibleDepartmentId() {
        return this.responsibleDepartmentId;
    }

    public void setResponsibleDepartmentId(Object responsibleDepartmentId) {
        this.responsibleDepartmentId = responsibleDepartmentId;
    }

    public Object getResponsibleDepartmentObj() {
        return this.responsibleDepartmentObj;
    }

    public void setResponsibleDepartmentObj(Object responsibleDepartmentObj) {
        this.responsibleDepartmentObj = responsibleDepartmentObj;
    }

    public String getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Object getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(Object createUserId) {
        this.createUserId = createUserId;
    }

    public Object getCreateUserObj() {
        return this.createUserObj;
    }

    public void setCreateUserObj(Object createUserObj) {
        this.createUserObj = createUserObj;
    }

    public Object getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Object companyId) {
        this.companyId = companyId;
    }

    public Object getCompanyObj() {
        return this.companyObj;
    }

    public void setCompanyObj(Object companyObj) {
        this.companyObj = companyObj;
    }

    public Object getCreateDepartmentId() {
        return this.createDepartmentId;
    }

    public void setCreateDepartmentId(Object createDepartmentId) {
        this.createDepartmentId = createDepartmentId;
    }

    public Object getCreateDepartmentObj() {
        return this.createDepartmentObj;
    }

    public void setCreateDepartmentObj(Object createDepartmentObj) {
        this.createDepartmentObj = createDepartmentObj;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Object getModifyUserId() {
        return this.modifyUserId;
    }

    public void setModifyUserId(Object modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Object getModifyUserObj() {
        return this.modifyUserObj;
    }

    public void setModifyUserObj(Object modifyUserObj) {
        this.modifyUserObj = modifyUserObj;
    }

    public Object getModifyDepartmentId() {
        return this.modifyDepartmentId;
    }

    public void setModifyDepartmentId(Object modifyDepartmentId) {
        this.modifyDepartmentId = modifyDepartmentId;
    }

    public Object getModifyDepartmentObj() {
        return this.modifyDepartmentObj;
    }

    public void setModifyDepartmentObj(Object modifyDepartmentObj) {
        this.modifyDepartmentObj = modifyDepartmentObj;
    }

    public Object getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(Object tenantId) {
        this.tenantId = tenantId;
    }

    public Object getTenantObj() {
        return this.tenantObj;
    }

    public void setTenantObj(Object tenantObj) {
        this.tenantObj = tenantObj;
    }

    public String getModifiedTime() {
        return this.modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
