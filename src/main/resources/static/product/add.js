layui.use(['form','layer'], function() {
    $ = layui.jquery;
    var form = layui.form
        ,layer = layui.layer
    form.verify();

    //监听提交
    form.on('submit(add)', function(data){
        $.ajax({
            url:ctxPath+'wwqProduct/saveProduct',
            method:'post',
            data:data.field,
            dataType:'JSON',
            async:true,
            success:function(res){
                if(res.code==1){
                    layer.msg(res.msg,{icon:6},function () {
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                    });
                }else{
                    layer.msg(res.msg,{icon:5});
                }

            }
        })
        return false;
    })
})
