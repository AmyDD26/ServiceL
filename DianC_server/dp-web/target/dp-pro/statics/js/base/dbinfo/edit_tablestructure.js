/**
 * 修改表字段
 */
$(function() {
	dpisKey = $(".selectisKey").select2({
		placeholder: '请选择是否为空'
	});
	$(".selectisKey").on("change", function() {
		vm.tablestructure.isKey = $(".selectisKey").val();
	})
})
$(function() {
	dpisNull = $(".selectisNull").select2({
		placeholder: '请选择是否为空'
	});
	$(".selectisNull").on("change", function() {
		vm.tablestructure.isNull = $(".selectisNull").val();
	})
})

var vm = new Vue({
	el:'#dpLTE',
	data: {
		tablestructure:{
			name:null,
			fieldType:null, 
			defaultValue:null, 
			chName:null, 
			tableInfoID:0, 
			length:null, 
			isNull:null, 
			isKey:null, 
			isPartitionColumn:0, 
			columnPosition:0
		},
		isKeylist:[{"id":1,"name":"是"},{"id":0,"name":"否"}],
		selectedisKey:null,
		isNulllist:[{"id":1,"name":"是"},{"id":0,"name":"否"}],
		selectedisNull:null
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/tablestructure/info?_' + $.now(),
		    	param: vm.tablestructure.id,
		    	success: function(data) {
		    		vm.tablestructure = data;
		    		console.log(data);
		    		dpisKey.val(vm.tablestructure.isKey).trigger("change");
		    		dpisKey.change();
		    		dpisNull.val(vm.tablestructure.isNull).trigger("change");
		    		dpisNull.change()
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/tablestructure/update?_' + $.now(),
		    	param: vm.tablestructure,
		    	success: function(data) {
		    		$.currentIframe().vm.tablestructure_load();
		    	}
		    });
		}
	},
	created: function() {
		this.getDataList();
	}
})