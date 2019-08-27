/**
 * 设备管理js
 */

$(function() {
	initialPage();
	initEquipmentGrid();
	getGrid();
});

function initialPage() {
	$("#treePanel").css('height', $(window).height()-54);
	$(window).resize(function() {
		$("#treePanel").css('height', $(window).height()-54);
		$('#dataGrid_group').bootstrapTable('resetView', {
			height : $(window).height() / 2 - 54
		});
		$('#dataGrid_equipment').bootstrapTable('resetView', {
			height : $(window).height() / 2 - 54
		});
	});
}

function getGrid() {
	$('#dataGrid_group').bootstrapTableEx({
		url : '../../sys/equipmentgroup/list?_' + $.now(),
		height : $(window).height() / 2 - 54,
		queryParams : function(params) {
			params.orgId = vm.parentId;
			//params.username = vm.keyword;
			return params;
		},
		columns : [ {
			checkbox : true,
			formatter: setFristSelected
		}, {
			field : "id",
			title : "设备组id",
			width : "50px"
		}, {
			field : "publishTime",
			title : "创建时间",
			width : "400px"
		}, {
			field : "name",
			title : "设备组名",
			width : "220px"
		}, {
			field : "description",
			title : "描述",
			width : "220px"
		}, {
			field : "protocol",
			title : "协议",
			width : "100px"
		}, {
			field : "dataSetName",
			title : "数据集",
			width : "300px"
		}, {
			field : "dataTableName",
			title : "数据表",
			width : "100px"
		},{
			field : "dataFlowName",
			title : "数据流",
			width : "200px"
		}, {
			field : "dataWrapperName",
			title : "封装器名称",
			width : "400px"
		}],
		onLoadSuccess: function(data) {
			if ((data.rows[0]!=null)&&(vm.isFirstPage)){
				vm.selectedGroupId = data.rows[0].id; // 默认显示第一个设备下的设备
			}
			getEquipmentGrid(); // 初始化设备
			return false;
		},
		onClickRow: function(item, $element) { // 单击每一行
			vm.selectedGroupId = item.id;   
			getEquipmentGrid();
			return false;
		},
		onPageChange: function(pageNo, size) {
			if(pageNo != 1) {
				vm.isFirstPage = false;
			} else {
				vm.isFirstPage = true;
			}
		},
		singleSelect: true // 单选形式
	})
};

function setFristSelected(value, row, index) {
	if(index == 0 && vm.isFirstPage) {
		return {
			checked: true
		}
	}
}

function initEquipmentGrid() {
	$('#dataGrid_equipment').bootstrapTableEx({
		url : '../../sys/equipment/list?_' + $.now(),
		height : $(window).height() / 2 - 54,
		queryParams : function(params) {
			params.groupId = vm.selectedGroupId;
			return params;
		},
		columns : [ {
			checkbox : true
		}, {
			field : "id",
			title : "编号",
			width : "50px"
		}, {
			field : "name",
			title : "设备名",
			width : "50px"
		}, {
			field : "description",
			title : "设备描述",
			width : "50px"
		}, {
			field : "tagID",
			title : "标识",
			width : "50px"
		}, {
			field : "groupID",
			title : "所属设备组",
			width : "20px"
		}, {
			field : "lat",
			title : "部署位置x",
			width : "50px"
		},  {
			field : "lon",
			title : "部署位置y",
			width : "30px"
		}, {
			field : "status",
			title : "状态",
			width : "50px"
		}, {
			field : "inTime",
			title : "接入时间",
			width : "100px"
		}]
	})
}

function getEquipmentGrid() {
	// console.log(group)
	var opt = {
		url : '../../sys/equipment/list?_' + $.now(),
		queryParams : function(params) {
			params.groupId = vm.selectedGroupId;
			return params;
		}
	}
	$('#dataGrid_equipment').bootstrapTable("refresh", opt);
}

var setting = {
		data : {
			simpleData : {
				enable : true,
				idKey : "orgId",
				pIdKey : "parentId",
				rootPId : "0"
			},
			key : {
				url : "nourl"
			}
		},
		callback : {
			onClick : function(event, treeId, treeNode) {
				vm.parentId= treeNode.orgId;
				vm.isFirstPage = true;
				vm.load();
			}
		}
		
	};
var ztree;

