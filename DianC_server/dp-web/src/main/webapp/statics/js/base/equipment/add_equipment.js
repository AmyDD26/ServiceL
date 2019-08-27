/**
 * 新增-设备js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		equipment:{
			name:null,
			description:null,
			groupID: null,
			
			lat:null,
			lon:null,
			status:null
			//inTime:null
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/equipment/save?_' + $.now(),
		    	param: vm.equipment,
		    	success: function(data) {
		    		$.currentIframe().vm.loadEquipment();
		    	}
		    });
		}
	}
})
