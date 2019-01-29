
$(function(){
    // 页数
    var page = 0;
    // 每页展示5个
    var size = 5;

    // dropload
    $('.collection-top').dropload({
        scrollArea : window,
        loadDownFn : function(me){
            page++;
            // 拼接HTML
            var result = '';
            $.ajax({
                type: 'GET',
                url: 'json/collection.json?page='+page+'&size='+size,
                dataType: 'json',
                success: function(data){
                    var arrLen = data.data.mociList.length;
                    if(arrLen > 0){
                        for(var i=0; i<arrLen; i++){
                            result +=   '<div class="list">'
                                +'<a class="item item-thumbnail-left">'
                                +'<img src="'+data.data.mociList[i].fpic+'" alt="">'
                                +'<h2>'+data.data.mociList[i].name+'</h2>'
                                +'<p class="year">唐（公元618~907年）</p>'
                                +'<p class="zhonglei">青铜器</p>'
                                +'<p class="high">高12cm</p>'
                                +'<div class="media-box">'
                                +'<span>3D</span>'
                                +'<span>视频</span>'
                                +'<span>语音</span>'
                                +'</div>'
                                +'</a>'
                                +'</div>';
                        }
                        // 如果没有数据
                    }else{
                        // 锁定
                        me.lock();
                        // 无数据
                        me.noData();
                    }
                    // 为了测试，延迟1秒加载
                    setTimeout(function(){
                        // 插入数据到页面，放到最后面
                        $('.collection-top').append(result);
                        // 每次数据插入，必须重置
                        me.resetload();
                    },1000);
                },
                error: function(xhr, type){
                    alert('Ajax error!');
                    // 即使加载出错，也得重置
                    me.resetload();
                }
            });
        }
    });
});