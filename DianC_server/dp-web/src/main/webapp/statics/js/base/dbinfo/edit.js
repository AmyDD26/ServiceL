/**
 * 编辑-数据集js
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
//alert("123")
var vm = new Vue({
	el:'#dpLTE',
	data: {
		dbinfo:{
			dbName:null,
			chName:null,
			description:null,
			datasetTypeID:null
		},
		datasetTypelist:[{"id":1,"name":"HBASE"},{"id":0,"name":"HDFS"}],
		selectedDatasetType:null
	},
	
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/dbinfo/info?_' + $.now(),
		    	param: vm.dbinfo.id,
		    	success: function(data) {
		    		vm.dbinfo = data;
		    		console.log(data);
		    		dp.val(vm.dbinfo.datasetTypeID).trigger("change");
		    		dp.change()
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
			
		    $.ConfirmForm({
		    	url: '../../sys/dbinfo/update?_' + $.now(),
		    	param: vm.dbinfo,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})