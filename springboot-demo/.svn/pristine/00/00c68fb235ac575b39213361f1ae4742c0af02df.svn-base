
/**
  定义一个星星的helper，命名rating
 */
(function (global) {
	Handlebars.registerHelper('rating', function(num, max) {
	  var html = '',
	  	  i,
	  	  len;

	  for(i = 0, len = num; i < len; i++) {
		  html += '<i class="glyphicon glyphicon-star" style="color: #EB6D48"></i> ';
	  }
	  while (max - num > 0) {
		  html += '<i class="glyphicon glyphicon-star" style="color: #CCC"></i> ';
		  max--;
	  }

	  return new Handlebars.SafeString(html);
	});
	
/**
 * 定义一个递增排序的helper，命名odering
 */
	Handlebars.registerHelper('ordering', function(index){
		return index+1;
	});
	
	//时间戳转换成 时间格式
	Handlebars.registerHelper('timesToDate', function(times){
		var date= new Date(times);
		var str=dataFrom(date);
		return str;
	});
	
	//日期转行为 yyyy-mm-dd hh-DD-ss
	function dataFrom(date){
		var year=date.getFullYear();
		var moth=date.getMonth()+1;
		if(moth<10){
			moth="0"+moth;
		}
		var day =date.getDate();
		if(day<10){
			day="0"+day;
		}
		var h=date.getHours();
		if(h<10){
			h="0"+h;
		}
		var s= date.getSeconds();
		if(s<10){
			s="0"+s;
		}
		var D=date.getMinutes();
		if(D<10){
			D="0"+D;
		}
		return  year+"-"+moth+"-"+day+" "+h+":"+D+":"+s;
		
	}
	
	//返回奇偶行
	Handlebars.registerHelper('separate', function(index){
		if(index%2==1){
			return "odd";
		}
		else{
			return "even";
		}
	});
	/**
	 * 定义一个控制select下的option 控制那个可以选中
	 */
    Handlebars.registerHelper('ifselect', function(conditional, options) {
        if(conditional==options.hash.value) {
            return options.fn({selected:"selected"});
        } else {
            return options.inverse(this);
        }
    });
    /**
	 * 根据状态编码返回状态信息
	 */
    Handlebars.registerHelper('codeToString', function(code) {
    	var html="";
    	if(code==0){
    		html="未开始";
    	}
    	else if(code==1){
    		html="进行中";
    	}
    	else if(code==2){
    		html="已完成";
    	}
    	else{
    		html="未开始";
    	}
    	return new Handlebars.SafeString(html);
    });	
    /**
	 * 字符串转对象取值并返回
	 */
    Handlebars.registerHelper('toObject', function(str,index,name) {
    	var data=JSON.parse(str);
    	if(data instanceof Array ){
    		return new Handlebars.SafeString(data[index][name]);
    	}
    	else
    	{
    		return new Handlebars.SafeString(data[name]);
    	}
    });	
    
    /**
	 * 获取数据中指定索引中指定列的名字
	 * [{name:'xiaoming',age:12},{name:'xiaoming',age:12}]
	 * 	 {{#toObject list 0 'name'}}  {{/toObject}}
	 * 返回结果为  xiaoming
	 * */
    Handlebars.registerHelper('getArrayProperty', function(str,index,name) {
    	//console.log(str,index,name);
    	if(str instanceof Array ){
    		if(str.length>0){
    			return new Handlebars.SafeString(str[index][name]);
    		}
    		else{
    			return new Handlebars.SafeString("");
    		}
    	}
    	else
    	{
    		return new Handlebars.SafeString("");
    	}
    });	
    
    /**
	 * 返回数组长度
	 */
    Handlebars.registerHelper('getArrayLength', function(str) {
    	return new Handlebars.SafeString(str.length);
    });	
    
    /**
	 * 秒转换成00:00:00
	 */
    Handlebars.registerHelper('getTimeType', function(data) {
    	
    	if(!isNaN(data)){
    		var distanceTime=parseInt(data);
    		var hour=Math.floor(distanceTime/3600);
    		distanceTime-=hour*3600;
    		var minute=Math.floor(distanceTime/60);
    		distanceTime -=minute*60;
			var second=Math.floor(distanceTime);
    		
			if(hour<10){
				hour = "0"+hour;
			}
			if(minute<10){
				minute = "0"+minute;
			}
			if(second<10){
				second = "0"+second;
			}	
        	return new Handlebars.SafeString(hour+":"+minute+":"+second);
    	}
    	return new Handlebars.SafeString("");
    });	
    
    /**
	 * 生成二级菜单html
	 */
   Handlebars.registerHelper('createLevelHtml', function(data) {
   		if(data)
   		{
   			var html='';
   			var length=data.length;
   			var total=0;
   			
   			for(var i=0;i<length;i++){
   				total+=data[i].name.length;
   			}
   			var widthSize=length*12+total*20;
   			//console.log("菜单长度:"+length,"文字总数："+total,widthSize);
   			if(widthSize<=1000){
   				for(var i=0;i<length;i++){
   					var item=data[i]
   					html+='<span class="fl chanLevel" title="'+item.name+'" data-chan-level="'+item.id+'" >'+item.name+'</span>'
   	   			}
   				return new Handlebars.SafeString(html);
   			}
   			else{
   				for(var i=0;i<length;i++){
   					var item=data[i]
   					html+='<span class="fl chanLevel" title="'+item.name+'" style="width:57px;" data-chan-level="'+item.id+'" >'+item.name+'</span>'
   	   			}
   				return new Handlebars.SafeString(html);   				
   			}
   			
   			
   		}
   });

    Handlebars.registerHelper("compare",function(v1,v2,options){
        if(v1==v2){
            return options.fn(this);
        }else{
            return options.inverse(this);
        }
    });

    Handlebars.registerHelper("compareGtLt",function(v1,v2,options){
        if(v1.length>v2){
            return options.fn(this);
        }else{
            return options.inverse(this);
        }
    });
	global.HBUtil = {};
	
/**
* 定义一个计算事件已发生时间的方法，命名timing
*/
		global.HBUtil.timer = function(){
			var html="";
				nowTime=new Date().getTime();
				
			   
				happenTime=new Date(HBUtil.occurTime.replace(/-/g,"/")).getTime();
				 
			var	distanceTime=nowTime-happenTime;
			var day=Math.floor(distanceTime/86400000);
			distanceTime-=day*86400000;
			var hour=Math.floor(distanceTime/3600000);
			distanceTime-=hour*3600000;
			var minute=Math.floor(distanceTime/60000);
			distanceTime -=minute*60000;
			var second=Math.floor(distanceTime/1000);
			distanceTime -=second*1000;
			if(day>0&&day<10){
				day = "0"+day;
			}
			if(hour<10){
				hour = "0"+hour;
			}
			if(minute<10){
				minute = "0"+minute;
			}
			if(second<10){
				second = "0"+second;
			}	
			if(day ==0){
				return hour+"小时"+minute+"分"+second+"秒";
				}
			return day+"天"+hour+"小时"+minute+"分"+second+"秒";
			};
	
	/**
	 * 初始化页面
	 * @param id 当前三级菜单的id
	 */
	global.HBUtil.initPage = function (id) {
		//记录三级菜单id, 用于比较
		this.currentId = id;
		
		//设置左侧导航的行为
		$('#left_aside > ul').delegate('[data-menu-id]', 'click', function () {
			var $this = $(this);
			if ($this.data('menuId') == global.HBUtil.currentId) {
				//当前激活的菜单就是该项
				$('#left_panel').toggleClass('panel-close'); //隐藏菜单
				return false;
			} else {
				//当前激活的菜单不是该项
				$FN.setPagePath($this.data('menuUrl'));
				return false;
			}
        });
		
		this.registNavListener('#left_panel_inner');
		
		//初始化滚动条
		$('#left_panel_inner').perfectScrollbar();
	};
	
	/**
	 * 加载页面内容
	 * @param viewUrl 加载视图模板的url
	 * @param rest 地址和对应属性的映射
	 */
	global.HBUtil.loadContent = function (viewUrl, apiMapping, selector) {
		//页面卸载前触发hb.unload事件
		var _selector = selector || '#left_panel_inner';
        $(_selector).triggerHandler('hb.unload');
        //G.showAjaxLoading("数据加载中，请稍等...");
        //$(_selector).empty().append($("<div style='width:100%;height:100%;text-align: center;background-color: #fff;'><img src='"+$CONFIG['contextpath']+"/resources/minton/images/loader.gif'/><div>"))
		if (!!apiMapping) {
           
            var defArr = [], 
                keys = []; 
            for (var attr in apiMapping) {

            	if (apiMapping.hasOwnProperty(attr) && /(\/\w+)+/.test(apiMapping[attr])) {
            		keys.push(attr);
            	}
            }

            defArr.push($.get(viewUrl));

            keys.forEach(function (k) {
            	
            	defArr.push($.get(apiMapping[k]));
            });

            $.when.apply(null, defArr)
                .done(function (results) {
                		
                    var context=apiMapping,view=null;
                    if( typeof results==="string"){
                        view=results;
                    }
                    else{
                        var result = Array.prototype.slice.call(arguments, 0);

                        var tem = result.shift(0);
                        view=tem[0];
                        result.forEach(function(r, i) {
                            context[keys[i]] = r[0];
                        });
                    }

                    var compiled = Handlebars.compile(view);

                    var $dom = $(compiled(context));
                    //触发加载完成事件
                    $(_selector).empty().append($dom).triggerHandler('hb.loaded');
                    //G.doneAjaxLoading();
                })
                .fail(function (data) {
                });
        } else {
            $.get(viewUrl).done(function (html) {

            	var $dom = $(html);
            	//触发加载完成事件
            	$(_selector).empty().append($dom).triggerHandler('hb.loaded');
               // G.doneAjaxLoading();
            }).fail(function (data) {
            })
        }
    };
    
    /**
     * 注册页面导航监听
     */
    global.HBUtil.registNavListener = function () {
    	$('#left_panel_inner').delegate('[role=hblink]', 'click', function (e) {
            e.preventDefault();
            e.stopPropagation();
            var $this = $(this);
            
            var viewUrl = $CONFIG['contextpath'] + '/resources/Handlebars/views/' + $this.data('hbView') + '.html',
            	apis = $this.data('hbApi');
            if (!!apis) {
            	for (var p in apis) {
            		if (apis.hasOwnProperty(p)) {
            			apis[p] = $CONFIG['contextpath'] + apis[p];
            		}
            	}
            } else {
            	apis = null;
            }
            HBUtil.loadContent(viewUrl, apis);
        });
    };
    
    /**
     * 销毁页面的导航监听
     */
    global.HBUtil.destroyNavListener = function () {
    	$('#left_panel_inner').undelegate('[role=hblink]', 'click')
    };
    
    /**
     * 销毁页面
     */
    global.HBUtil.destroyPage = function () {
    	this.destroyNavListener('#left_panel_inner');
    	$('#left_aside > ul').undelegate();
    	try {
    		$('#left_panel_inner').perfectScrollbar('distroy');
    	} catch (e) {
    		// console.log(e);
    	}
    	$('#left_panel_inner').triggerHandler('hb.unload');
    	$('#left_panel_inner').off();
    	delete this.currentId;
    };
    
    
    /**
     * datetimePickerInit 初始化
     */
    global.HBUtil.datetimePickerInit=function (elementDom) {
            $(elementDom).each(function(){
                var $this = $(this);
                var dataName;
                $this.datetimepicker();
                
                for(dataName in $this.data()) {
                    if (!dataName.indexOf('dtp')) {
                        var dtpOptName = dataName.substr('dtp'.length);
                        dtpOptName = dtpOptName[0].toLowerCase() + dtpOptName.substr(1);
                        try {
                            var _opt = {};
                            _opt[dtpOptName] = (function () {
                                try {
                                    return eval($this.data(dataName));
                                } catch (e) {}
                            })() || $this.data(dataName);
                            $this.data('DateTimePicker').options(_opt);
                        } catch (e) {
                            throw e;
                        }
                    }
                }
                
                // datetimepicker在 置空后 && 通过其他校验规则 时移除校验通过提示
                $this.on('blur', function () {
                    var $form = $($CONFIG['page_form']).data('formValidation')
                    var $this = $(this);
                    if(!$this.val() && $form.isValidField($this)) {
                        $form.resetField($this);
                    }
                });
            });
        };
        global.HBUtil.tagsinputInit=function (elementDom) {
            $(elementDom).each(function (e) {
                var tagsinputAddclass = $(this).data('tagsinputAddclass');
                var tagsinputInitobject = $(this).data('tagsinputInitobject');
                var tagsinputItemtype = $(this).data('tagsinputItemtype');
                if (tagsinputItemtype === 'object') {
                    $(this).tagsinput({
                        'itemValue': 'value',
                        'itemText': 'text'
                    });
                } else {
                    $(this).tagsinput();
                }
                if (!!tagsinputAddclass) {
                    $(this).nextAll('.bootstrap-tagsinput').addClass(tagsinputAddclass);
                }
                // FIX PLACEHOLDER BUG
                $(this).on('change', function (e) {
                    var $originalInput = $(this);
                    var $tagsinput = $originalInput.nextAll('.bootstrap-tagsinput').children('input');
                    if(!$originalInput.val()) {
                        // 当前无值, 显示placeholder
                        $tagsinput.attr('placeholder', $originalInput.attr('placeholder') || '');
                    } else {
                        // 当前有值, 隐藏placeholder
                        $tagsinput.attr('placeholder', '');
                    }
                });
                // SET INIT VALUE
                if (!!tagsinputInitobject && tagsinputItemtype === 'object') {
                    var initObjs = [];
                    try {
                        initObjs = eval(tagsinputInitobject);
                    } catch (e) {}
                    for (var i = 0; i < initObjs.length; i++) {
                        if (!!initObjs[i]['value']) {
                            $(this).tagsinput('add', initObjs[i]);
                        }
                    }
                }
                // PLAY WITH formvalidation
                $(this).on('change', function (e) {
                    try {
                        $($CONFIG['page_form']).formValidation('revalidateField', $(this).attr('name') || $(this).attr('id'));
                    } catch (e) {}
                });
            });
        };   
        
     /**
	 * 初始化弹出树
	 */
   global.HBUtil.jsTree=function (elementDom) {
    var $jstreeInput = $(elementDom);

    if (!$jstreeInput.length) {
        return;
    }

    $jstreeInput.each(function (e) {
        var $originalInput = $(this);
        var $targetInput = $originalInput;

        var jstreeMultiselect = !!$originalInput.data('jstreeMultiselect') ? true : false;
        var jstreeSelectleafonly = !!$originalInput.data('jstreeSelectleafonly') ? true : false;
        var jstreeUrl = $originalInput.data('jstreeUrl');
        var jstreeTitle = $originalInput.data('jstreeTitle');
        var jstreeMaxdeep = $originalInput.data('jstreeMaxdeep');
        var jstreeFiltercode = $originalInput.data('jstreeFiltercode');

        if (!jstreeUrl) {
            throw('弹出树的URL参数未设置!');
        }
        
        if (!jstreeMaxdeep || !$.isNumeric(jstreeMaxdeep) || parseInt(jstreeMaxdeep) <= 0) {
            jstreeMaxdeep = 0;
        } else {
            jstreeMaxdeep = parseInt(jstreeMaxdeep);
        }

        // 从隐藏区域复制一份modal模板
        //$originalInput.after($($CONFIG['jstree_modal_template']).children(':not(style)').clone());
        $("body").append($($CONFIG['jstree_modal_template']).children(':not(style)').clone().attr("id","fjz_orgId"));
       
        //创建树
        //var $modalDom = $originalInput.nextAll('[role~=treeModal]');
        var $modalDom=$("#fjz_orgId");
        if (!$modalDom.length) {
            throw('未加载弹出树的modal模板!');
        }

        var $jstreeDom = $modalDom.find('[role=tree]');
        var $refreshBtn = $modalDom.find('[role~=treeRefresh]');
        var $expandBtn = $modalDom.find('[role~=treeExpand]');
        var $saveBtn = $modalDom.find('[role~=treeSave]');
        var $titleDom = $modalDom.find('.modal-title');
        var $cleanBtn = $originalInput.parent().find('[role~=treeClean]');
        var $treeSearchInput = $modalDom.find('[role~=treeSearchInput]');
        
        /*判断是不是需要加载 标签*/
        var isTagsinput = false;
        isTagsinput = $originalInput.is($("[data-role~=tagsinput]"));
        var isTagsinputItemTypeObj = ($originalInput.data('tagsinputItemtype') === 'object');

        $titleDom.html(jstreeTitle || '&nbsp');

        if (!!$cleanBtn.length) {
            $cleanBtn.on('click', function (e) {
                e.preventDefault();
                e.stopPropagation();
                var _originalInput = $originalInput;
                if (isTagsinput) {
                    _originalInput.tagsinput('removeAll');
                } else {
                    _originalInput.val('');
                }
                _originalInput = null;
            });
        }
        if (isTagsinput) {
            $targetInput = $originalInput.nextAll('.bootstrap-tagsinput').children('input');
        }
        $targetInput.on('click focus', function (e) {
            if (e.type === 'click') {
                e.preventDefault();
                e.stopPropagation();
                return;
            }
            $(this).blur();
            var _modalDom = $modalDom;
            _modalDom.modal();
            _modalDom = null;
        });  
        (function () {
            var _modalDom = $modalDom;

            _modalDom.on('hide.bs.modal.self', function (e) {
                var _saveBtn = $saveBtn;
                var _refreshBtn= $refreshBtn;
                var _expandBtn = $expandBtn;
                try {
                    _saveBtn.off('click');
                    _refreshBtn.off('click');
                    _expandBtn.off('click');
                } catch (e) {
                }
                _saveBtn = null;
            });
            _modalDom.on('show.bs.modal.self', function (e) {
                var _jstreeDom = $jstreeDom;
                var _jstree = _jstreeDom.jstree(true); // get an existing instance (will not create new instance)
                var _saveBtn = $saveBtn;
                var _refreshBtn= $refreshBtn;
                var _expandBtn = $expandBtn;
                var _originalInput = $originalInput;
                var _treeSearchInput = $treeSearchInput;
                var to = false; //for search plugin

                if (!_jstree) {
                    _jstreeDom.jstree({
                        'core': {
                            'data': {
                                'url': (jstreeUrl.toLowerCase().search('http://') && jstreeUrl.toLowerCase().search('https://')) ? $CONFIG['contextpath'] + jstreeUrl : jstreeUrl,
                                'cache': false,
                                'data': function (node) {
                                	return '-1' === node.id ? { 'pid': node.id,'filterCode':jstreeFiltercode}:{ 'pid': node.id};
                                },
                                'success': function (data, textStatus, jqXHR) {
                                	var originalVal = $originalInput.val();
                                	
                                    if (!!originalVal) {
                                        var _data = [];
                                        var checkedIds = [];
                                        var vals = originalVal.trim().split(',');
                                        for (var i = 0; i < vals.length; i++) {
                                            checkedIds.push(vals[i].trim());
                                        }
                                        $.each(data, function (i, item) {
                                            if(checkedIds.indexOf(item.id) !== -1) {
                                                item.state['checked'] = true;
                                            }
                                            _data.push(item);
                                        });
                                        data = _data;
                                    }
                                    
                                    try {
                                        data.sort(function(a, b) {
                                            return a.seq - b.seq;
                                        });
                                    } catch (e) {}

                                    if (data.length > 0 && jstreeMaxdeep > 0) {
                                        try {
                                            var _tree = $jstreeDom.jstree(true);
                                            // 当前正在展开的节点深度
                                            if (_tree.get_node(data[0].parent).parents.length + 1 >= jstreeMaxdeep) {
                                                for (var i = data.length - 1; i >= 0; i--) {
                                                    // 设置节点不可展开
                                                    data[i].children = false;
                                                }
                                            }
                                        } catch (e) {}
                                    }
                                }
                            },
                            'multiple': false, // 不可多选节点
                            'check_callback': true,
                            'themes': {
                                'responsive': true,
                                'dots': true,
                                'stripes': true // 条纹
                            }
                        },
                        'types': {
                            'default': {
                                'icon': 'glyphicon glyphicon-folder-close'
                            },
                            '#': {
                                'valid_children': ['root']
                            },
                            'file': {
                                'valid_children': [],
                                'icon': 'glyphicon glyphicon-file'
                            }
                        },
                        'checkbox': {
                            'keep_selected_style': false, // 如果使用checkbox插件，这2个选项应设为false
                            'tie_selection': false,
                            'three_state': false,
                            'whole_node': false,
                            'cascade': 'up+down+undetermined'
                        },
                        'plugins': jstreeMultiselect ? ['checkbox', 'types', 'wholerow', 'search'] : ['types', 'wholerow', 'search']
                    });

                    _jstreeDom.on('ready.jstree.self set_state.jstree.self', function (e, data) {
                        // show dots forcibly, wholerow plugin will hide dots
                        var _jstree = data.instance;
                        if (!!_jstree.settings.core.themes.dots) {
                            _jstree.show_dots();
                        }
                    });
                    _jstreeDom.on('refresh.jstree.self', function (e, data) {
                        // clean checked plugin state
                        var _jstree = data.instance;
                        if (!!_jstree.uncheck_all) {
                            _jstree.uncheck_all();
                        }
                    });
                    if (!jstreeMultiselect) {
                        // 单选树
                        _jstreeDom.on('select_node.jstree.self', function (e, data) {
                            var _jstree = data.instance;
                            var _node = data.node;
                            if (jstreeSelectleafonly && !_jstree.is_leaf(_node)) {
                                _jstree.deselect_node(_node);
                            }
                            _jstree = null;
                            _node = null;
                        });
                    }

                    if (jstreeMultiselect && jstreeSelectleafonly) {
                        _jstreeDom.on('open_node.jstree.self load_node.jstree.self', function (e, data) {
                            var _jstree = data.instance;
                            var _allNode = _jstree.get_json('#', {
                                'flat': true,
                                'no_data': true,
                                'no_state': true
                            });
                            $.each(_allNode, function (index, obj) {
                                var _nodeDom = _jstree.get_node(obj.id, true);
                                if (obj.type !== 'file') {
                                    _nodeDom.children('.jstree-anchor').children('.jstree-checkbox').addClass('hidden');
                                }
                            });
                        });
                    }

                    _jstree = _jstreeDom.jstree(true);
                }
                
                /**
                 * 根据输入框中的当前值设置树节点的选中状态
                 */
                if (jstreeMultiselect) {
                    _jstree.uncheck_all();
                } else {
                    _jstree.deselect_all();
                }
                var originalVal = _originalInput.val();
                if (!!originalVal) {
                    var checkedIds = [];
                    var vals = originalVal.trim().split(',');
                    for (var i = 0; i < vals.length; i++) {
                        checkedIds.push(vals[i].trim());
                    }
                    if (jstreeMultiselect) {
                        _jstree.check_node(checkedIds);
                    } else {
                        _jstree.select_node(checkedIds);
                    }
                }

                _refreshBtn.on('click', function (e) {
                    var _jstreeDom = $jstreeDom;
                    var _jstree = _jstreeDom.jstree(true);
                    if (!!_jstree) {
                        _jstree.refresh(false, true);
                    }
                    _jstree = null;
                    _jstreeDom = null;
                });

                _expandBtn.on('click', function (e) {
                    var _jstreeDom = $jstreeDom;
                    var _jstree = _jstreeDom.jstree(true);
                    if (!!_jstree) {
                        _jstree.open_all();
                    }
                    _jstree = null;
                    _jstreeDom = null;
                });

                _treeSearchInput.on('keyup',function(){
                    if(to) { 
                        clearTimeout(to); 
                    }
                    var that = $(this);
                    to = setTimeout(function () {
                    	var _jstreeDom = $jstreeDom;
                        var _jstree = _jstreeDom.jstree(true);
                        
                        var _that = that;
                        var v = _that.val();
                        
                        var __refreshBtn = $refreshBtn;
                        var __expandBtn = $expandBtn;
                        if(v !==''){
                        	__refreshBtn.attr('disabled','disabled');
                        	__expandBtn.attr('disabled','disabled')
                        }else{
                        	__refreshBtn.removeAttr('disabled');
                        	__expandBtn.removeAttr('disabled');
                        }
                        if (!!_jstree) {
                            _jstree.open_all();
                        }
                        
                        _jstree.search(v,false,true);
                        
                        _that = null;
		__refreshBtn = null;
                        __expandBtn = null;
                        _jstree = null;
                        _jstreeDom = null;
                    }, 250);
                });

                _saveBtn.on('click', function () {
                    var _modalDom = $modalDom;
                    var _jstreeDom = $jstreeDom;
                    var _jstree = _jstreeDom.jstree();
                    var _originalInput = $originalInput;
                    var _treeSearchInput = $treeSearchInput;
	    var __refreshBtn = $refreshBtn;
                    var __expandBtn = $expandBtn;

                    var _checkedIds = jstreeMultiselect ? _jstree.get_checked() : _jstree.get_selected();
                    if(_checkedIds.length == 0){
                    	bootbox.alert('你没有选择任何单位');
                    }
                    var _checkedNodes = {};
                    for (var i = 0; i < _checkedIds.length; i++) {
                        var _id = _checkedIds[i];
                        _checkedNodes[_id] = _jstree.get_node(_id);
                    }

                    /**
                     * 过滤节点类型
                     */
                    var pendingDeleteId = [];
                    if (jstreeMultiselect && jstreeSelectleafonly) {
                        for (_id in _checkedNodes) {
                            if (_checkedNodes.hasOwnProperty(_id)) {
                                if (_checkedNodes[_id].type !== 'file') {
                                    pendingDeleteId.push(_id);
                                }
                            }
                        }
                    }
                    for (var i = 0; i < pendingDeleteId.length; i++) {
                        delete _checkedNodes[pendingDeleteId[i]];
                    }
                    pendingDeleteId.length = 0;
                    pendingDeleteId = null;


                    if (isTagsinput && isTagsinputItemTypeObj) {
                        // 使用了tagsinput组件 且 itemtype 为 object
                        _originalInput.tagsinput('removeAll');
                        for (_id in _checkedNodes) {
                            if (_checkedNodes.hasOwnProperty(_id)) {
                                _originalInput.tagsinput('add', {
                                    'value': _checkedNodes[_id].id,
                                    'text': _checkedNodes[_id].text
                                });
                            }
                        }
                    } else if (isTagsinput && !isTagsinputItemTypeObj) {
                        // 使用了tagsinput组件 itemtype 为 string
                        _originalInput.tagsinput('removeAll');
                        for (_id in _checkedNodes) {
                            if (_checkedNodes.hasOwnProperty(_id)) {
                                _originalInput.tagsinput('add', _id);
                            }
                        }
                    } else {
                        // 未使用tagsinput组件 
                        var _ids = [];
                        for (_id in _checkedNodes) {
                            if (_checkedNodes.hasOwnProperty(_id)) {
                                _ids.push(_id);
                            }
                        }
                        _originalInput.val(_ids.join(','));
                        _ids.length = 0;
                        _ids = null;
                    }

                    /**
                     * 触发'modalsave'事件, 监听方法的第二个参数带有此次选择的节点
                     */
                    _originalInput.triggerHandler('modalsave', _checkedNodes);
                    
	    __refreshBtn.removeAttr('disabled');
                    __expandBtn.removeAttr('disabled');
                    __refreshBtn = null;
                    __expandBtn = null;
                    
                    _modalDom.modal('hide');
                    _checkedIds = null;
                    _checkedNodes = null;
                    _modalDom = null;
                    _jstree.clear_search();
                    _jstree = null;
                    _jstreeDom = null;
                    _originalInput = null;
                    _treeSearchInput.val('');
                    _treeSearchInput = null;
                });
                _treeSearchInput = null;
                _originalInput = null;
                _jstreeDom = null;
                _saveBtn = null;
                _refreshBtn = null;
                _expandBtn = null;
            });

            _modalDom = null;
        })();
    });
};
	
/**
 * 常用表单验证
 */
global.HBUtil.RegExpObj = {
		//判断为空
		isEmpty: function(value){
			return $.trim(value)==''||typeof (value) == "undefined";
		},
	    //手机号
	    isMobile: function (str) {
	        return /^[1][345678]\d{9}$/.test(str);
	    },
	    //固定电话
	    isPhone: function (str) {
	        return /^0\d{2,3}-?\d{7,8}$/.test(str);
	    },
	    //6位验证码
	    isCode: function (str) {
	        return /^\d{6}$/.test(str);
	    },
	    //真实姓名
	    isRealName: function(str){
	    	return /^[\u4e00-\u9fa5]{2,5}$/.test(str);
	    }, 
	    //身份证
	    isIdCode: function(str){
	    	return  /^([0-9]{17}[0-9X]{1})|([0-9]{15})$/.test(str);
	    }, 
		//银行卡类型
		isCardType: function(str){
	    	return  /^[\u4e00-\u9fa5]$/.test(str);
	    },
	    //价格(两位小数)
	    isPrice: function(str){
	    	return  /^[0-9]+\.?[0-9]{0,2}$/.test(str);
	    },
	    //邮箱
	    isEemail: function (str) {
	        return /^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|com|gov|mil|org|edu|int|name|asia)$/i.test(str);
	    }
	};


})(window);




