/**
 * 修改Hbase地址js
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
		
		setForm: function() {
			$.SetForm({
				url: '../../sys/hbaseaddr/info?_' + $.now(),
		    	param: vm.hbaseaddr.id,
		    	success: function(data) {
		    		vm.hbaseaddr = data;
		    		console.log(data)
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/hbaseaddr/update?_' + $.now(),
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
