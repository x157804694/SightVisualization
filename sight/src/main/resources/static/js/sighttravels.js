$(function(){

    //点赞功能
    $('.btn-travel-bad').click(function () {

        var that = this;
        $(this).hide();
        $(this).siblings('.btn-travel-good1').show();
        $.ajax({
            type: 'POST',
            url: "/admin/addTravelAppreciateNum",
            data: {travelId : $(this).parents('.vote-box').data('id')},
            dataType: 'json',
            success: function(data) {
                $(data).each(function(index,element){
                    $(that).parent().find('#appreciateNum').text(element['appreciate_num']);
                })
            }
        });
    });
    $('.btn-travel-bad1').click(function () {
        var that = this;
        $(this).hide();
        $(this).siblings('.btn-travel-good').show();
        $.ajax({
            type: 'POST',
            url: "/admin/addTravelAppreciateNum",
            data: {travelId : $(this).parents('.vote-box').data('id')},
            dataType: 'json',
            success: function(data) {
                $(data).each(function(index,element){
                    $(that).parent().find('#appreciateNum').text(element['appreciate_num']);
                })
            }
        });
    });
    $('.btn-travel-good').click(function () {
        var that = this;
        $(this).hide();
        $(this).siblings('.btn-travel-bad1').show();
        $.ajax({
            type: 'POST',
            url: "/admin/subTravelAppreciateNum",
            data: {travelId : $(this).parents('.vote-box').data('id')},
            dataType: 'json',
            success: function(data) {
                $(data).each(function(index,element){
                    $(that).parent().find('#appreciateNum').text(element['appreciate_num']);
                })
            }
        });
    });
    $('.btn-travel-good1').click(function () {
        var that = this;
        $(this).hide();
        $(this).siblings('.btn-travel-bad').show();
        $.ajax({
            type: 'POST',
            url: "/admin/subTravelAppreciateNum",
            data: {travelId : $(this).parents('.vote-box').data('id')},
            dataType: 'json',
            success: function(data) {
                $(data).each(function(index,element){
                    $(that).parent().find('#appreciateNum').text(element['appreciate_num']);
                })
            }
        });
    });

    //控制评论的开关
    $('.btn-travel-open').click(function(){
        $(this).hide();
        $(this).siblings('.btn-travel-shut').show();
        $(this).parent().parent().next().next().find('.usr-travel-commend').show();
    });
    $('.btn-travel-shut').click(function(){
        $(this).hide();
        $(this).siblings('.btn-travel-open').show();
        $(this).parent().parent().next().next().find('.usr-travel-commend').hide();
    });

    //查看回复与收起回复
    $('.fid-travel-rpy').click(function(){
        $(this).hide();
        $(this).next().show();
        $(this).parent().parent().siblings('.reply-travel-root').show();
    });

    $('.hid-travel-rpy').click(function(){
        $(this).hide();
        $(this).prev().show();
        $(this).parent().parent().siblings('.reply-travel-root').hide();
    });

    var commentId;
    var currentDiv;
    //根回复
    $('.pub-travel-rpy').click(function () {
        console.log("travelaaaaaaaaaaaaaaa");
        var commentNickname = $(this).data("commentnickname");
        commentId = $(this).data("commentid");
        currentDiv = $(this).parent().parent().next();
        console.log(commentId);
        console.log(commentNickname);
        $(window).scrollTo($(this).parent().parent().parent().parent().siblings('.one-travel').find('.ppy'),500);
        $(this).parent().parent().parent().parent().siblings('.reply-commend').find('.rpy-travel-cmd').attr("placeholder", "@"+commentNickname).focus();
    });

    //子回复
    $('.usr-rpy').click(function () {
        console.log("bbbbbbbbbbbbbbb");
        var commentNickname = $(this).data("commentnickname");
        currentDiv = $(this).parent().parent().parent();
        commentId = $(this).data("commentid");
        $(window).scrollTo($(this).parent().parent().parent().parent().parent().siblings('.one-travel').find('.ppy'),500);
        $(this).parent().parent().parent().parent().parent().siblings('.reply-commend').find('.rpy-travel-cmd').attr("placeholder", "@"+commentNickname).focus();
    });

    //参数是克隆的评论盒子
    function setClickEventForComment(obj,commentnickname,commentid){
        var pubRpyBtn=obj.find(".pub-travel-rpy");
        pubRpyBtn.click(function () {
            console.log("nihaozhangtao");
            console.log(commentnickname);
            console.log(commentid);
            var commentNickname = commentnickname; //$(this).data("commentnickname");
            commentId = commentid; //$(this).data("commentid");
            currentDiv = $(this).parent().parent().next();
            $(window).scrollTo($(this).parent().parent().parent().parent().siblings('.one-vote').find('.ppy'),500);
            $(this).parent().parent().parent().parent().siblings('.reply-commend').find('.rpy-travel-cmd').attr("placeholder", "@"+commentNickname).focus();
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
            $(window).scrollTo($(this).parent().parent().parent().parent().parent().siblings('.one-travel').find('.ppy'),500);
            $(this).parent().parent().parent().parent().parent().siblings('.reply-commend').find('.rpy-travel-cmd').attr("placeholder", "@"+commentNickname).focus();
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
    $('.pub-travel-comment').click(function () {
        var that = this;
        console.log("root");
        if (commentId == null){
            //console.log("travelcomment");
            //console.log($(this).parent().parent().find('#rpy-travel-cmd').val());
            //console.log($(this).parents('.vote-box').data('id'));
            $.ajax({
                type: 'POST',
                url: "/admin/addTravelComment",
                data: {comment : $(this).parent().parent().find('#rpy-travel-cmd').val(),travel_id : $(this).parents('.vote-box').data('id')},
                dataType: 'json',
                success: function(data) {
                    $(that).parent().parent().find('#rpy-travel-cmd').val('');
                    var comment = $('#root-travel-comment').clone(true);
                    comment.removeAttr('id');
                    comment.css({'display':'block','margin-top':'20px','margin-bottom':'20px'});
                    comment.find('img').prop('src',data.user.avatar);
                    comment.find('.user-nim').text(data.user.nickname);
                    comment.find('.cmd-travel-content').text(data.comment);
                    comment.find('.user-tim').text(formatDate());
                    setClickEventForComment(comment,data.user.nickname,data.id);
                    var parent = $(that).parent().parent().next().next();
                    console.log(parent);
                    parent.prepend(comment);
                    $(that).parent().parent().next().next().find('.usr-travel-commend').show();
                    $(that).parent().parent().find('.btn-travel-open').hide();
                    $(that).parent().parent().find('.btn-travel-shut').show();
                    console.log(data);
                }
            });
        } else {
            console.log("根与回复 或 回复与回复");
            $.ajax({
                type: 'POST',
                url: "/admin/addTravelReplyComment",
                data: {reply : $(this).parent().parent().find('#rpy-travel-cmd').val(),comment_id : commentId},
                dataType: 'json',
                success: function(data) {
                    $(that).parent().parent().find('#rpy-travel-cmd').val('');
                    var comment = $('#reply-travel-root').clone(true);
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
            $(this).parent().prev().find('.rpy-travel-cmd').val('');
            $(this).parent().prev().find('.rpy-travel-cmd').attr("placeholder", "想对作者说点什么....");
            commentId = null;
        }
    });

    //取消评论
    $('.del-travel-comment').click(function () {
        $(this).parent().prev().find('.rpy-travel-cmd').val('');
        $(this).parent().prev().find('.rpy-travel-cmd').attr("placeholder", "想对作者说点什么....");
        commentId = null;
    });
})
