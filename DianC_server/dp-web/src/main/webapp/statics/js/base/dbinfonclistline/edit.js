/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		dDbinfonclistline: {
			hbaseaddress: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/dbinfonclistline/info?_' + $.now(),
		    	param: vm.dDbinfonclistline.hbaseaddress,
		    	success: function(data) {
		    		vm.dDbinfonclistline = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/dbinfonclistline/update?_' + $.now(),
		    	param: vm.dDbinfonclistline,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})