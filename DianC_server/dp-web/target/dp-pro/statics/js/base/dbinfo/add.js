/**
 * 新增-菜单管理js
 */
var d;
$(function() {

	dp = $(".selectDatasetType").select2({
		placeholder: '请选择数据集类型'
	});
	$(".selectDatasetType").on("change", function() {
		vm.dbinfo.datasetTypeID = $(".selectDatasetType").val();
	})

})
var vm = new Vue({
	el:'#dpLTE',
	data: {
		dbinfo:{
			dbName:null, 
			chName:null,
			description:null,
			datasetTypeID:null,
			orgId:null
		},
		datasetTypelist:[{"id":1,"name":"HBASE"},{"id":0,"name":"HDFS"}],
		selectedDatasetType:null,
		
		tableInfo: {
			id: null,
			name: null,
			chName:null,  
			datasetTypeID:null,
			//storedataType:null,   
			description:null 
		},

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
		    	url: '../../sys/dbinfo/save?_' + $.now(),
		    	param: vm.dbinfo,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
	},
	//created: function() {
	//	this.getDataList();
	//}
})
