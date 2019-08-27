$(function () {
	initialPage();
	getGrid();
//	initListlineGrid();
});
function initialPage() {
	$("#treePanel").css('height', $(window).height()-54);
	$(window).resize(function() {
		$("#treePanel").css('height', $(window).height()-54);
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-54});
	});
}
function query(){
	var opt = {
			url : '../../sys/dbinfoncListline/query?_' + $.now(),
			queryParams : function(params) {
				params.sqlsript = $("#queryText").val().replace(/\</g,"&lt;").replace(/\>/g,"&gt;");//转义">","<"
				//params.sqlsript = $("#queryText").val();
				return params;
				}
	};
	$('#dataGrid').bootstrapTable("refresh", opt);
}
function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		height: $(window).height()-54,
		queryParams: function(params){
			params.sqlsript = $("#queryText").val().replace(/\</g,"&lt;").replace(/\>/g,"&gt;");//转义">","<"
			//params.sqlsript = $("#queryText").val();
			return params;
		},
		columns: [
			{
				field : "result",
				title : "查询结果"
			}
		],
		pagination: false
	})
}
/*function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../sys/dbinfoncListline/listline?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{
				field : "dbId",
				title : "数据集id",
				width : "50px"
			},{
				field : "name",
				title : "数据集名称",
				width : "200px"
			},{                             
				field : "chName",
				title : "中文名称",
				width : "200px"
			},{
				field : "description",
				title : "描述信息",
				width : "200px"
			}
		],
		
		onLoadSuccess: function(data) { 
			if ((data.rows[0]!=null)&&(vm.isFirstPage))
				vm.selectedDbinfoId = data.rows[0].id;//Id
			getListlineGrid();
			//vm.selectedDbinfoId = data.rows[0].id; // 默认显示第一个设备下的设备
			return false;
		},
		
		onClickRow: function(item, $element) { // 单击每一行
			vm.selectedDbinfoId = item.id;//
			getListlineGrid();
			return false;
		},
		
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


function getListlineGrid() {
  var opt = {
	  url : '../../sys/dbinfonclistline/listline?_' + $.now(),
	  queryParams : function(params) {
		  //params.dbId = vm.selectedDbId;
		  params.dbinfoId = vm.selectedDbinfoId;
		  return params;
	  }
  }
  $('#dataGrid_Listline').bootstrapTable("refresh", opt);
}*/

var setting = {
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "dbID",
				rootPId : 0
			},
			key : {
				url : "nourl"
			}
		},
		callback : {
			onClick : function(event, treeId, treeNode) {
				vm.parentId= treeNode.dbinfoId;
				vm.isFirstPage = true;
				vm.load();
				//getDbinfoncGrid();
			}
		}
		
	};




var ztree;

var vm = new Vue({
	el:'#dpLTE',
	data: {
		keyword: null
	},
	methods : {
		
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		
		getOrg : function() {
			$.get('../../sys/dbinfoncListline/listtree',
					function(r) {
						ztree = $.fn.zTree.init($("#orgTree"), setting, r);
						ztree.expandAll(true);
					})
		},
				
		save: function() {
			dialogOpen({
				title: '新增',
				url: 'base/dbinfonclistline/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑',
					url: 'base/dbinfonclistline/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.dDbinfonclistline.hbaseaddress = ck[0].hbaseaddress;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		remove: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.hbaseaddress;
				});
				$.RemoveForm({
					url: '../../sys/dbinfonclistline/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	},
	created : function() {
		//this.getDbinfo(this.dbinfoId);
		this.getOrg();
	}
})