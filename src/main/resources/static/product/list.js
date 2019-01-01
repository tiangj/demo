$(function () {

    var height = $(document.body).height() * 0.8;

    layui.use('table', function () {
        var table = layui.table;
        //方法级渲染
        table.render({
            elem: '#LAY_table_product'
            , url: ctxPath + 'wwqProduct/listData'
            , cols: [[
                {field: 'productId', hide:true}
                , {field: 'productName', title: '商品名称', width: '10%', sort: true}
                , {field: 'productOrginPrice', title: '商品原价', width: '8%', sort: true}
                , {field: 'productNowPrice', title: '商品折扣价', width: '8%', sort: true}
                , {field: 'sellNum', title: '销售量', width: '8%', sort: true}
                , {field: 'remainNum', title: '剩余数量', width: '8%', sort: true}
                , {field: 'productNum', title: '商品销量', width: '8%', sort: true}
                , {
                    field: 'productDec', title: '商品描述', width: '15%', sort: true, templet: function (d) {
                        if (d.productDec.length > 20) {
                            return "<span title='" + d.productDec + "'>" + d.productDec.substring(0, 20) + "</span>"
                        } else {
                            return d.productDec;
                        }
                    }
                }
                , {field: 'sortName', title: '所属分类', width: '10%', sort: true}
                , {
                    field: 'productType', title: '类型', width: '10%', sort: true, templet: function (d) {
                        if (d.productType == '1') {
                            return "实物";
                        } else if (d.productType == '2') {
                            return "服务";
                        }
                    }
                }
                , {
                    filed: 'cz', title: '操作', width: '15%', templet: function (d) {
                        var html = "";
                        var productId="'"+d.productId+"'";
                        html += '<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>';
                        html += '<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>';
                        html+='<a class="layui-btn layui-btn-danger layui-btn-xs" onclick="addProductPic('+productId+')">图片管理</a>'
                        return html;
                    }
                }
            ]]
            , id: 'productReload'
            , page: true
            , height: height
            ,done: function(res, curr, count){
                $("[data-field='productId']").css('display','none');
            }
        });

        //监听工具条
        table.on('tool(product)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.productId + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {

                    $.ajax({
                        url: ctxPath + 'wwqProduct/delProduct',
                        method: 'post',
                        data: {id: data.productId},
                        dataType: 'JSON',
                        async: true,
                        success: function (res) {
                            if (res.code == 1) {
                                layer.msg(res.msg, {icon: 6});
                                obj.del();
                                layer.close(index);
                            } else {
                                layer.msg(res.msg, {icon: 2});
                            }
                        }
                    })

                });
            } else if (obj.event === 'edit') {
                x_admin_show('修改商品信息', 'wwqProduct/addProduct?id=' + data.productId, 1000, 800);
                //图片上传页面
            }
        });

        var $ = layui.$, active = {
            reload: function () {
                var productName = $('#productName').val();
                var data = {
                    productName: productName
                }
                //执行重载
                table.reload('productReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: data
                });
            }
        };
        $('.productTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
});

function addProductPic(id) {
    x_admin_show('图片管理', 'wwqProduct/addProductPic?id=' + id, 800, 600);
}