package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;

import java.util.List;

@XmlHead(value = "IVRFlow")
public class IvrFlow extends Attributes {

    @XmlField("menus")
    private List<Menu> menuList;

    @Override
    public String toString() {
        return "IvrFlow{" +
                "menuList=" + menuList +
                ", headerAttrs=" + headerAttrs +
                ", fieldsAttrs=" + fieldsAttrs +
                '}';
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
