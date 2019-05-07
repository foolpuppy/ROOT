/**

 @Name：layuiAdmin 用户管理 管理员管理 角色管理
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：LPPL

 */


layui.define(['table', 'form'], function (exports) {
    var $ = layui.$
        , admin = layui.admin
        , view = layui.view
        , table = layui.table
        , form = layui.form;

    //用户管理
    table.render({
        elem: '#LAY-user-manage'
        , url: '../getUser?roleType=0' //模拟接口
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'userId', width: 100, title: 'ID', sort: true}
            , {field: 'userName', title: '用户名', minWidth: 100}
            , {field: 'avatarPath', title: '头像', width: 100, templet: '#imgTpl'}
            , {field: 'tel', title: '手机'}
            , {field: 'email', title: '邮箱'}
            , {field: 'roleType', title: '角色', templet: '#roleTpl'}
            , {field: 'createTime', title: '注册时间', sort: true}
            , {title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
        ]]
        , page: true
        , limit: 10
        , height: 'full-320'
        , text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-user-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {

            layer.confirm('确定删除?', function (index) {
                var arr = [data.userId];
                $.ajax({
                    url: "../multiDel",
                    type: "post",
                    data: {"arr": arr},
                    dataType: "json",
                    success: function () {

                    }
                });
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            admin.popup({
                title: '编辑用户'
                , area: ['500px', '500px']
                , id: 'LAY-popup-user-add'
                , success: function (layero, index) {
                    view(this.id).render('user/user/userform', data).done(function () {
                        form.render(null, 'layuiadmin-form-useradmin');

                        //监听提交
                        form.on('submit(LAY-user-front-submit)', function (data) {
                            var field = data.field; //获取提交的字段
                            //提交 Ajax 成功后，关闭当前弹层并重载表格
                            $.ajax({
                                url: "../userEdit",
                                type: "post",
                                data: {
                                    "password": field.password,
                                    "userId": field.userId,
                                    "avatarPath": field.avatarPath,
                                    "username": field.username,
                                    "tel": field.phone,
                                    "email": field.email,
                                    "roleType": field.role
                                },
                                dataType: "json",
                                success: function (data) {
                                    layui.table.reload('LAY-user-manage'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        }
    });

    //管理员管理
    table.render({
        elem: '#LAY-user-back-manage'
        , url: '../getUser?roleType=1' //模拟接口
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'userId', width: 80, title: 'ID', sort: true}
            , {field: 'userName', title: '登录名'}
            , {field: 'tel', title: '手机'}
            , {field: 'email', title: '邮箱'}
            , {field: 'createTime', title: '加入时间', sort: true}
            , {title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin'}
        ]]
        , text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-user-back-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确定删除此管理员？', function (index) {
                var arr = [data.userId];
                $.ajax({
                    url: "../multiDel",
                    type: "post",
                    data: {"arr": arr},
                    dataType: "json",
                    success: function () {

                    }
                });
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            admin.popup({
                title: '编辑管理员'
                , area: ['420px', '450px']
                , id: 'LAY-popup-user-add'
                , success: function (layero, index) {
                    view(this.id).render('user/administrators/adminform', data).done(function () {
                        form.render(null, 'layuiadmin-form-admin');

                        //监听提交
                        form.on('submit(LAY-user-back-submit)', function (data) {
                            var field = data.field; //获取提交的字段

                            //提交 Ajax 成功后，关闭当前弹层并重载表格
                            $.ajax({
                                url: "../userEdit",
                                type: "post",
                                data: {
                                    "username": field.username,
                                    "userId": field.userId,
                                    "tel": field.tel,
                                    "email": field.email,
                                    "roleType": field.role
                                },
                                dataType: "json",
                                success: function (data) {
                                    layui.table.reload('LAY-user-back-manage'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });

                        });
                    });
                }
            });
        }
    });

    //角色管理
    /*table.render({
      elem: '#LAY-user-back-role'
      ,url: './json/useradmin/role.js' //模拟接口
      ,cols: [[
        {type: 'checkbox', fixed: 'left'}
        ,{field: 'id', width: 80, title: 'ID', sort: true}
        ,{field: 'rolename', title: '角色名'}
        ,{field: 'limits', title: '拥有权限'}
        ,{field: 'descr', title: '具体描述'}
        ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin'}
      ]]
      ,text: '对不起，加载出现异常！'
    });*/

    //监听工具条
    /*table.on('tool(LAY-user-back-role)', function(obj){
      var data = obj.data;
      if(obj.event === 'del'){
        layer.confirm('确定删除此角色？', function(index){
          obj.del();
          layer.close(index);
        });
      }else if(obj.event === 'edit'){
        admin.popup({
          title: '添加新角色'
          ,area: ['500px', '480px']
          ,id: 'LAY-popup-user-add'
          ,success: function(layero, index){
            view(this.id).render('user/administrators/roleform', data).done(function(){
              form.render(null, 'layuiadmin-form-role');
              
              //监听提交
              form.on('submit(LAY-user-role-submit)', function(data){
                var field = data.field; //获取提交的字段
  
                //提交 Ajax 成功后，关闭当前弹层并重载表格
                //$.ajax({});
                layui.table.reload('LAY-user-back-role'); //重载表格
                layer.close(index); //执行关闭 
              });
            });
          }
        });
      }
    });*/

    exports('useradmin', {})
});