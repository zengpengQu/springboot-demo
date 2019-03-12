package com.cmahrmobile.hr.dao;

import com.cmahrmobile.hr.base.impl.BaseDaoImpl;
import com.cmahrmobile.hr.entity.TreeViewNode;
import com.cmahrmobile.hr.entity.hrset.PersonInfoSet;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrganizationDeptDao extends BaseDaoImpl<PersonInfoSet, String> {

	public List<TreeViewNode> findAllOrgList(){
		String sql ="select * from tb_dic_organization";
		Map<String,Object> params = new HashMap<>();
		List<TreeViewNode> reslist = new ArrayList<>();
		List<Map<String,Object>> list = jdbcQueryForList(sql,params);
		for(Map<String,Object> map : list){
			TreeViewNode node = new TreeViewNode();
			node.setId(map.get("id").toString());
			node.setText(map.get("org_name").toString());
			node.setChild(new ArrayList<>());
			node.setParentId(map.get("pid").toString());
			node.setUnitType("org");
			TreeViewNode nodeDefault = new TreeViewNode();
			if("R01".equals(node.getId())){
                nodeDefault.setText("中国气象局");
            }else{
                nodeDefault.setText("全部");
            }
			StringBuffer s = new StringBuffer("R00");
			s.append(map.get("id").toString().substring(1));
			nodeDefault.setId(s.toString());
			nodeDefault.setParentId(map.get("id").toString());
			reslist.add(node);
			reslist.add(nodeDefault);
		}
		return sortNodeList(reslist);
	}

	public List<TreeViewNode> findAllDept(){
		String sql ="select * from tb_dic_dept";
		Map<String,Object> params = new HashMap<>();
		List<TreeViewNode> reslist = new ArrayList<>();
		List<Map<String,Object>> list = jdbcQueryForList(sql,params);
		for(Map<String,Object> map : list){
			TreeViewNode node = new TreeViewNode();
			node.setUnitType("dept");
			node.setId(map.get("id").toString());
			node.setText(map.get("dept_name").toString());
			node.setParentId(map.get("p_id").toString());
			node.setChild(new ArrayList<>());
			reslist.add(node);
		}
		return sortNodeList(reslist);
	}

	public Object orgDataTreeView(){
		List<TreeViewNode> bigList = new ArrayList<TreeViewNode>();
		Map<String, TreeViewNode> treeNodeMap = new HashMap<String, TreeViewNode>(16);
		List<TreeViewNode> initOrgList = new ArrayList<>();
		initOrgList.addAll(findAllOrgList());
		initOrgList.addAll(findAllDept());
		for(TreeViewNode node :initOrgList){
			treeNodeMap.put(node.getId(),node);
		}
		for (Map.Entry<String, TreeViewNode> treeNodeEntry : treeNodeMap.entrySet()) {
			TreeViewNode node = treeNodeEntry.getValue();
			TreeViewNode parentNode = treeNodeMap.get(node.getParentId());
			if(parentNode == null){
				continue;
			}else{
			    if("R01".equals(node.getId())){
			        continue;
                }
			    if("R01".equals(parentNode.getId())){
                    node.setParentId("-1");
                }
				if(parentNode.getChild()==null){
					List<TreeViewNode> treeViewNodeList = new ArrayList<TreeViewNode>() ;
					treeViewNodeList.add(node);
					parentNode.setChild(treeViewNodeList);
				}else{
					parentNode.getChild().add(node);
				}
				sortNodeList(parentNode.getChild());
			}
		}
		for (Map.Entry<String, TreeViewNode> treeNodeEntry1 : treeNodeMap.entrySet()) {
			TreeViewNode node = treeNodeEntry1.getValue();
			if ("-1".equals(node.getParentId())){
				bigList.add(node);
			}
		}
		return sortNodeList(bigList);
	}

	/**
	 *
	 * @param list
	 * @return
	 */
	public List<TreeViewNode> sortNodeList(List<TreeViewNode> list){
		Collections.sort(list, new Comparator<TreeViewNode>() {
			@Override
			public int compare(TreeViewNode o1, TreeViewNode o2) {
			    return Long.parseLong(o1.getId().substring(1).replaceAll("[a-zA-Z]",""))-Long.parseLong(o2.getId().substring(1).replaceAll("[a-zA-Z]",""))>0?1:-1;
			}
		});
		return list;
	}


}
