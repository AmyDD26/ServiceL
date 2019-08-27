/**
 * 服务管理
 */
$(function() {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {
			height : $(window).height() -50
		});
	});
}
function serviceTypeChange() {
	debugger;
	var serviceType = $(".selectDataWrapper").val();
	var kw = $(".keyWord").val();
	$('#dataGrid').bootstrapTable('refreshOptions',{
		height : $(window).height() -50,
		url : '../../sys/service/list?_' + $.now(),
		queryParams : function(params) {
			//params.username = vm.keyword;
			params.serviceType = serviceType;
			params.kw = kw;
			return params;
		}
	});
}
function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url : '../../sys/service/list?_' + $.now(),
		height : $(window).height() -50,
		queryParams : function(params) {
			params.username = vm.keyword;
			return params;
		},
		columns : [ {
			checkbox : true,
			formatter: setFristSelected
		}, {
			field : "apiId",
			title : "序号",
			width : "50px"
		}, {
			field : "apiName",
			title : "服务名称",
			width : "50px"
		}, {
			field : "inParameter",
			title : "输入参数",
			width : "50px"
		}, {
			field : "outParameter",
			title : "输出参数",
			width : "50px"
		}, {
			field : "type",
			title : "服务类型",
			width : "20px"
		}, {
			field : "apiDescription",
			title : "服务描述",
			width : "50px"
		},  {
			field : "addDate",
			title : "创建日期",
			width : "30px"
		}],
		onClickRow: function(item, $element) { // 单击每一行
			vm.selectedServiceId = item.id;
			//getEquipmentGrid();
			return false;
		},
		onPageChange: function(pageNo, size) {
			if(pageNo != 1) {
				vm.isFirstPage = false;
			} else {
				vm.isFirstPage = true;
			}
		},
		singleSelect: false // 单选形式
	})
};


function setFristSelected(value, row, index) {
	if(index == 0 && vm.isFirstPage) {
		return {
			checked: true
		}
	}
}

var vm = new Vue({
	el : '#dpLTE',
	data : {
		keyword : null,
		selectedServiceId: null,
		isFirstPage: true, // 是第一页时默认选中第一项
		allServiceType:[],
		serviceTypeId:null
	},
	methods : {
		load : function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save : function() {
			dialogOpen({
				title : '新增服务',
				url : 'base/service/add.html?_' + $.now(),
				width : '600px',
				height : '350px',
				scroll : true,
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				dialogOpen({
					title : '编辑服务',
					url : 'base/service/edit.html?_' + $.now(),
					width : '600px',
					height : '350px',
					scroll : true,
					success : function(iframeId) {
						top.frames[iframeId].vm.service = ck[0];
						top.frames[iframeId].vm.setForm();
					},
					yes : function(iframeId) {
						top.frames[iframeId].vm.acceptClick();
					},
				});
			}
		},
		remove : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			var ids = new Array() ;
			if (checkedArray(ck)) {
				$.each(ck, function(idx, item) {
					ids[idx] = item.apiId;
				});
				$.RemoveForm({
					url : '../../sys/service/remove?_' + $.now(),
					param : ids,
					success : function(data) {
						vm.load();
					}
				});
			}
		},
        list : function() {
        	var ck = $('#dataGrid').bootstrapTable('getSelections');
        	if (checkedRow(ck)) {
        		dialogOpen({
        			title : '服务其他详情',
        			url : 'base/service/apiDetail.html?_' + $.now(),
        			width : '600px',
        			height : '350px',
        			scroll : true,
        			success : function(iframeId) {
        				top.frames[iframeId].vm.service = ck[0];
        				top.frames[iframeId].vm.setForm();
        			},
        			// yes : function(iframeId) {
                    //     top.frames[iframeId].vm.acceptClick();
                    // },
        		});
        	}
        },
		getServicetype :function(){                   //http get请求data.json 的数据
			$.getJSON('../../sys/service/serviceTypeAll?_' + $.now(), function(data) {
				console.log(data)
				vm.allServiceType = data.dataFlowList;
			});
		},

	},
	created: function() {
		this.getServicetype();
	}
});