/**
 * 编辑-设备js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		equipment:{
			name:null,
			description:null,
			
			
            groupID:null,
			tagID:null,
			status:null,
			//inTime:null,
			lat:null,
			lon:null
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/equipment/info?_' + $.now(),
		    	param: vm.equipment.id,
		    	success: function(data) {
		    		vm.equipment = data;
		    		console.log(data);
		    		
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/equipment/update?_' + $.now(),
		    	param: vm.equipment,
		    	success: function(data) {
		    		$.currentIframe().vm.loadEquipment();
		    	}
		    });
		}
	}
})
