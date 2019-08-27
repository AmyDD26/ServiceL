/**
 * 新增-服务
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		service:{
			apiName:null,
			inParameter:null,
			outParameter: null,
			type:null,
			apiDescription:null,
			apiProvider:null,
			apiPortalOrHomePage:null,
			architecturalStyle: null,
			deviceSpecific:null,
			scope:null,
			apiDesign:null,
			sslSupport:null,
			hypermediaApi:null,
			restrictedAccess:null,
			unofficialApi:null,
			authenticationModel:null,
			categoryName:null,
			apiEndPoint:null,
			apiVersion:null,
			docsHomePageUrl:null,
			interactiveConsoleUrl:null,
			termsOfServiceUrl:null,
			descriptionFileType:null,
			typeOfLicenseIfNonProprietary:null,
			supportedRequestFormats:null,
			supportedResponseFormats:null
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/service/save?_' + $.now(),
		    	param: vm.service,
		    	success: function(data) {
		    		//$.currentIframe().vm.loadService();
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})