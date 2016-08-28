var seckill={
		URL : {
			now : function(){
				return '/maven01/seckill/time/now';
			},
			
			exposer : function(seckillId){
				return '/maven01/seckill/'+seckillId+'/exposer';
			},
			
			excution : function(seckillId,md5){
				return '/maven01/seckill/'+seckillId+'/'+md5+'/excution';
			}
		},
		
		//开始秒杀时执行操作
		handleseckill:function(seckillId,node){
			node.hide()
			     .html('<button class="btn btn-primary btn-lg" id="killbtn" >start seckill</button>');
			
			$.post(seckill.URL.exposer(seckillId),{},function(result){
				if(result && result['success']){
					var exposer=result['date'];
					if(exposer['isexport']){
						var md5=exposer['md5'];
						var killURL=seckill.URL.excution(seckillId,md5);
						console.log(killURL);//TODO
						$("#killbtn").one('click',function(){
							$(this).addClass('disable');
							$.post(killURL,{},function(result){
								if(result && result["success"]){
									var killresult= result["date"];
									var killstate=killresult["state"];
									var killstateinfo=killresult["stateInfo"];
									node.html('<span class="label label-success">'+killstateinfo+'</span>');
								}
							});
							
						});
						node.show();
					}else{
						
					}
				}else{
					console.log("result="+result);
				}
			});
		},
		
		validatePhone : function(phone){
			if(phone && phone.length==11 && !isNaN(phone)){
				return true;
			}else{
				return false;
			}
		},

		//倒计时操作函数
		countdown : function(seckillId,nowTime,startTime,endTime){
			var showresult=$("#seckill-box");
			if(nowTime>endTime){
				showresult.html("seckill end");
			}else if(nowTime < startTime){
				var killtime=new Date(startTime+1000);
				console.log("killtime="+killtime);//TODO
                 showresult.countdown(killtime,function(event){
//					var format=event.strftime('倒计时: %D %H %M %S');
					showresult.html(event.strftime('countdown: %D days %H hours %M min %S s'));
				}).on('finish.countdown',function(){
					seckill.handleseckill(seckillId,showresult);
				});
			}else{
				seckill.handleseckill(seckillId,showresult);
			}
		},
		
        detail : {
        	init : function(paramts){
        		var killPhone = $.cookie('killPhone');
        		var seckillId = paramts['seckillId'];
        		var startTime = paramts['starttime'];
        		var endTime = paramts['endtime'];
        		if(!seckill.validatePhone(killPhone)){
        			var killPhoneModal=$("#killphoneModal");
        			killPhoneModal.modal({
        				show : true,
        				backdrop : 'static',
        				keyboard : false
        			});
        			
        			$("#killphonebtn").click(function(){
        				var phone=$("#killphone").val();
        				console.log(phone); //TODO
        				
        				if(seckill.validatePhone(phone)){
        					$.cookie('killPhone',phone,{expires:7});
        					window.location.reload();
        				}else{
        					$("#killphoneerror").hide().html("<label class='label label-danger'>phone number error!</label>").show(300);
        				}
        			});
        		}
        		
        		$.get(seckill.URL.now(),{},function(result){
        			if(result && result["success"]){
        				var nowTime=result["date"];
        				seckill.countdown(seckillId,nowTime,startTime,endTime);
        			}else{
        				console.log("result="+result);
        			}
        		})
        	}
        }
}