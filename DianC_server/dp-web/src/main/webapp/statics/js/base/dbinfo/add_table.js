/**
 * 创建-表js
 */
function GetRequest() {   
   var url = location.search; //获取url中"?"符后的字串   
   var theRequest = new Object();   
   if (url.indexOf("?") != -1) {   
      var str = url.substr(1);   
      strs = str.split("&");   
      for(var i = 0; i < strs.length; i ++) {   
         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
      }   
   }   
   return theRequest;   
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
		table:{
			name:null,
			chName:null,
			publishTime:null,
			description:null,
			hasPartition:'0',
			storedataType:null,
			dbID:0,
			topic:null,
			keyword:null
		}
	},
	methods : {
		acceptClick: function() {
			//vm.table.publishTime = getNowFormatDate();			
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/tablestructure/save_table?_' + $.now(),
		    	param: vm.table,
		    	success: function(data) {
		    		$.currentIframe().vm.tablestructure_load();
		    	}
		    });
		}
	},
	created: function() {
		this.table.dbID = GetRequest().dbinfoID;
		//this.getDataList();
	}
})
/*$(function() {
	dt = $(".selectedstoredataType").select2({
		placeholder: '请选择存储类型'
	});
	$(".selectedstoredataType").on("change", function() {
		vm.table.storedataType = $(".selectedstoredataType").val();
	})

})
*/
/*var vm = new Vue({
	el:'dpLTE',
	data: {
		table:{
			name:null,
			chName:null,
			storedataType:null
		}
	},
	storedataTypeList: [],
	selectedstoredataType:null,
	methods : {
		acceptClick: function() {
			if(!$('#form').Validform()) {
				return false;
			}
			$.SaveForm({
				url:'../../sys/tablestructure/save?_' + $.now(),
				param:vm.table,
				success: function(data){
					$.currentIframe().vm.getOrg();
				}
			});
		},
		getDataList: function(){
			$.getJSON('../../sys/storedataType/list?_' + $.now(), function(data) {
				vm.datastoredataTypeList = data.storedataTypeList;
			});
		}
	},
	created: function() {
		this.getDataList();
	}
})*/