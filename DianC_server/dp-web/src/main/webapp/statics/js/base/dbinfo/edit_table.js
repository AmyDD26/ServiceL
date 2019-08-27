/**
 * 创建表js
 * 
 */

$(function() {
	initialPage();
	inittablestructureGrid();
});

function GetRequest() {   
   var url = location.search; //获取url中"?"符后的字串，使用了两次decodeRUI解码
   var theRequest = new Object();   
   if (url.indexOf("?") != -1) {   
      var str = url.substr(1);   
      strs = str.split("&");   
      for(var i = 0; i < strs.length; i ++) {   
         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
      }   
   }   
   return theRequest;   
}



function initialPage() {
	$("#treePanel").css('height', $(window).height()-54);
	$(window).resize(function() {
		$("#treePanel").css('height', $(window).height()-54);
		
		$('#dataGrid_tableconstructor').bootstrapTable('resetView', {
			height : $(window).height() - 54
		});
	});
}

function inittablestructureGrid() {
    $('#dataGrid_tableconstructor').bootstrapTableEx({
    	height : $(window).height() - 54,
	    queryParams : function(params) {
			params.tableInfoId = vm.selectedTableinfoId;
			return params;
		    },
	    columns : [ {
			checkbox : true
		}, {
		   field : "name",
		   title : "字段名称",               
		   width : "200px"
	    }, {
		   field : "fieldType",                 
		   title : "字段类型",                     
		   width : "200px"
	    }, {
	    	field : "defaultValue",                 
			title : "默认值",                     
			width : "200px"
		}, {
			field : "chName",                 
			title : "字段中文名",                     
			width : "200px"
		}, {
			field : "length",                 
			title : "字段长度",                     
			width : "200px"
		}, {
			field : "isNullName",                 
			title : "是否可以为空",                     
			width : "200px"
		}, {
			field : "isKeyName",                 
			title : "是否为主键",                     
			width : "200px"
		}],
		onPageChange: function(pageNo, size) {
			if(pageNo != 1) {
				vm.isFirstPage = false;
			} else {
				vm.isFirstPage = true;
			}
		},
		singleSelect:  true// 单选形式
    })
}

function getTableStructure() {
	var opt = {
		url : '../../sys/tablestructure/list?_' + $.now(),
		queryParams : function(params) {
			params.tableInfoId = vm.selectedTableinfoId;
		  return params;
		}
	 }
	$('#dataGrid_tableconstructor').bootstrapTable('refresh', opt);
}

var setting = {
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "dbID",
				rootPId : "0"
			},
			key : {
				url : "nourl"
			}
		},
		callback : {
			onClick : function(event, treeId, treeNode) {
				//alert(treeNode.id + ", " + treeNode.name);
				vm.selectedTableinfoId = treeNode.id;
				getTableStructure();
			}
		}
		
	};
var ztree;

var vm = new Vue({
	el : '#dpLTE',
	data : {
		keyword : null,
		selectedDbinfoId: null,
		selectedTableinfoId: null,
		isFirstPage: true, // 是第一页时默认选中第一项
		parentName : null,
		parentId : '0',
		dataGrid_dbinfoncID : null,
		btNew : '0',
		
	},
	methods : {
		
		tablestructure_load : function() {
			$('#dataGrid_tableconstructor').bootstrapTable('refresh',{pageNumber:1});
			/*$.get('../../sys/tablestructure/select', 
					{dbInfoID: GetRequest().dbinfoID,dbName: decodeURI(decodeURI(GetRequest().dbinfoName))},
					function(r) {
						ztree = $.fn.zTree.init($("#orgTree"), setting, r);
						ztree.expandAll(true);
					}
				);*/
		},		
		getOrg : function(parentId,parentName,dataGrid_dbinfoncID,btNew) {
			$.get('../../sys/tablestructure/select', 
					{dbInfoID: parentId,dbName: parentName},
					function(r) {
						ztree = $.fn.zTree.init($("#orgTree"), setting, r);
						ztree.expandAll(true);
						if(vm.btNew != '0'){
							var node = ztree.getNodeByParam("id", vm.dataGrid_dbinfoncID);
							ztree.selectNode(node,true);//将指定ID的节点选中
							ztree.setting.callback.onClick(null, ztree.setting.treeId, node,1);	
						}
						else{
						dialogOpen({
							title : '新增表',
							url : 'base/dbinfo/add_table.html?dbinfoID=' + vm.parentId +'&'+ $.now(),
							width : '600px',
							height : '350px',
							scroll : true,
							yes : function(iframeId) {
								top.frames[iframeId].vm.acceptClick();
							},
						});
						}
							
					}
					
				)
		},			
		tablestructure_save : function() {
			dialogOpen({
				title : '新增表字段',
				url : 'base/dbinfo/add_structure.html?tableinfoId=' + vm.selectedTableinfoId +'&' + $.now(),
				width : '800px',
				height : '550px',
				scroll : true,
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		tablestructure_edit : function() {
			var ck = $('#dataGrid_tableconstructor').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				dialogOpen({
					title : '编辑表字段',
					url : 'base/dbinfo/edit_structure.html?_' + $.now(),        
					width : '800px',
					height : '550px',
					scroll : true,
					success : function(iframeId) {
						top.frames[iframeId].vm.tablestructure = ck[0];        
						top.frames[iframeId].vm.setForm();
					},
					yes : function(iframeId) {
						top.frames[iframeId].vm.acceptClick();
					},
				});
			}
		},
		tablestructure_remove : function() {		
			var ck = $('#dataGrid_tableconstructor').bootstrapTable('getSelections'), ids = [];
			if (checkedArray(ck)) {
				$.each(ck, function(idx, item) {
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url : '../../sys/tablestructure/remove?_' + $.now(),
					param : ids,
					success : function(data) {
						vm.tablestructure_load();
					}
				});
			}
		},
		table_create : function() {
			dialogOpen({
				title : '新增表',
				url : 'base/dbinfo/add_table.html?dbinfoID=' + vm.parentId +'&'+ $.now(),
				width : '600px',
				height : '350px',
				scroll : true,
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		}
	},
	created : function() {
		this.parentId = GetRequest().dbinfoID;
		this.dataGrid_dbinfoncID = GetRequest().dataGrid_dbinfoncID;
		this.parentName = decodeURI(decodeURI(GetRequest().dbinfoName));
		this.btNew = decodeURI(decodeURI(GetRequest().btNew));
		this.getOrg(this.parentId,this.parentName,this.orgTreeID,this.btNew);
	}		
		
})