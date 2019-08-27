/**
 * Hbase地址管理js
 */

$(function() {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {
			height : $(window).height() - 54
		});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url : '../../sys/hbaseaddr/list?_' + $.now(),
		height : $(window).height() - 54,
		queryParams : function(params) {
			params.username = vm.keyword;
			return params;
		},
		columns : [ {
			checkbox : true,
			formatter: setFristSelected
		}/*,{
			field : "id",
			title : "Hbase地址id",
			width : "50px"
		}*/, {
			field : "hbaseType",
			title : "地址类型",
			width : "200px"
		}, {
			field : "hbaseAddress",
			title : "地址",
			width : "200px"
		}, {
			field : "hbasePort",
			title : "端口",
			width : "200px"
		}],
		onClickRow: function(item, $element) { // 单击每一行
			vm.selectedGroupId = item.id;
			//getEquipmentGrid();
			return false;
		},
		onPageChange: function(pageNo, size) {
			if(pageNo != 1) {
				vm.isFirstPage = false;
			} else {
				vm.isFirstPage = true;
			}
		}
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
		selectedGroupId: null,
		isFirstPage: true // 是第一页时默认选中第一项
	},
	methods : {
		load : function() {
			$('#dataGrid').bootstrapTable('refresh');
		}/*,
		save : function() {
			dialogOpen({
				title : '新增Hbase地址',
				url : 'base/hbaseaddr/add.html?_' + $.now(),
				width : '600px',
				height : '350px',
				scroll : true,
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		}*/,
		edit : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				dialogOpen({
					title : '编辑Hbase地址',
					url : 'base/hbaseaddr/edit.html?_' + $.now(),
					width : '600px',
					height : '350px',
					scroll : true,
					success : function(iframeId) {
						top.frames[iframeId].vm.hbaseaddr.id = ck[0].id;
						top.frames[iframeId].vm.setForm();
					},
					yes : function(iframeId) {
						top.frames[iframeId].vm.acceptClick();
					},
				});
			}
		}/*,
		remove : function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];
			if (checkedArray(ck)) {
				$.each(ck, function(idx, item) {
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url : '../../sys/hbaseaddr/remove?_' + $.now(),
					param : ids,
					success : function(data) {
						vm.load();
					}
				});
			}
		}*/

	}
})