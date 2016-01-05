$(function(){
	
	var cond={
			'name':$('#name').val()
		};
	   
	    function fnCount(rowIndex,colIndex,colDef,rowData){
		   return $('<a href="/agents/school/editschool.htm?schoolId='+rowData.id+'" class="thaw" >'+rowData.schoolname+'</a>');
	    }
		
	    function fnStatus(rowIndex,colIndex,colDef,rowData){
	    	if(rowData.status=='CREATE')
				return $("<span>创建</sapn>");
	    	else if(rowData.status == "VERIFY")
	    		return $("<span>审核</span>");
	    	else
	    		return $("<span>无</span>");
	    }
	   
	    function fnOperation(rowIndex,colIndex,colDef,rowData){
			return $('<a target="_blank" href="shopDetail.htm?id='+rowData.id+'" class="thaw" >查看</a>');
		}
	    
		/**
		 * 初始化表格所使用的参数:
		 * sUrl: 获取数据的url,
		 * columnDefs: 列定义
		 *      type: number,string 数字或者字符串，以原样输出, date 长整型日期,转换为yyyy-MM-dd的格式, boolean:布尔类型，转换为 是/否, control,callback 控件或者回调，用render属性指定回调函数
		 *      name: 要展示的属性名，如果是string, number,date,boolean 则必须指定name属性
		 *      render: 展示单元格内容的函数,如果是control或者callback类型的列，必须指定这个属性
		 *      css: 对于td 的额外css定义
		 * oRequestParam: 请求参数
		 * bPaginate: 是否需要分页栏,默认为true
		 * nPageNo: 当前页,默认为1
		 * nPageSize: 分页大小,默认为 5
		 */
		var params = {'sUrl':'/rpc/Company1688Rpc/Query1688Compny.json',
			'columnDefs':[
				{'type':'string','name':'companyName',css:'textLeft'},
				{'type':'string','name':'majorBussiness',css:'textLeft'},
				{'type':'string','name':'develPeo',css:'textLeft'},
				{'type':'callback','render':fnOperation,css:'textCenter'},
			],
			'oRequestParam':cond,
			'bPaginate':true,
			'nPageNo':1,
			'nPageSize':10
		};
		
		var tb =$('#shop_table').easygrid(params);
		
		
		
		$('.shopQuery').submit(function(){
			
			cond = {
				'shopEName':$('#shopEName').val(),
				'userName':$('#userId').val(),
				'id':$('#id').val(),
				'category':$('#category').val(),
				'companyName':$('#companyName').val(),
				'isCompanyEName':$('#isCompanyEName').val(),
				'status':$('status').val(),
				'startOpenTime':$('#startOpenTime').val(),
				'endOpenTime':$('#endOpenTime').val(),
				'startCloseTime':$('#startCloseTime').val(),
				'endCloseTime':$('#endCloseTime').val(),
			}
			
			tb.reload(cond,1);
			
			return false;
		});
		
		/**
		*店铺开通时间和到期时间拼接
		*/
		$('#shopClick').click(function(){
			/**
			*拼接开通时间起始
			*/
			var x = $('#startOpenTime_date').val()
			var y = $('#startOpenTime_time').val()
			var startOpenTime = ""
			if(x !="" && y != ""){
			 startOpenTime = x + " " + y;
			}else if(x != "" && y == ""){
			 startOpenTime = x +" 00:00:00";
			}
			$('#startOpenTime').attr("value",startOpenTime)
			/**
			*拼接开通时间结尾
			*/
			var a = $('#endOpenTime_date').val()
			var b = $('#endOpenTime_time').val()
			var endOpenTime = ""
			if(a != "" && b != ""){
				endOpenTime = a + " " + b;
			}else if(a != "" && b == ""){
				endOpenTime = a+" 23:59:59";
			}
			$('#endOpenTime').attr("value",endOpenTime)
			/**
			*拼接到期时间起始
			*/
			var c = $('#startCloseTime_date').val()
			var d = $('#startCloseTime_time').val()
			var startCloseTime = ""
			if(c != "" && b != ""){
				startCloseTime = c + " " + d;
			}else if(c != "" && b == ""){
				startCloseTime = c+" 00:00:00";
			}
			$('#startCloseTime').attr("value",startCloseTime)
			/**
			*拼接到期时间结尾时间
			*/
			var e = $('#endCloseTime_date').val()
			var f = $('#endCloseTime_time').val()
			var endCloseTime = ""
			if(e != "" && f != ""){
				endCloseTime = e + " " + f;
			}else if(e != "" && f==""){
				endCloseTime = e+" 23:59:59";
			}
			$('#endCloseTime').attr("value",endCloseTime)
			/**
			 * 校验公司名称
			 */
				var name = $('#companyName').val()
				if(name != ""){
					var re = /[^u4e00-u9fa5]/;
					if(re.test(name)){
						$('#isCompanyEName').attr("value","no")
					}else{
						$('#isCompanyEName').attr("value","yes")
					}
				}
			
		});
});
