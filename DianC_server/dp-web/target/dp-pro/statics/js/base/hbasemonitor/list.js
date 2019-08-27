/**
 * Hbase环境监控js
 */

$(function() {
	initialPage();
	getAttrGrid();
	getTableGrid();
	getRegServGrid();
	getRegInfoGrid(null); 
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid_cluster').bootstrapTable('resetView', {
			height : $(window).height() / 2 - 54
		});
	});
	$(window).resize(function() {
		$('#dataGrid_table').bootstrapTable('resetView', {
			height : $(window).height() / 2 - 54
		});
	});
	$(window).resize(function() {
		$('#dataGrid_server').bootstrapTable('resetView', {
			height : $(window).height() / 2 - 54
		});
	});
	$(window).resize(function() {
		$('#dataGrid_region').bootstrapTable('resetView', {
			height : $(window).height() / 2 - 54
		});
	});
}

function getAttrGrid() {
	$('#dataGrid_cluster').bootstrapTableEx({
		url : '../../sys/hbasemoni/list_Hbasemoniattr?_' + $.now(),
		height : $(window).height() / 2 - 54,
		queryParams : function(params) {
			params.username = vm.keyword;
			return params;
		},
		pagination : false,
		columns : [{
			field : "attributeName",
			title : "属性名称",
			width : "200px"
		}, {
			field : "attributeValue",
			title : "属性值",
			width : "200px"
		}]
	})
};
function getTableGrid() {
	$('#dataGrid_table').bootstrapTableEx({
		url : '../../sys/hbasemoni/list_Hbasemonitable?_' + $.now(),
		height : $(window).height() / 2 - 54,
		queryParams : function(params) {
			params.username = vm.keyword;
			return params;
		},
		pagination : false,
		columns : [{
			field : "tableName",
			title : "表名",
			width : "200px"
		}, {
			field : "onlineRegionNum",
			title : "在线region数",
			width : "200px"
		}]
	})
};
function getRegServGrid() {
	$('#dataGrid_server').bootstrapTableEx({
		url : '../../sys/hbasemoni/list_Hbasemoniregserv?_' + $.now(),
		height : $(window).height() / 2 - 54,
		queryParams : function(params) {
			params.username = vm.keyword;
			return params;
		},
		pagination : false,
		columns : [{
			field : "serverName",
			title : "服务器名",
			width : "200px"
		},/* {
			field : "serverIp",
			title : "服务器IP",
			width : "200px"
		}, */{
			field : "serverStatus",
			title : "服务器状态",
			width : "200px",
			events : operateEvents,// 给按钮注册事件
			formatter : ShowRegionInfo,// 表格中增加按钮
		}, {
			field : "regionNum",
			title : "region数",
			width : "200px"
		}, {
			field : "maxHeap",
			title : "JVM内存大小(MB)",
			width : "200px"
		}, {
			field : "userHeap",
			title : "已用JVM内存(MB)",
			width : "200px"
		}, {
			field : "fileSize",
			title : "存储文件大小(MB)",
			width : "200px"
		}]
	})
};

function ShowRegionInfo(value,row,index){
	return[
		'<button id="ShowStatus" type="button" class="btn btn-link">查看</button>'
	].join("")
};

window.operateEvents = {
		"click #ShowStatus":function(e,value,row,index){
			$('#dataGrid_region').bootstrapTable('destroy');
			getRegInfoGrid(value);
			//$('#dataGrid_region').bootstrapTable('refresh');
		}
}
function getRegInfoGrid(name) {
	$('#dataGrid_region').bootstrapTableEx({
		url : '../../sys/hbasemoni/list_Hbasemonireginfo?servername=' + name + '_' + $.now(),
		height : $(window).height() / 2 - 54,
		queryParams : function(params) {
			params.username = vm.keyword;
			return params;
		},
		pagination : false,
		columns : [ {
			field : "serverName",
			title : "所属服务器名",
			width : "200px"
		}, {
			field : "region",
			title : "region",
			width : "200px"
		}, {
			field : "fileSize",
			title : "存储文件大小(MB)",
			width : "200px"
		}]
	})
};


var vm = new Vue({
	el : '#dpLTE',
	data : {
		keyword : null,
		//selectedGroupId: null,
		//isFirstPage: true // 是第一页时默认选中第一项
	},
	methods : {
		/*loadcluster : function() {
			$('#dataGrid_cluster').bootstrapTable('destroy');
			getAttrGrid();
			//$('#dataGrid').bootstrapTable('refresh');
		},
		loadtable : function() {
			$('#dataGrid_table').bootstrapTable('destroy');
			getTableGrid();
			//$('#dataGrid').bootstrapTable('refresh');
		},
		loadserver : function() {
			$('#dataGrid_server').bootstrapTable('destroy');
			getRegServGrid();
			//$('#dataGrid').bootstrapTable('refresh');
		},
		save : function() {
			dialogOpen({
				title : '新增Hbase地址',
				url : 'base/hbaseaddr/add.html?_' + $.now(),
				width : '600px',
				height : '350px',
				scroll : true,
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				dialogOpen({
					title : '编辑Hbase地址',
					url : 'base/hbaseaddr/edit.html?_' + $.now(),
					width : '600px',
					height : '350px',
					scroll : true,
					success : function(iframeId) {
						top.frames[iframeId].vm.hbaseaddr.id = ck[0].id;
						top.frames[iframeId].vm.setForm();
					},
					yes : function(iframeId) {
						top.frames[iframeId].vm.acceptClick();
					},
				});
			}
		}/*,
		remove : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];
			if (checkedArray(ck)) {
				$.each(ck, function(idx, item) {
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url : '../../sys/hbaseaddr/remove?_' + $.now(),
					param : ids,
					success : function(data) {
						vm.load();
					}
				});
			}
		}*/

	}
})