/**
 * 数据管理js
 */

$(function() {
	initialPage();

	initDbinfoncGrid(); // 初始化设备

	inittablestructureGrid();
	 
	
	getGrid();
});

function initialPage() {
	$("#treePanel").css('height', $(window).height()-54);
	$(window).resize(function() {
		$("#treePanel").css('height', $(window).height()-54);
		$('#dbinfo').bootstrapTable('resetView', {
			height : $(window).height() / 2 - 54
		});
		$('#dataGrid_dbinfonc').bootstrapTable('resetView', {
			height : $(window).height() / 2 - 54
		});
		$('#dataGrid_tablestructure').bootstrapTable('resetView', {
			height : $(window).height() / 2 - 54
		});
	});
}

function getGrid() {
	$('#dbinfo').bootstrapTableEx({
		url : '../../sys/dbinfo/list?_' + $.now(),
		height : $(window).height() / 2 - 54,
		queryParams : function(params) {
			params.orgId = vm.parentId;
			return params;
		},
		columns : [ {
			checkbox : true,
			formatter: setFristSelected
		}, {
			field : "id",
			title : "数据集id",
			width : "50px"
		}, {
			field : "publishTime",
			title : "创建时间",
			width : "200px"
		}, {
			field : "dbName",
			title : "数据集名称",
			width : "200px"
		}, {                             
			field : "chName",
			title : "中文名称",
			width : "200px"
		},{                            
			field : "datasetTypeName",
			title : "数据集类型",
			width : "200px"
		},{
			field : "description",
			title : "描述信息",
			width : "200px"
		}],
		

		onLoadSuccess: function(data) { 
			if ((data.rows[0]!=null)&&(vm.isFirstPage))
				vm.selectedDbinfoId = data.rows[0].id;
			getDbinfoncGrid();
			$(function () {
				 $('#dbinfoTab a:first').tab('show')
			});
			return false;
		}, 
		onClickRow: function(item, $element) { // 单击每一行
			vm.selectedDbinfoId = item.id;
			getDbinfoncGrid();
			$(function () {
				 $('#dbinfoTab a:first').tab('show')
			});
			return false;
		},                                                                     
		
		onPageChange: function(pageNo, size) {
			if(pageNo != 1) {
				vm.isFirstPage = false;
			} else {
				vm.isFirstPage = true;
			}
		},
		singleSelect:  true// 单选形式
	})
};
function setFristSelected(value, row, index) {
	if(index == 0 && vm.isFirstPage) {
		return {
			checked: true
		}
	}
}
function initDbinfoncGrid() {
    $('#dataGrid_dbinfonc').bootstrapTableEx({            //equipment 
	    url : '../../sys/dbinfonc/list?_' + $.now(),      //equipment
	    height : $(window).height() / 2 - 54,           //54
	    queryParams : function(params) {
		params.dbinfoId = vm.selectedDbinfoId;		 
		return params;
	    },
	    columns : [ {
		    checkbox : true,
		    formatter: setFristSelected
	    }, {
		   field : "name",
		   title : "数据表名称",               
		   width : "200px"
	    }, {
		   field : "count",                 
		   title : "数据量",                     
		   width : "200px",
		   formatter: function(value, row, index) {	   			   	   
			   return[				   
				  '<label class="timer" id="count-number" data-from="0" data-to='+value+' data-speed="1000"></label>'				 		   
				   ]			   
		   }		   		 			   
	    }, 
	    //加入状态量
	       {
			field : "statusName",
		    title : "状态",               
			width : "200px"
		}, {
		   field : "sendReceive",                 
		   title : "数据接收开关",                     
		   width : "200px",
		   align : 'center',
		   events : sendReceiveEvents,
		   formatter : sendReceiveFormatter
		}, {
            field: 'operate',
            title: '操作',
            align: 'center',
            width : "200px",
            events: operateEvents,
            formatter: operateFormatter
            }
		],
		onLoadSuccess: function(data) { 
			if ((data.rows[0]!=null)&&(vm.isFirstPage)){
				vm.selectedTableinfoId = data.rows[0].tableInfoID;
				getTableStructure();				
			}
		   $('.timer').each(count);
			return false;
		}, 
		onClickRow: function(item, $element) { // 单击每一行
			vm.selectedTableinfoId = item.tableInfoID;
			//getTableStructure();
			return false;
		},
		onPageChange: function(pageNo, size) {
			if(pageNo != 1) {
				vm.isFirstPage = false;
			} else {
				vm.isFirstPage = true;
			}
		},
		singleSelect:  true// 单选形式
    })
}
function sendReceiveFormatter(value, row, index) {
	var isRecevie = row.isRecevie;
	if(isRecevie == 1){
		return [
			'<button type="button" class="sendReceive btn btn-info  btn-sm" style="margin-right:15px;">开始接收</button>',
		].join('');
	}
	else{
		return [
			'<button type="button" class="sendReceive btn btn-info btn-sm" style="margin-right:15px;">关闭接收</button>',
		].join('');
	}
}
//向DBproxy发送接收数据任务
window.sendReceiveEvents = {
        'click .sendReceive': function (e, value, row, index) {
            $.post('../../sys/dbinfonc/sendreceive',
            		{
            	tableInfoId : row.tableInfoID,
            	tableName : row.name
            	},
            	function(row){
                    if(row.isRecevie == 1){
                    	row.isRecevie = 0;
                    }
                    else{
                    	row.isRecevie = 1;
                    }
                    $('#dataGrid_dbinfonc').bootstrapTable('refresh',{pageNumber:1});
            	});
     }
};

