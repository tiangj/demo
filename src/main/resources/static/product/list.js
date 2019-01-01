$(function () {

    var height = $(document.body).height() * 0.8;

    layui.use('table', function () {
        var table = layui.table;
        //方法级渲染
        table.render({
            elem: '#LAY_table_product'
            , url: ctxPath + 'wwqProduct/listData'
            , cols: [[
                {field: 'productId', title: 'ID', width: '5%', sort: true, fixed: 'left'}
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
                    filed: 'cz', title: '操作', width: '10%', templet: function (d) {
                        var html = "";
                        html += '<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>';
                        html += '<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>';
                        return html;
                    }
                }
            ]]
            , id: 'productReload'
            , page: true
            , height: height
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