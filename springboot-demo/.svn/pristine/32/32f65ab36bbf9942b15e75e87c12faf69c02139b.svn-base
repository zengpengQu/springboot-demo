package com.cmahrmobile.hr.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title:TreeViewNode.java</p>
 * <p>Description: </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2018</p>
 * <p>Date:2018年01月24</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
public class TreeViewNode implements Serializable{

        private static final long serialVersionUID = -1995886739138270666L;

        private String id = null;

        private String name = null;

        private String parentId = null;

        private boolean isLeaf = false;

        private String unitType = null;

        private Integer seq;

        public Integer getSeq() {
            return seq;
        }

        public void setSeq(Integer seq) {
            this.seq = seq;
        }

        private List<TreeViewNode> child = new ArrayList<TreeViewNode>();

        public TreeViewNode() {}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setText(String name) {
            this.name = name;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public List<TreeViewNode> getChild() {
            return child;
        }

        public void setChild(List<TreeViewNode> child) {
            this.child = child;
        }

        public static long getSerialversionuid() {
            return serialVersionUID;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }
        public String getUnitType() {
            return unitType;
        }

        public void setUnitType(String unitType) {
            this.unitType = unitType;
        }
}
