$(function  () {
    layui.use('form', function(){
        var form = layui.form;
        // layer.msg('玩命卖萌中', function(){
        //   //关闭后的操作
        //   });
        //监听提交
        form.on('submit(signIn)', function(data){
            $.ajax({
                url:ctxPath+'signIn',
                method:'post',
                data:data.field,
                dataType:'JSON',
                async:true,
                success:function(res){
                    if(res.code==1){
                        // layer.alert(res.msg,{icon: 1});
                        location.href=ctxPath+'index';
                    }else{
                        layer.alert(res.msg,{icon: 5});
                    }
                },
                error:function () {
                    layer.alert("请求失败,请联系管理员...",{icon: 1});
                }
            })
            return false;
        });
    });
});