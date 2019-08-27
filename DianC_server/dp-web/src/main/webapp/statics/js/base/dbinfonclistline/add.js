/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		dDbinfonclistline: {
			hbaseaddress: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/dbinfonclistline/save?_' + $.now(),
		    	param: vm.dDbinfonclistline,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
