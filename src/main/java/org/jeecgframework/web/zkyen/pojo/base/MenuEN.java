package org.jeecgframework.web.zkyen.pojo.base;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;
import org.jeecgframework.web.zky.pojo.base.Icon;

/**
 *菜单权限表
 * @author  张代浩
 */
@Entity
@Cacheable  
@Table(name = "zk_en_menu")
@org.hibernate.annotations.Proxy(lazy = false)
public class MenuEN extends IdEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuEN TSFunction;//父菜单
	private String functionName;//菜单名称
	private Short functionLevel;//菜单等级
	private String functionUrl;//菜单地址
	private Short functionIframe;//菜单地址打开方式
	private String functionOrder;//菜单排序
	private Short functionType;//菜单类型
	private Icon TSIcon = new Icon();//菜单图标
	private Icon TSIconDesk;// 云桌面菜单图标
	
	private String functionMark;// 备注
	
	private Integer show_type;//显示类型：1：首部显示 2：底部显示 3：其他显示
	
	private Integer del_access;//是否允许删除：1：不允许（不显示删除按钮）
	
	public Integer getDel_access() {
		return del_access;
	}
	public void setDel_access(Integer del_access) {
		this.del_access = del_access;
	}
	public Integer getShow_type() {
		return show_type;
	}
	public void setShow_type(Integer show_type) {
		this.show_type = show_type;
	}
	/*private int subFunctionSize;
	@Formula(value = "(SELECT count(t_s_function.id) FROM t_s_function where t_s_function.parentfunctionid = id)")
	public int getSubFunctionSize() {
		return subFunctionSize;
	}*/
	public boolean hasSubFunction(Map<Integer, List<MenuEN>> map) {
		if(map.containsKey(this.getFunctionLevel()+1)){
			return hasSubFunction(map.get(this.getFunctionLevel()+1));
		}
		return false;
	}
	public boolean hasSubFunction(List<MenuEN> functions) {
		for (MenuEN f : functions) {
			if(f.getTSFunction().getId().equals(this.getId())){
				return true;
			}
		}
		return false;
	}
	/*public void setSubFunctionSize(int subFunctionSize) {
		this.subFunctionSize = subFunctionSize;
	}*/
	
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "desk_iconid")
    public Icon getTSIconDesk() {
        return TSIconDesk;
    }
    public void setTSIconDesk(Icon TSIconDesk) {
        this.TSIconDesk = TSIconDesk;
    }
    
	private List<MenuEN> TSFunctions = new ArrayList<MenuEN>();
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "iconid")
	public Icon getTSIcon() {
		return TSIcon;
	}
	public void setTSIcon(Icon tSIcon) {
		TSIcon = tSIcon;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parentfunctionid")
	public MenuEN getTSFunction() {
		return this.TSFunction;
	}

	public void setTSFunction(MenuEN TSFunction) {
		this.TSFunction = TSFunction;
	}

	@Column(name = "functionname", nullable = false, length = 50)
	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Column(name = "functionlevel")
	public Short getFunctionLevel() {
		return this.functionLevel;
	}

	public void setFunctionLevel(Short functionLevel) {
		this.functionLevel = functionLevel;
	}
	
	@Column(name = "functiontype")
	public Short getFunctionType() {
		return this.functionType;
	}

	public void setFunctionType(Short functionType) {
		this.functionType = functionType;
	}
	
	@Column(name = "functionurl", length = 100)
	public String getFunctionUrl() {
		return this.functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}
	@Column(name = "functionorder")
	public String getFunctionOrder() {
		return functionOrder;
	}

	public void setFunctionOrder(String functionOrder) {
		this.functionOrder = functionOrder;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSFunction")
	public List<MenuEN> getTSFunctions() {
		return TSFunctions;
	}
	public void setTSFunctions(List<MenuEN> TSFunctions) {
		this.TSFunctions = TSFunctions;
	}
	@Column(name = "functioniframe")
	public Short getFunctionIframe() {
		return functionIframe;
	}
	public void setFunctionIframe(Short functionIframe) {
		this.functionIframe = functionIframe;
	}
	public String getFunctionMark() {
		return functionMark;
	}
	public void setFunctionMark(String functionMark) {
		this.functionMark = functionMark;
	}

}