package net.DianC.dp.shiro.entity;

import scala.Serializable;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName Test_Singleton.java
 * @Description TODO
 * @Author 先
 * @Time 2017年3月25日 下午3:12:43
 */

public class SysServiceEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 */
	private Integer apiId;
	/**
	 * 标识
	 */
	private Integer pWebId;
	/**
	 * 服务名称
	 */
	private String apiName;
	/**
	 * 服务提供商
	 */
	private String apiProvider;
	/**
	 * api主页
	 */
	private String apiPortalOrHomePage;

	/**
	 *  服务类别
	 */
	private String type;
	/**
	 * 建筑风格
	 */
	private String architecturalStyle ;
	/**
	 * 设备指定
	 */
	private String deviceSpecific;
	/**
	 * 范围
	 */
	private String scope;

	/**
	 * 输入参数
	 */
	private String inParameter;
	/**
	 * 输出参数
	 */
	private String outParameter;

	/**
	 * 服务描述
	 */
	private String apiDescription;
	/**
	 * 创建日期
	 */
	private Timestamp addDate;

	private Timestamp updateDate;
	/**
     * api描述设计是非专有的吗
	 */
	private String apiDesign;
	/**
	 * 是否支持SSL
	 */
	private String sslSupport;
	/**
	 * 是否是超媒体API
	 */
	private String hypermediaApi;
	/**
	 * 权限禁止
	 */
	private String restrictedAccess;
	/**
	 * 是否是官方
	 */
	private String unofficialApi;
    /**
     * 身份验证list 集合
     */
    private List<String> authenticationModel ;
    /**
     * 服务类型 list 集合
     */
    private List<String> categoryName;
    /**
     * 类型级别（1代表主要类别，2代表次要类别）
     */
    private Integer categoryType;
    /**
     * api端口
     */
    private String apiEndPoint;
    /**
     * api版本
     */
    private String apiVersion;
    /**
     * 文档主页地址
     */
    private String docsHomePageUrl;
    /**
     * 控制台网址
     */
    private String interactiveConsoleUrl;
    /**
     * terms_of_service_url 服务条款
     */
    private String termsOfServiceUrl;
    /**
     *  描述文件类型
     */
    private String descriptionFileType ;
    /**
     * 专利执照
     */
    private String typeOfLicenseIfNonProprietary;
    /**
     * 请求格式
     */
    private List<String> supportedRequestFormats ;
    /**
     * 响应格式
     */
    private List<String> supportedResponseFormats ;

	public Integer getApiId() {
		return apiId;
	}

	public void setApiId(Integer apiId) {
		this.apiId = apiId;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getApiProvider() {
		return apiProvider;
	}

	public void setApiProvider(String apiProvider) {
		this.apiProvider = apiProvider;
	}

	public String getApiPortalOrHomePage() {
		return apiPortalOrHomePage;
	}

	public void setApiPortalOrHomePage(String apiPortalOrHomePage) {
		this.apiPortalOrHomePage = apiPortalOrHomePage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getArchitecturalStyle() {
		return architecturalStyle;
	}

	public void setArchitecturalStyle(String architecturalStyle) {
		this.architecturalStyle = architecturalStyle;
	}

	public String getDeviceSpecific() {
		return deviceSpecific;
	}

	public void setDeviceSpecific(String deviceSpecific) {
		this.deviceSpecific = deviceSpecific;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getInParameter() {
		return inParameter;
	}

	public void setInParameter(String inParameter) {
		this.inParameter = inParameter;
	}

	public String getOutParameter() {
		return outParameter;
	}

	public void setOutParameter(String outParameter) {
		this.outParameter = outParameter;
	}

	public String getApiDescription() {
		return apiDescription;
	}

	public void setApiDescription(String apiDescription) {
		this.apiDescription = apiDescription;
	}

	public Timestamp getAddDate() {
		return addDate;
	}

	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}

	public String getApiDesign() {
		return apiDesign;
	}

	public void setApiDesign(String apiDesign) {
		this.apiDesign = apiDesign;
	}

	public String getSslSupport() {
		return sslSupport;
	}

	public void setSslSupport(String sslSupport) {
		this.sslSupport = sslSupport;
	}

	public String getHypermediaApi() {
		return hypermediaApi;
	}

	public void setHypermediaApi(String hypermediaApi) {
		this.hypermediaApi = hypermediaApi;
	}

	public String getRestrictedAccess() {
		return restrictedAccess;
	}

	public void setRestrictedAccess(String restrictedAccess) {
		this.restrictedAccess = restrictedAccess;
	}

	public String getUnofficialApi() {
		return unofficialApi;
	}

	public void setUnofficialApi(String unofficialApi) {
		this.unofficialApi = unofficialApi;
	}




	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

	public String getApiEndPoint() {
		return apiEndPoint;
	}

	public void setApiEndPoint(String apiEndPoint) {
		this.apiEndPoint = apiEndPoint;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getDocsHomePageUrl() {
		return docsHomePageUrl;
	}

	public void setDocsHomePageUrl(String docsHomePageUrl) {
		this.docsHomePageUrl = docsHomePageUrl;
	}

	public String getInteractiveConsoleUrl() {
		return interactiveConsoleUrl;
	}

	public void setInteractiveConsoleUrl(String interactiveConsoleUrl) {
		this.interactiveConsoleUrl = interactiveConsoleUrl;
	}

	public String getTermsOfServiceUrl() {
		return termsOfServiceUrl;
	}

	public void setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
	}

	public String getDescriptionFileType() {
		return descriptionFileType;
	}

	public void setDescriptionFileType(String descriptionFileType) {
		this.descriptionFileType = descriptionFileType;
	}

	public String getTypeOfLicenseIfNonProprietary() {
		return typeOfLicenseIfNonProprietary;
	}

	public void setTypeOfLicenseIfNonProprietary(String typeOfLicenseIfNonProprietary) {
		this.typeOfLicenseIfNonProprietary = typeOfLicenseIfNonProprietary;
	}

	public List<String> getAuthenticationModel() {
		return authenticationModel;
	}

	public void setAuthenticationModel(List<String> authenticationModel) {
		this.authenticationModel = authenticationModel;
	}

	public List<String> getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(List<String> categoryName) {
		this.categoryName = categoryName;
	}

	public List<String> getSupportedRequestFormats() {
		return supportedRequestFormats;
	}

	public void setSupportedRequestFormats(List<String> supportedRequestFormats) {
		this.supportedRequestFormats = supportedRequestFormats;
	}

	public List<String> getSupportedResponseFormats() {
		return supportedResponseFormats;
	}

	public void setSupportedResponseFormats(List<String> supportedResponseFormats) {
		this.supportedResponseFormats = supportedResponseFormats;
	}

	public Integer getpWebId() {
		return pWebId;
	}

	public void setpWebId(Integer pWebId) {
		this.pWebId = pWebId;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
}