function operateFormatter(value, row, index) {
    return [
    '<button id="left" type="button" class="RoleOfedit btn btn-primary  btn-sm" style="margin-right:15px;">编辑</button>',

    '<button id="right" type="button" class="RoleOfdelete btn btn-primary  btn-sm" style="margin-right:15px;">删除</button>'
    ].join('');
    }

window.operateEvents = {
      'click .RoleOfedit': function (e, value, row, index) {
    	  	var tId = row.tableInfoID;
        	var ck = $('#dbinfo').bootstrapTable('getSelections');
        	//var tk = $('#dataGrid_dbinfonc').bootstrapTable('getSelections');	
			window.location.href = "edit_table.html?dbinfoID=" + ck[0].id + "&dbinfoName=" + encodeURI(encodeURI(ck[0].chName) + "&dataGrid_dbinfoncID=" + tId + "&btNew=1");
    	
    	
      },
     'click .RoleOfdelete': function (e, value, row, index)  {
	
    	 var param = $.makeArray(row.tableInfoID);
    	 
    	 $.RemoveForm({
				url : '../../sys/dbinfonc/remove?_' + $.now(),         
				param : param,
				success : function(data) {
					$('#dataGrid_dbinfonc').bootstrapTable('refresh',{pageNumber:1});
				}
			});	   	 
  }
}; 

$.fn.countTo = function(options) {
    options = options || {};
    return $(this).each(function() {
        var settings = $.extend({}, $.fn.countTo.defaults, {
            from: $(this).data('from'),
            to: $(this).data('to'),
            speed: $(this).data('speed'),
            refreshInterval: $(this).data('refresh-interval'),
            decimals: $(this).data('decimals')
        }, options);                    
        var loops = Math.ceil(settings.speed / settings.refreshInterval),
            increment = (settings.to - settings.from) / loops;                      
        var self = this,
            $self = $(this),
            loopCount = 0,
            value = settings.from,
            data = $self.data('countTo') || {};
        $self.data('countTo', data);
        if(data.interval) {
            clearInterval(data.interval);
        }
        data.interval = setInterval(updateTimer, settings.refreshInterval);
        render(value);
        function updateTimer() {
            value += increment;
            loopCount++;
            render(value);
            if(typeof(settings.onUpdate) == 'function') {
                settings.onUpdate.call(self, value);
            }
            if(loopCount >= loops) {
                $self.removeData('countTo');
                clearInterval(data.interval);
                value = settings.to;
                if(typeof(settings.onComplete) == 'function') {
                    settings.onComplete.call(self, value);
                }
            }
        }
        function render(value) {
            var formattedValue = settings.formatter.call(self, value, settings);
            $self.html(formattedValue);
        }
    });
};

$.fn.countTo.defaults = {
    from: 0, 
    to: 0, 
    speed: 1000, 
    refreshInterval: 100, 
    decimals: 0, 
    formatter: formatter, 
    onUpdate: null, 
    onComplete: null 
};

function formatter(value, settings) {
    return value.toFixed(settings.decimals);
}

$('#count-number').data('countToOptions', {
    formatter: function(value, options) {
        return value.toFixed(options.decimals).replace(/\B(?=(?:\d{3})+(?!\d))/g, ',');
    }
});

function count(options) {
    var $this = $(this);
    options = $.extend({}, options || {}, $this.data('countToOptions') || {});
    $this.countTo(options);
} 

