/**
 * 新建表字段
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
$(function() {
	dp = $(".selectisKey").select2({
		placeholder: '请选择是否为主键'
	});
	$(".selectisKey").on("change", function() {
		vm.tablestructure.isKey = $(".selectisKey").val();
	})
})
$(function() {
	dp = $(".selectisNull").select2({
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
			fieldType:'VARCHAR', 
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
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/tablestructure/save?_' + $.now(),
		    	param: vm.tablestructure,
		    	success: function(data) {
		    		$.currentIframe().vm.tablestructure_load();
		    	}
		    });
		}
	},
	created: function() {
		this.tablestructure.tableInfoID = GetRequest().tableinfoId;
		this.getDataList();
	}
})