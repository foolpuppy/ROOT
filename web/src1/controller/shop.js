/**

 @Name：商品管理
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
        elem: '#LAY-goods-manage'
        , url: '../sellergetMyItem' //模拟接口
        , method: 'post'
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'id', width: 100, title: 'ID', sort: true}
            , {field: 'title', title: '商品标题', minWidth: 100}
            , {field: 'category', title: '商品分类', minWidth: 100}
            , {field: 'item_image_path', title: '商品样图', width: 300, height: 300, templet: '#imgTpl'}
            , {field: 'price', title: '单价'}
            , {field: 'stock', title: '库存'}
            , {field: 'state', title: '商品状态', templet: '#roleTpl'}
            , {field: 'shopId', title: '店铺编号'}
            , {field: 'desc', title: '商品描述'}
            , {title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
        ]]
        , page: true
        , limit: 10
        , height: 'full-320'
        , text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-goods-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {

            layer.confirm('确定删除?', function (index) {
                var arr = [data.id];
                $.ajax({
                    url: "../multiDelItems",
                    type: "post",
                    data: {"arr": arr},
                    dataType: "json",
                    success: function (data) {
                        obj.del();
                        layer.close(index);
                    }
                });

            });
        } else if (obj.event === 'edit') {
            admin.popup({
                title: '编辑商品'
                , area: ['500px', '700px']
                , id: 'LAY-popup-user-add'
                , success: function (layero, index) {
                    view(this.id).render('shop/goods/goodsform', data).done(function () {
                        form.render(null, 'layuiadmin-form-useradmin');

                        //监听提交
                        form.on('submit(LAY-goods-submit)', function (data) {
                            var field = data.field; //获取提交的字段
                            //提交 Ajax 成功后，关闭当前弹层并重载表格
                            $.ajax({
                                url: "../itemEdit",
                                type: "post",
                                data: {
                                    "title": field.title,
                                    "id": field.id,
                                    "category": field.category,
                                    "price": field.price,
                                    "stock": field.stock,
                                    "shopId": field.shopId,
                                    "desc": field.desc,
                                    "state": field.state,
                                    "itemImagePath": field.itemImagePath
                                },
                                dataType: "json",
                                success: function (data) {
                                    layui.table.reload('LAY-goods-manage'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        }
    });


    exports('shop', {})
});