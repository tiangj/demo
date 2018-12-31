layui.use(['form','layer'], function(){
    $ = layui.jquery;
    var form = layui.form
        ,layer = layui.layer;

    //自定义验证规则
    form.verify({
        nikename: function(value){
            if(value.length < 5){
                return '昵称至少得5个字符啊';
            }
        }
        ,pass: [/(.+){6,12}$/, '密码必须6到12位']
        ,repass: function(value){
            if($('#L_pass').val()!=$('#L_repass').val()){
                return '两次密码不一致';
            }
        }
    });

    //监听提交
    form.on('submit(add)', function(data){
        $.ajax({
            url:ctxPath+'sysUser/saveUser',
            method:'post',
            data:data.field,
            dataType:'JSON',
            async:true,
            success:function(res){
                if(res.code==1){
                    layer.alert(res.msg, {icon: 6},function () {
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);

                    });
                }else{
                    layer.alert(res.msg,{icon:5});
                }
            }
        });
        return false;
    });


});