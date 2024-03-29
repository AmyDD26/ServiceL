﻿$.SaveForm = function(options) {
	var defaults = {
		url : "",
		param : {},
		type : "post",
		dataType : "json",
		contentType : 'application/json',
		success : null,
		close : true
	};
	var options = $.extend(defaults, options);
	dialogLoading(true);
	window.setTimeout(function() {
		$.ajax({
			url : options.url,
			data : JSON.stringify(options.param),
			type : options.type,
			dataType : options.dataType,
			contentType : options.contentType,
			success : function(data) {
				if (data.code == '500') {
					dialogAlert(data.msg, 'error');
				} else if (data.code == '0') {
					options.success(data);
					dialogMsg(data.msg, 'success');
					if (options.close == true) {
						dialogClose();
					}
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				dialogLoading(false);
                if(textStatus=="parsererror"){
                    top.layer.open({
                        title: '系统提示',
                        area: '338px',
                        icon: 3,
                        move: false,
                        anim: -1,
                        isOutAnim: false,
                        content: '注：登录超时,请稍后重新登录.',
                        btn: ['立即退出'],
                        btnAlign: 'c',
                        yes: function(){
                            toUrl('sys/logout');
                        }
                    });
                    setTimeout(function(){
                        toUrl("sys/logout");
                    }, 2000);
                } else if(textStatus=="error"){
                    dialogMsg("请求超时，请稍候重试...", "error");
                } else {
                    dialogMsg(errorThrown, 'error');
				}
			},
			beforeSend : function() {
				dialogLoading(true);
			},
			complete : function() {
				dialogLoading(false);
			}
		});
	}, 500);
}

$.RemoveForm = function(options) {
	var defaults = {
		msg : "注：您确定要删除吗？该操作将无法恢复",
		url : "",
		param : [],
		type : "post",
		dataType : "json",
		contentType : 'application/json',
		success : null
	};
	var options = $.extend(defaults, options);
	dialogConfirm(options.msg, function() {
		dialogLoading(true);
		window.setTimeout(function() {
			var postdata = options.param;
			$.ajax({
				url : options.url,
				data : JSON.stringify(postdata),
				type : options.type,
				dataType : options.dataType,
				contentType : options.contentType,
				success : function(data) {
					if (data.code == '500') {
						dialogAlert(data.msg, 'error');
					} else if (data.code == '0') {
						dialogMsg(data.msg, 'success');
					
						
						console.log("data::::",data);
						options.success(data);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
                    dialogLoading(false);
                    if(textStatus=="parsererror"){
                        top.layer.open({
                            title: '系统提示',
                            area: '338px',
                            icon: 3,
                            move: false,
                            anim: -1,
                            isOutAnim: false,
                            content: '注：登录超时,请稍后重新登录.',
                            btn: ['立即退出'],
                            btnAlign: 'c',
                            yes: function(){
                                toUrl('sys/logout');
                            }
                        });
                        setTimeout(function(){
                            toUrl("sys/logout");
                        }, 2000);
                    } else if(textStatus=="error"){
                        dialogMsg("请求超时，请稍候重试...", "error");
                    } else {
                        dialogMsg(errorThrown, 'error');
                    }
                },
				beforeSend : function() {
					dialogLoading(true);
				},
				complete : function() {
					dialogLoading(false);
				}
			});
		}, 500);
	});
}

$.SetForm = function(options) {
	var defaults = {
		url : "",
		param : [],
		type : "post",
		dataType : "json",
		contentType : 'application/json',
		success : null
	};
	var options = $.extend(defaults, options);
	$.ajax({
		url : options.url,
		data : JSON.stringify(options.param),
		type : options.type,
		dataType : options.dataType,
		contentType : options.contentType,
		success : function(data) {
			if (data.code == '500') {
				dialogAlert(data.msg, 'error');
			} else if (data.code == '0') {
				options.success(data.rows);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
            dialogLoading(false);
            if(textStatus=="parsererror"){
                top.layer.open({
                    title: '系统提示',
                    area: '338px',
                    icon: 3,
                    move: false,
                    anim: -1,
                    isOutAnim: false,
                    content: '注：登录超时,请稍后重新登录.',
                    btn: ['立即退出'],
                    btnAlign: 'c',
                    yes: function(){
                        toUrl('sys/logout');
                    }
                });
                setTimeout(function(){
                    toUrl("sys/logout");
                }, 2000);
            } else if(textStatus=="error"){
                dialogMsg("请求超时，请稍候重试...", "error");
            } else {
                dialogMsg(errorThrown, 'error');
            }
		},
		beforeSend : function() {
			dialogLoading(true);
		},
		complete : function() {
			dialogLoading(false);
		}
	});
}

$.ConfirmForm = function(options) {
	var defaults = {
		msg : "您确定要保存当前数据项修改操作吗？",
		url : "",
		param : {},
		type : "post",
		dataType : "json",
		contentType : 'application/json',
		success : null,
		close : true
	};
	var options = $.extend(defaults, options);
	dialogConfirm(options.msg, function() {
		$.SaveForm(options);
	});
}

$.ConfirmAjax = function(options) {
	var defaults = {
		msg : "您确定要保存当前操作结果吗？",
		url : "",
		param : {},
		type : "post",
		dataType : "json",
		contentType : options.contentType,
		success : null,
		close : true
	};
	var options = $.extend(defaults, options);
	dialogConfirm(options.msg, function() {
		dialogLoading(true);
		window.setTimeout(function() {
			var postdata = options.param;
			$.ajax({
				url : options.url,
				data : JSON.stringify(postdata),
				type : options.type,
				dataType : options.dataType,
				contentType : options.contentType,
				success : function(data) {
					if (data.code == '500') {
						dialogAlert(data.msg, 'error');
					} else if (data.code == '0') {
						dialogMsg(data.msg, 'success');
						options.success(data);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
                    dialogLoading(false);
                    if(textStatus=="parsererror"){
                        top.layer.open({
                            title: '系统提示',
                            area: '338px',
                            icon: 3,
                            move: false,
                            anim: -1,
                            isOutAnim: false,
                            content: '注：登录超时,请稍后重新登录.',
                            btn: ['立即退出'],
                            btnAlign: 'c',
                            yes: function(){
                                toUrl('sys/logout');
                            }
                        });
                        setTimeout(function(){
                            toUrl("sys/logout");
                        }, 2000);
                    } else if(textStatus=="error"){
                        dialogMsg("请求超时，请稍候重试...", "error");
                    } else {
                        dialogMsg(errorThrown, 'error');
                    }
				},
				beforeSend : function() {
					dialogLoading(true);
				},
				complete : function() {
					dialogLoading(false);
				}
			});
		}, 500);
	});
}