/*初始化表结构表 zhangk 2018年5月14日*/
function inittablestructureGrid() {
    $('#dataGrid_tablestructure').bootstrapTableEx({
	    queryParams : function(params) {
			params.tableInfoId = vm.selectedTableinfoId;
			return params;
		    },
	    columns : [ {
			checkbox : true,
			formatter: setFristSelected
		}, {
		   field : "name",
		   title : "字段名称",               
		   width : "200px"
	    }, {
		   field : "fieldType",                 
		   title : "字段类型",                     
		   width : "200px"
	    }, {
	    	field : "defaultValue",                 
			title : "默认值",                     
			width : "200px"
		}, {
			field : "chName",                 
			title : "字段中文名",                     
			width : "200px"
		}, {
			field : "length",                 
			title : "字段长度",                     
			width : "200px"
		}, {
			field : "isNullName",                 
			title : "是否可以为空",                     
			width : "200px"
		}, {
			field : "isKeyName",                 
			title : "是否为主键",                     
			width : "200px"
		}],
		onPageChange: function(pageNo, size) {
			if(pageNo != 1) {
				vm.isFirstPage = false;
			} else {
				vm.isFirstPage = true;
			}
		},
		singleSelect:  true// 单选形式
    })
}




function getDbinfoncGrid() {
  var opt = {
	  url : '../../sys/dbinfonc/list?_' + $.now(),
	  queryParams : function(params) {
		  params.dbinfoId = vm.selectedDbinfoId;
		  return params;
	  }
  }
  $('#dataGrid_dbinfonc').bootstrapTable("refresh", opt);
} 

/*查询表结构 zhangk 2018年5月14日*/
function getTableStructure() {
	var opt = {
		url : '../../sys/tablestructure/list?_' + $.now(),
		queryParams : function(params) {
			params.tableInfoId = vm.selectedTableinfoId;
		  return params;
		}
	 }
	$('#dataGrid_tablestructure').bootstrapTable('refresh', opt);
}

var setting = {
		data : {
			simpleData : {
				enable : true,
				idKey : "orgId",
				pIdKey : "parentId",
				rootPId : "0"
			},
			key : {
				url : "nourl"
			}
		},
		callback : {
			onClick : function(event, treeId, treeNode) {
				vm.parentId= treeNode.orgId;
				vm.isFirstPage = true;
				vm.load();
			}
		}
		
	};
var ztree;

var vm = new Vue({
	el : '#dpLTE',
	data : {
		keyword : null,
		selectedDbinfoId: null,
		selectedTableinfoId: null,
		isFirstPage: true, // 是第一页时默认选中第一项
		
		parentId : '0', 
	},
	methods : {
		load : function() {
			$('#dbinfo').bootstrapTable('refresh',{pageNumber:1});			
		},
		tablestructure_load : function() {
			$('#dataGrid_tablestructure').bootstrapTable('refresh',{pageNumber:1});
			
		},
		getOrg : function(parentId) {
			$.get('../../sys/org/list', {orgCode: parentId},function(r) {
				ztree = $.fn.zTree.init($("#orgTree"), setting, r);
				ztree.expandAll(true);
			})
		},		
		
		save : function() {
			dialogOpen({
				title : '新增数据集',
				url : 'base/dbinfo/add.html?_' + $.now(),
				width : '600px',
				height : '350px',
				scroll : true,
				success : function(iframeId) {
					top.frames[iframeId].vm.dbinfo.orgId = vm.parentId;
				},
				
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit : function() {
			var ck = $('#dbinfo').bootstrapTable('getSelections');
			if (checkedRow(ck)) {
				dialogOpen({
					title : '编辑数据集',
					url : 'base/dbinfo/edit.html?_' + $.now(),        
					width : '600px',
					height : '350px',
					scroll : true,
					success : function(iframeId) {
						top.frames[iframeId].vm.dbinfo = ck[0];        
						top.frames[iframeId].vm.setForm();
					},
					yes : function(iframeId) {
						top.frames[iframeId].vm.acceptClick();
					},
				});
			}
		},
		remove : function() {			
			var ck = $('#dbinfo').bootstrapTable('getSelections'), ids = [];
			if (checkedArray(ck)) {
				$.each(ck, function(idx, item) {
					ids[idx] = item.id;
					console.log("ids",ids);
				});
				$.RemoveForm({
					url : '../../sys/dbinfo/remove?_' + $.now(),         
					param : ids,
					success : function(data) {
						vm.load();
					}
				});
			}
		},
		
		
		
		create : function() {
			var ck = $('#dbinfo').bootstrapTable('getSelections'); 
			window.location.href = "edit_table.html?dbinfoID=" + ck[0].id + "&dbinfoName=" + encodeURI(encodeURI(ck[0].chName) + "&btNew=0");
		}
	},
	created : function() {
		this.getOrg(this.orgId); 
	}		
})