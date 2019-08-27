/**
 * 新增-菜单管理js
 */
$(function() {
	dw = $(".selectDataWrapper").select2({
		placeholder: '请选择封装器'
	});
	$(".selectDataWrapper").on("change", function() {
		vm.equipmentgroup.dataWrapperID = $(".selectDataWrapper").val();
	})
	
	ds = $(".selectDataSet").select2({
		placeholder: '请选择数据集'
	});
	$(".selectDataSet").on("change", function() {
		vm.equipmentgroup.dataSetID = $(".selectDataSet").val();
	})
	
	dt = $(".selectDataTable").select2({
		placeholder: '请选择数据表'
	});
	$(".selectDataTable").on("change", function() {
		vm.equipmentgroup.tableID = $(".selectDataTable").val();
	})
	
	df = $(".selectDataFlow").select2({
		placeholder: '请选择数据流'
	});
	$(".selectDataFlow").on("change", function() {
		vm.equipmentgroup.dataflowID = $(".selectDataFlow").val();
	})
})
var vm = new Vue({
	el:'#dpLTE',
	data: {
		equipmentgroup:{
			name:null,
			description:null,
			userID:1,
			creater: null,
			registerCode: '-',
			protocol: null,
			//protocol: 'http',
			saveTag: '0',
			dataSetID: '1',
			tableID: '1',
			dataflowID: '1',
			msServer: '0',
			dataWrapperID: null
		},
		dataWrapperList: [],
		dataSetList: [],
		dataTableList:[],
		dataFlowList: [],
		selectedWrapper: null,
		selectedDataSet: null,
		selectedDataTable:null,
		selectedDataFlow: null
	},
	methods : {
		selectIcon: function() {
			dialogOpen({
				id: 'iconSelect',
				title: '选取图标',
		        url: 'base/menu/icon.html?_' + $.now(),
		        scroll : true,
		        width: "1030px",
		        height: "600px",
		        btn: false
		    })
		},
		menuTree: function(){
		    dialogOpen({
				id: 'layerMenuTree',
				title: '选择菜单',
		        url: 'base/menu/tree.html?_' + $.now(),
		        scroll : true,
		        width: "300px",
		        height: "450px",
		        yes : function(iframeId) {
		        	top.frames[iframeId].vm.acceptClick();
				}
		    })
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/equipmentgroup/save?_' + $.now(),
		    	param: vm.equipmentgroup,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
		getDataList: function() {
			$.getJSON('../../sys/wrapper/list?_' + $.now(), function(data) {
				vm.dataWrapperList = data.wrapperList;
			});
			$.getJSON('../../sys/dataset/list?_' + $.now(), function(data) {
				vm.dataSetList = data.dataSetList;
			});
			
			$.getJSON('../../sys/datatable/list?_' + $.now(), function(data) {
				vm.dataTableList = data.dataTableList;
			});
			
			$.getJSON('../../sys/dataflow/list?_' + $.now(), function(data) {
				vm.dataFlowList = data.dataFlowList;
			});

		}
	},
	created: function() {
		this.getDataList();
	}
})
