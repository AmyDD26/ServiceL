/**
 * 新建Hbase地址js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		hbaseaddr:{
			id:0,
			hbaseType:null,
			hbaseAddress:null,
			hbasePort:null
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
			//alert(vm.hbaseaddr.hbaseAddress);
			//alert(vm.hbaseaddr.hbasePort);
		    $.SaveForm({
		    	url: '../../sys/hbaseaddr/save?_' + $.now(),
		    	param: vm.hbaseaddr,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	},
	created: function() {
		this.getDataList();
	}
})
