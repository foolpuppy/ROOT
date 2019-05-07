/**

 @Name：订单管理
 @Author：star1029
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
        elem: '#LAY-order-manage'
        , url: '../getAllOrders' //模拟接口
        , method: 'post'
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'orderId', width: 100, title: '订单ID', sort: true}
            , {field: 'userId', title: '用户ID', minWidth: 100}
            , {field: 'payment', title: '支付款(元)', minWidth: 100}
            , {field: 'shippingName', title: '物流名称'}
            , {field: 'shippingCode', title: '物流编号'}
            , {field: 'orderState', title: '订单状态', templet: '#roleTpl'}
            , {title: '操作', width: 80, align: 'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
        ]]
        , page: true
        , limit: 10
        , height: 'full-320'
        , text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-order-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {

            layer.confirm('确定删除?', function (index) {
                var arr = [data.orderId];
                $.ajax({
                    url: "../multiDelOrders",
                    type: "post",
                    data: {"arr": arr},
                    dataType: "json",
                    success: function () {

                    }
                });
                obj.del();
                layer.close(index);
            });
        } /*else if(obj.event === 'edit'){
            admin.popup({
                title: '编辑商品'
                ,area: ['500px', '700px']
                ,id: 'LAY-popup-user-add'
                ,success: function(layero, index){
                    view(this.id).render('shop/goods/goodsform', data).done(function(){
                        form.render(null, 'layuiadmin-form-useradmin');

                        //监听提交
                        form.on('submit(LAY-goods-submit)', function(data){
                            var field = data.field; //获取提交的字段
                            //提交 Ajax 成功后，关闭当前弹层并重载表格
                            $.ajax({
                                url : "../userEdit",
                                type : "post",
                                data : {"password":field.password ,"userId":field.userId ,"avatarPath":field.avatarPath,"username":field.username , "tel":field.phone , "email":field.email , "roleType":field.role},
                                dataType: "json",
                                success : function(data) {
                                    layui.table.reload('LAY-order-manage'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        }*/
    });


    exports('order', {})
});