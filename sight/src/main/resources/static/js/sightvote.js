$(function(){
	
	//控制查看数据的开关
	$('.btn-view').click(function () {
		$(this).parent().parent().prev().find('.vote-recover').each(function(index,element){
			$(element).animate({width:$(element).attr('progress-width')},'fast');
		});
		$(this).parent().parent().prev().find('.vote-ratio').show();
		$(this).siblings('.btn-noview').show();
		$(this).hide();
	});
	$('.btn-noview').click(function () {
		console.log("aaaaaaaaaaaaaa");
		$(this).parent().parent().prev().find('.vote-recover').each(function(index,element){
			$(element).animate({width:0},'fast');
		});
		$(this).parent().parent().prev().find('.vote-ratio').hide();
		$(this).siblings('.btn-view').show();
		$(this).hide();
	});

	//控制评论的开关
	$('.btn-open').click(function(){
		$(this).hide();
		$(this).siblings('.btn-shut').show();
		$(this).parent().parent().next().next().find('.usr-commend').show();
	});
	$('.btn-shut').click(function(){
		$(this).hide();
		$(this).siblings('.btn-open').show();
		$(this).parent().parent().next().next().find('.usr-commend').hide();
	});

	//查看回复与收起回复
	$('.fid-rpy').click(function(){
		$(this).hide();
		$(this).next().show();
		$(this).parent().parent().siblings('.reply-root').show();
	});

	$('.hid-rpy').click(function(){
		$(this).hide();
		$(this).prev().show();
		$(this).parent().parent().siblings('.reply-root').hide();
	});

	var commentId;
	var currentDiv;
	//根回复
	$('.pub-rpy').click(function () {
		console.log("aaaaaaaaaaaaaaa");
		var commentNickname = $(this).data("commentnickname");
		commentId = $(this).data("commentid");
		currentDiv = $(this).parent().parent().next();
		console.log(commentId);
		$(window).scrollTo($(this).parent().parent().parent().parent().siblings('.one-vote').find('.ppy'),500);
		$(this).parent().parent().parent().parent().siblings('.reply-commend').find('.rpy-cmd').attr("placeholder", "@"+commentNickname).focus();
	});

	//子回复
	$('.usr-rpy').click(function () {
		console.log("bbbbbbbbbbbbbbb");
		var commentNickname = $(this).data("commentnickname");
		currentDiv = $(this).parent().parent().parent();
		commentId = $(this).data("commentid");
		$(window).scrollTo($(this).parent().parent().parent().parent().parent().siblings('.one-vote').find('.ppy'),500);
		$(this).parent().parent().parent().parent().parent().siblings('.reply-commend').find('.rpy-cmd').attr("placeholder", "@"+commentNickname).focus();
	});

	//参数是克隆的评论盒子
	function setClickEventForComment(obj,commentnickname,commentid){
		var pubRpyBtn=obj.find(".pub-rpy");
		pubRpyBtn.click(function () {
			console.log("nihaozhangtao");
			console.log(commentnickname);
			console.log(commentid);
			var commentNickname = commentnickname; //$(this).data("commentnickname");
			commentId = commentid; //$(this).data("commentid");
			currentDiv = $(this).parent().parent().next();
			$(window).scrollTo($(this).parent().parent().parent().parent().siblings('.one-vote').find('.ppy'),500);
			$(this).parent().parent().parent().parent().siblings('.reply-commend').find('.rpy-cmd').attr("placeholder", "@"+commentNickname).focus();
		});
	}

	//参数是克隆的回复盒子
	function setClickEventForReply(obj,commentnickname,commentid){
		var usrRpyBtn=obj.find('.usr-rpy');
		usrRpyBtn.click(function () {
			console.log("ohozhangtao");
			var commentNickname = commentnickname; //$(this).data("commentnickname");
			currentDiv = $(this).parent().parent().parent();
			commentId = commentid; //$(this).data("commentid");
			console.log(commentNickname);
			console.log(commentId);
			$(window).scrollTo($(this).parent().parent().parent().parent().parent().siblings('.one-vote').find('.ppy'),500);
			$(this).parent().parent().parent().parent().parent().siblings('.reply-commend').find('.rpy-cmd').attr("placeholder", "@"+commentNickname).focus();
		});
	}

	//格式时间
	function formatDate() {
		var date = new Date();
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		m = m < 10 ? ('0' + m) : m;
		var d = date.getDate();
		d = d < 10 ? ('0' + d) : d;
		var h = date.getHours();
		h = h < 10 ? ('0' + h) : h;
		var minute = date.getMinutes();
		var second = date.getSeconds();
		minute = minute < 10 ? ('0' + minute) : minute;
		second = second < 10 ? ('0' + second) : second;
		return y + '-' + m + '-' + d+' '+h+':' + minute;
	}

	//评论
	$('.pub-comment').click(function () {
		var that = this;
		console.log("存根");
		if (commentId == null){
			$.ajax({
				type: 'POST',
				url: "/admin/addVoteComment",
				data: {comment : $(this).parent().parent().find('#rpy-cmd').val(),vote_id : $(this).parents('.vote-box').data('id')},
				dataType: 'json',
				success: function(data) {
					$(that).parent().parent().find('#rpy-cmd').val('');
					var comment = $('#root-comment').clone(true);
					comment.removeAttr('id');
					comment.css({'display':'block','margin-top':'20px','margin-bottom':'20px'});
					comment.find('img').prop('src',data.user.avatar);
					comment.find('.user-nim').text(data.user.nickname);
					comment.find('.cmd-content').text(data.comment);
					comment.find('.user-tim').text(formatDate());
					setClickEventForComment(comment,data.user.nickname,data.id);
					var parent = $(that).parent().parent().next().next();
					console.log(parent);
					parent.prepend(comment);
					console.log(data);
				}
			});
		} else {
			console.log("根与回复 或 回复与回复");
			$.ajax({
				type: 'POST',
				url: "/admin/addVoteReplyComment",
				data: {reply : $(this).parent().parent().find('#rpy-cmd').val(),comment_id : commentId},
				dataType: 'json',
				success: function(data) {
					$(that).parent().parent().find('#rpy-cmd').val('');
					var comment = $('#reply-root').clone(true);
					comment.removeAttr('id');
					comment.css('display','block');
					comment.find('img').prop('src',data.from_user_avatar);
					comment.find('.from_user').text(data.from_user_nickname);
					comment.find('.to_user').text(data.to_user_nickname);
					comment.find('.reply-cmd').text(data.reply);
					comment.find('.user-tim').text(formatDate());
					setClickEventForReply(comment,data.from_user_nickname,data.id);
					currentDiv.prepend(comment);
					console.log(data);
				}
			});
			$(this).parent().prev().find('.rpy-cmd').val('');
			$(this).parent().prev().find('.rpy-cmd').attr("placeholder", "想对作者说点什么....");
			commentId = null;
		}
	});

	//取消评论
	$('.del-comment').click(function () {
		$(this).parent().prev().find('.rpy-cmd').val('');
		$(this).parent().prev().find('.rpy-cmd').attr("placeholder", "想对作者说点什么....");
		commentId = null;
	});

	//消息提示关闭初始化
	$('.close').click(function () {
		$(this).parent().parent().hide();
	});

	$('.btn-bad').click(function () {
		var that = this;
		$(this).hide();
		$(this).siblings('.btn-good1').show();
		$.ajax({
			type: 'POST',
			url: "/admin/addVoteAppreciateNum",
			data: {voteId : $(this).parents('.vote-box').data('id')},
			dataType: 'json',
			success: function(data) {
				$(data).each(function(index,element){
					$(that).parent().find('#appreciateNum').text(element['appreciate_num']);
				})
			}
		});
	});
	$('.btn-bad1').click(function () {
		var that = this;
		$(this).hide();
		$(this).siblings('.btn-good').show();
		$.ajax({
			type: 'POST',
			url: "/admin/addVoteAppreciateNum",
			data: {voteId : $(this).parents('.vote-box').data('id')},
			dataType: 'json',
			success: function(data) {
				$(data).each(function(index,element){
					$(that).parent().find('#appreciateNum').text(element['appreciate_num']);
				})
			}
		});
	});
	$('.btn-good').click(function () {
		var that = this;
		$(this).hide();
		$(this).siblings('.btn-bad1').show();
		$.ajax({
			type: 'POST',
			url: "/admin/subVoteAppreciateNum",
			data: {voteId : $(this).parents('.vote-box').data('id')},
			dataType: 'json',
			success: function(data) {
				$(data).each(function(index,element){
					$(that).parent().find('#appreciateNum').text(element['appreciate_num']);
				})
			}
		});
	});
	$('.btn-good1').click(function () {
		var that = this;
		$(this).hide();
		$(this).siblings('.btn-bad').show();
		$.ajax({
			type: 'POST',
			url: "/admin/subVoteAppreciateNum",
			data: {voteId : $(this).parents('.vote-box').data('id')},
			dataType: 'json',
			success: function(data) {
				$(data).each(function(index,element){
					$(that).parent().find('#appreciateNum').text(element['appreciate_num']);
				})
			}
		});
	});
	function showResult(data,currentVoteDiv){
		var currentOptionContent=currentVoteDiv.children('.option-content');
		currentOptionContent.hide();
		var cloneResultDiv=$('#result-content-model').clone();
		cloneResultDiv.removeAttr('id');
		cloneResultDiv.appendTo(currentVoteDiv);
		cloneResultDiv.show();
		var oneResultModel=cloneResultDiv.find(".one-result-model");//得到一个结果的模板
		//根据以上得到的模板克隆一个个结果
		$(data).each(function(index,element){
			//console.log("index"+index+",name="+element['name']+',votes='+element['votes']+",ratio="+element['ratio']+'%');
			var cloneOneResult=oneResultModel.clone();
			cloneOneResult.removeClass('one-result-model');//删除克隆后盒子的one-reslut-model，保证全局只有一个one-reslut-model
			cloneOneResult.addClass('one-result');
			cloneOneResult.show();//显示这个结果
			cloneOneResult.find('.vote-name').text(element['option_name']);//设置文本值
			cloneOneResult.find('.vote-num').text(element['vote_num']);//设置文本值
			cloneOneResult.find('.progress').css('height','30px');
			cloneOneResult.find('.progress-bar').css('width','0');
			cloneOneResult.find('.progress-bar').attr('progress-width',element['ratio']+'%');//自定义属性，表示该进度条宽度
			cloneOneResult.appendTo(cloneResultDiv);//加到结果盒子中
		});
		//统一设置该结果盒子中所有进度条宽度
		cloneResultDiv.find('.progress-bar').each(function(index,element){
			$(element).animate({width:$(element).attr('progress-width')},'fast');
		});
	}
	$('.vote-btn').click(function(){
		console.log('触发');
		var currentVoteDiv=$(this).parents(".one-vote");
		console.log("currentVoteId="+currentVoteDiv.attr('data-voteId'));
		//触发ajax请求
		$.ajax("/admin/addVoteOptionNum",{
			type: 'POST',
			url: "/admin/addVoteOptionNum",
			data: {Id : $(this).data('id'),voteId : $(this).parents('.vote-box').data('id')},
			dataType: 'json',
			success: function(data) {
				console.log(data);
				showResult(data,currentVoteDiv);
			}
		});
		//alert($(this).parents('.vote-box').data('id'));
		//模拟ajax返回结果
		var data=[
			{"name":'华山',"votes":120,'ratio':10},
			{"name":'泰山',"votes":100,'ratio':20},
			{"name":'峨眉山',"votes":200,'ratio':30},
			{"name":'庐山',"votes":150,'ratio':90},
			{"name":'黄山',"votes":300,'ratio':20}
		];
		//回调函数内容
	});
});