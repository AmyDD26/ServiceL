/**
 * 服务-详情js
 */
var vm2 = new Vue({
    el:'#dpLTE2',
    data: {
        service:{
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
        setForm: function() {
            $.SetForm({
                url: '../../sys/service/info?_' + $.now(),
                param: vm.service.id,
                success: function(data) {
                    vm.service = data;
                    console.log(data);
                }
            });
        },
        acceptClick: function() {
            if (!$('#form').Validform()) {
                return false;
            }
            $.ConfirmForm({
                url: '../../sys/service/update?_' + $.now(),
                param: vm.service,
                success: function(data) {
                    $.currentIframe().vm.load();
                }
            });
        }
    }
})