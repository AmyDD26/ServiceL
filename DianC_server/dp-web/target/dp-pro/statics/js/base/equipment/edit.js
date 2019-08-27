/**
 * 编辑-设备组js
 */
var d;
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
		
		var DataSet= $(".selectDataSet").val();        
	    $.ajax({
	        url: '../../sys/datatable/get?_' + $.now(),
	        dataType: "JSON",
	        data: {'dbInfoID': DataSet},
	        type: "GET",
	        success:function (data) {
	            var dbInfoID= data.id;
	            var option = "<option value=''>请选择年级</option>";
	            if(dbInfoID>0){
	                $("#labId").html(option);
	                for(var i = 0;i<dbInfoID;i++){
	                    option += "<option value='"+data[i].id+"'>"+data[i].name+"</option>";
	                }
	            }
	            $("#datatable").html(option);
	            $("#datatable").val(dbInfoID); //编辑时绑定
	            $("#datatable").select2({ minimumResultsForSearch: -1 });//加载样式
	        },
	        error:function(e) {
	            layer.alert("系统异常，请稍候重试！");
	        }
	    });  
	    
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
			dataWrapperID: null,
			dataflowID: null,
			dataSetID: null,
			tableID:null
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
		setForm: function() {
			$.SetForm({
				url: '../../sys/equipmentgroup/info?_' + $.now(),
		    	param: vm.equipmentgroup.id,
		    	success: function(data) {
		    		vm.equipmentgroup = data;
		    		console.log(data)
		    		dw.val(vm.equipmentgroup.dataWrapperID).trigger("change");
		    		dw.change();
		    		
		    		ds.val(vm.equipmentgroup.dataSetID).trigger("change");
		    		ds.change();
		    		
		    		dt.val(vm.equipmentgroup.tableID).trigger("change");
		    		dt.change();
		    		
		    		df.val(vm.equipmentgroup.dataflowID).trigger("change");
		    		df.change();
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/equipmentgroup/update?_' + $.now(),
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