var vm = new Vue({
	el : '#dpLTE',
	data : {
		keyword : null,
		selectedGroupId: null,
		isFirstPage: true, // 是第一页时默认选中第一项
		
		parentId : '0',
	},
	methods : {
		load : function() {
			$('#dataGrid_group').bootstrapTable('refresh',{pageNumber:1});
		},
		loadEquipment : function() {
			$('#dataGrid_equipment').bootstrapTable('refresh');
		},
		getOrg : function(parentId) {
			$.get('../../sys/org/list', {orgCode: parentId},function(r) {
				ztree = $.fn.zTree.init($("#orgTree"), setting, r);
				ztree.expandAll(true);
			})
		},	
		
		save : function() {
			dialogOpen({
				title : '新增设备组',
				url : 'base/equipment/add.html?_' + $.now(),
				width : '600px',
				height : '400px',
				scroll : true,
				
				success : function(iframeId) {
					top.frames[iframeId].vm.equipmentgroup.orgId = vm.parentId;
				},
				
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		saveWrapper: function() {
			dialogOpen({
				title : '新增封装器',
				url : 'base/equipment/wrapper/add.html?_' + $.now(),
				width : '600px',
				height : '350px',
				scroll : true,
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit : function() {
			var ck = $('#dataGrid_group').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				dialogOpen({
					title : '编辑设备组',
					url : 'base/equipment/edit.html?_' + $.now(),
					width : '600px',
					height : '400px',
					scroll : true,
					success : function(iframeId) {
						top.frames[iframeId].vm.equipmentgroup = ck[0];
						top.frames[iframeId].vm.setForm();
					},
					yes : function(iframeId) {
						top.frames[iframeId].vm.acceptClick();
					},
				});
			}
		},
		remove : function() {
			var ck = $('#dataGrid_group').bootstrapTable('getSelections'), ids = [];
			if (checkedArray(ck)) {
				$.each(ck, function(idx, item) {
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url : '../../sys/equipmentgroup/remove?_' + $.now(),
					param : ids,
					success : function(data) {
						vm.load();
					}
				});
			}
		},
		disable : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];
			if (checkedArray(ck)) {
				$.each(ck, function(idx, item) {
					ids[idx] = item.userId;
				});
				$.ConfirmForm({
					msg : '您是否要禁用所选账户吗？',
					url : '../../sys/user/disable?_' + $.now(),
					param : ids,
					success : function(data) {
						vm.load();
					}
				});
			}
		},
		enable : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];
			if (checkedArray(ck)) {
				$.each(ck, function(idx, item) {
					ids[idx] = item.userId;
				});
				$.ConfirmForm({
					msg : '您是否要启用所选账户吗？',
					url : '../../sys/user/enable?_' + $.now(),
					param : ids,
					success : function(data) {
						vm.load();
					}
				});
			}
		},
		reset : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				dialogOpen({
					title : '重置密码',
					url : 'base/user/reset.html?_' + $.now(),
					width : '400px',
					height : '220px',
					success : function(iframeId) {
						top.frames[iframeId].vm.user.userId = ck[0].userId;
					},
					yes : function(iframeId) {
						top.frames[iframeId].vm.acceptClick();
					},
				});
			}
		},
		// 对设备的操作
		reloadEquipment : function() {
			$('#dataGrid_equipment').bootstrapTable('refresh');
		},
		saveEquipment : function() {
			var ck = $('#dataGrid_group').bootstrapTable('getSelections');
			if(checkedRow(ck)) {
				dialogOpen({
					title : '新增设备',
					url : 'base/equipment/add_equipment.html?_' + $.now(),
					width : '600px',
					height : '350px',
					scroll : true,
					yes : function(iframeId) {
						top.frames[iframeId].vm.equipment.groupID = ck[0].id;
						top.frames[iframeId].vm.acceptClick();
					},
				});
			}
		},
		editEquipment : function() {
			var ck = $('#dataGrid_equipment').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				dialogOpen({
					title : '编辑设备',
					url : 'base/equipment/edit_equipment.html?_' + $.now(),
					width : '600px',
					height : '350px',
					scroll : true,
					success : function(iframeId) {
						top.frames[iframeId].vm.equipment = ck[0];
						top.frames[iframeId].vm.setForm();
					},
					yes : function(iframeId) {
						top.frames[iframeId].vm.acceptClick();
					},
				});
			}
		},
		removeEquipment : function() {
			var ck = $('#dataGrid_equipment').bootstrapTable('getSelections'), ids = [];
			if (checkedArray(ck)) {
				$.each(ck, function(idx, item) {
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url : '../../sys/equipment/remove?_' + $.now(),
					param : ids,
					success : function(data) {
						vm.loadEquipment();
					}
				});
			}
		}
	},
	created : function() {
		this.getOrg(this.orgId); 
	}
})