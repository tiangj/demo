$(function () {

    //加载日期控件
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    var height = $(document.body).height() * 0.8;

    layui.use('table', function () {
        var table = layui.table;
        //方法级渲染
        table.render({
            elem: '#LAY_table_user'
            , url: ctxPath + 'sysUser/listData'
            , cols: [[
                {field: 'id', title: 'ID', width: '5%', sort: true, fixed: 'left'}
                , {field: 'loginName', title: '账号', width: '15%'}
                , {field: 'name', title: '用户名', width: '15%', sort: true}
                , {field: 'email', title: '邮箱', width: '15%'}
                , {field: 'phone', title: '手机号', width: '15%'}
                , {field: 'createDate', title: '创建时间', width: '15%', sort: true}
                , {
                    field: 'delFlag', title: '状态', width: '10%', sort: true, templet: function (d) {
                        if (d.delFlag == 0) {
                            return '正常';
                        } else {
                            return '作废';
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
            , id: 'testReload'
            , page: true
            , height: height
        });
        //监听工具条
        table.on('tool(user)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.id + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {

                    $.ajax({
                        url: ctxPath + 'sysUser/delUser',
                        method: 'post',
                        data: {id: data.id},
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
                x_admin_show('修改用户信息', 'sysUser/userAdd?id=' + data.id, 600, 400);
            }
        });

        var $ = layui.$, active = {
            reload: function () {
                var username = $('#username').val();
                var name = $("#name").val();
                var data = {
                    username: username,
                    name: name
                }
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: data
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });


    })

});
