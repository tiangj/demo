layui.use('upload', function() {
    var $ = layui.jquery
        , upload = layui.upload;


    //多图片上传
    upload.render({
        elem: '#logo'
        ,url: ctxPath+'common/upload'
        ,data:{id:$("#productId").val(),type:'product',fileType:0}
        ,multiple: true
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#logoDiv').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
            });
        }
        ,done: function(res){
            //上传完毕
            if(res.code==1){
                layer.msg(res.msg,{icon:5});
            //     var picUrlList=res.picUrl;
            //     var html="";
            //     for(var i=0;i<picUrlList.length;i++){
            //         var id="logoIndex"+i;
            //         html+='<input type="hidden" name="filePath"  id="'+id+'" value="'+picUrlList[i]+'"/>';
            //     }
            //     $("#logoUrlDiv").html(html);
            }
        }
    });

    //多图片上传
    upload.render({
        elem: '#picDetail'
        ,url: ctxPath+'common/upload'
        ,data:{id:$("#productId").val(),type:'product',fileType:1}
        ,multiple: true
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#picDetailDiv').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
            });
        }
        ,done: function(res){
            //上传完毕
            if(res.code==1){
                layer.msg(res.msg,{icon:5});
            //     var picUrlList=res.picUrl;
            //     var html="";
            //     for(var i=0;i<picUrlList.length;i++){
            //         var id="picDetailIndex"+i;
            //         html+='<input type="hidden" name="filePath" id="'+id+'" value="'+picUrlList[i]+'"/>';
            //     }
            //     $("#picDetailUrlDiv").html(html);
            }
        }
    });

    //多图片上传
    upload.render({
        elem: '#productDetail'
        ,url: ctxPath+'common/upload'
        ,data:{id:$("#productId").val(),type:'product',fileType:2}
        ,multiple: true
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#productDetailDiv').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
            });
        }
        ,done: function(res){
            //上传完毕
            if(res.code==1){
                layer.msg(res.msg,{icon:5});
            //     var picUrlList=res.picUrl;
            //     var html="";
            //     for(var i=0;i<picUrlList.length;i++){
            //         var id="productDetailIndex"+i;
            //         html+='<input type="hidden" name="filePath"  id="'+id+'" value="'+picUrlList[i]+'"/>';
            //     }
            //     $("#productDetailUrlDiv").html(html);
            }
        }
    });

});