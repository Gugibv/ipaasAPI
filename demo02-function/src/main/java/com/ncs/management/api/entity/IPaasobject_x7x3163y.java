package com.ncs.management.api.entity;

import com.clickpaas.ipaas.annotations.IPaasField;
import com.clickpaas.ipaas.annotations.IPaasObject;
import com.clickpaas.ipaas.annotations.IPaasOneToOne;
import com.clickpaas.ipaas.model.BaseDefinition;

/**
 * 商品-进货单中间表
 */
@IPaasObject(objName = "t_object_x7x3163y", appCode = "5876fddf-ee7c-4289-985a-a1bd1a0c5627", tenantId = "HW47")
public class IPaasobject_x7x3163y extends BaseDefinition {
    // 商品总体积（m^3）
    @IPaasField
    private String t_field_dgimvat9;
    // 商品总价
    @IPaasField
    private String t_field_2rfxbt28;
    // 进货价
    @IPaasField
    private Object t_field_t0jzvgdpxv;
    // 进货数量
    @IPaasField
    private Integer t_field_uxggln4z;
    // 折扣
    @IPaasField
    private Double t_field_nro7nf8s;
    // 单位体积（m^3）
    @IPaasField
    private Double t_field_jx3jrvapjv;
    // 关联进货单
    @IPaasField
    private Object t_field_smdqjgddnc;
    @IPaasOneToOne(relationField = "t_field_smdqjgddnc", ignore = false)
    private IPaasobject_u5n7rlm7 t_field_smdqjgddncObj;
    // 关联【京东】商品
    @IPaasField
    private Object t_field_jiflrh7rhc;
    private Object t_field_jiflrh7rhcObj;
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

    public String getT_field_dgimvat9() {
        return this.t_field_dgimvat9;
    }

    public void setT_field_dgimvat9(String t_field_dgimvat9) {
        this.t_field_dgimvat9 = t_field_dgimvat9;
    }

    public String getT_field_2rfxbt28() {
        return this.t_field_2rfxbt28;
    }

    public void setT_field_2rfxbt28(String t_field_2rfxbt28) {
        this.t_field_2rfxbt28 = t_field_2rfxbt28;
    }

    public Object getT_field_t0jzvgdpxv() {
        return this.t_field_t0jzvgdpxv;
    }

    public void setT_field_t0jzvgdpxv(Object t_field_t0jzvgdpxv) {
        this.t_field_t0jzvgdpxv = t_field_t0jzvgdpxv;
    }

    public Integer getT_field_uxggln4z() {
        return this.t_field_uxggln4z;
    }

    public void setT_field_uxggln4z(Integer t_field_uxggln4z) {
        this.t_field_uxggln4z = t_field_uxggln4z;
    }

    public Double getT_field_nro7nf8s() {
        return this.t_field_nro7nf8s;
    }

    public void setT_field_nro7nf8s(Double t_field_nro7nf8s) {
        this.t_field_nro7nf8s = t_field_nro7nf8s;
    }

    public Double getT_field_jx3jrvapjv() {
        return this.t_field_jx3jrvapjv;
    }

    public void setT_field_jx3jrvapjv(Double t_field_jx3jrvapjv) {
        this.t_field_jx3jrvapjv = t_field_jx3jrvapjv;
    }

    public Object getT_field_smdqjgddnc() {
        return this.t_field_smdqjgddnc;
    }

    public void setT_field_smdqjgddnc(Object t_field_smdqjgddnc) {
        this.t_field_smdqjgddnc = t_field_smdqjgddnc;
    }

    public IPaasobject_u5n7rlm7 getT_field_smdqjgddncObj() {
        return this.t_field_smdqjgddncObj;
    }

    public void setT_field_smdqjgddncObj(IPaasobject_u5n7rlm7 t_field_smdqjgddncObj) {
        this.t_field_smdqjgddncObj = t_field_smdqjgddncObj;
    }

    public Object getT_field_jiflrh7rhc() {
        return this.t_field_jiflrh7rhc;
    }

    public void setT_field_jiflrh7rhc(Object t_field_jiflrh7rhc) {
        this.t_field_jiflrh7rhc = t_field_jiflrh7rhc;
    }

    public Object getT_field_jiflrh7rhcObj() {
        return this.t_field_jiflrh7rhcObj;
    }

    public void setT_field_jiflrh7rhcObj(Object t_field_jiflrh7rhcObj) {
        this.t_field_jiflrh7rhcObj = t_field_jiflrh7rhcObj;
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
