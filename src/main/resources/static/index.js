$(function () {

    var tab = {
        tabAdd: function(title,url,id){
            //新增一个Tab项
            element.tabAdd('xbs_tab', {
                title: title,
                content: '<iframe tab-id="'+id+'" frameborder="0" src="'+url+'" scrolling="yes" class="x-iframe"></iframe>',
                id: id
            })
        }
        ,tabDelete: function(othis){
            //删除指定Tab项
            element.tabDelete('xbs_tab', '44'); //删除：“商品管理”

            othis.addClass('layui-btn-disabled');
        }
        ,tabChange: function(id){
            //切换到指定Tab项
            element.tabChange('xbs_tab', id); //切换到：用户管理
        }
    };

    var userId=$("#userId").val();

    if(userId==''){
        location.href=ctxPath;
    }

    /*****
     * 根据用户id获取菜单信息
     */
    $.ajax({
        url:ctxPath+'/sysMenu/getMenusByUserId',
        method:'post',
        data:{userId:userId},
        dataType:'JSON',
        success:function(res){
            var html="";
            for(var i=0;i<res.firstMenusList.length;i++){
                html+='<li>' +
                    '<a href="javascript:;">' +
                    '  <i class="iconfont">&#xe6b8;</i>' +
                    '  <cite>'+res.firstMenusList[i].menuName+'</cite>' +
                    '  <i class="iconfont nav_right">&#xe697;</i>' +
                    '</a>';
                if(res.secondMenusList.length>0){
                    html+='<ul class="sub-menu">';
                    for (var j=0;j<res.secondMenusList.length;j++){
                        if(res.secondMenusList[j].parent_id==res.firstMenusList[i].menuId){
                            html+='<li>' +
                                ' <a _href="'+ctxPath+res.secondMenusList[j].href+'">' +
                                ' <i class="iconfont">&#xe6a7;</i>' +
                                ' <cite>'+res.secondMenusList[j].menuName+'</cite>' +
                                ' </a>' +
                                ' </li>';
                        }

                    }
                    html+='</ul>';
                }
                html+='</li>';

            }
            $("#nav").html(html);


            $('.left-nav #nav li').click(function (event) {
                if($(this).children('.sub-menu').length){
                    if($(this).hasClass('open')){
                        $(this).removeClass('open');
                        $(this).find('.nav_right').html('&#xe697;');
                        $(this).children('.sub-menu').stop().slideUp();
                        $(this).siblings().children('.sub-menu').slideUp();
                    }else{
                        $(this).addClass('open');
                        $(this).children('a').find('.nav_right').html('&#xe6a6;');
                        $(this).children('.sub-menu').stop().slideDown();
                        $(this).siblings().children('.sub-menu').stop().slideUp();
                        $(this).siblings().find('.nav_right').html('&#xe697;');
                        $(this).siblings().removeClass('open');
                    }
                }else{

                    var url = $(this).children('a').attr('_href');
                    var title = $(this).find('cite').html();
                    var index  = $('.left-nav #nav li').index($(this));

                    for (var i = 0; i <$('.x-iframe').length; i++) {
                        if($('.x-iframe').eq(i).attr('tab-id')==index+1){
                            tab.tabChange(index+1);
                            event.stopPropagation();
                            return;
                        }
                    };

                    tab.tabAdd(title,url,index+1);
                    tab.tabChange(index+1);
                }

                event.stopPropagation();

            })
        }
    }) ;
});