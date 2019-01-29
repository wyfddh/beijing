/**
 * Created by jerry on 2017/1/3.
 */

$(".box").on("click",function(){
    var type=$(this).attr("id");
    console.log(type);
    $.ajax({
        type:'POST',
        url:"http://localhost:8080/mip/3d/source/list.do",
        data:{"deskType":type},
        dataType:"text",
        success:function(json){
            var datas=eval("("+json+")");
            console.log(datas);
            $(".show").fadeIn();
            var list=datas.data;
            var len=list.length;
            $(".show ul").html("");
            for(var i=0;i<len;i++){
                $(".show ul").append("<li date-type='"+list[i].type+"'><img src='"+list[i].imgUrl+"' alt='' width='100px' height='100px;'><p>"+list[i].name+"</p></li>")
            }
            $(".show ul li").on("click",function(){
                console.log(1)
                var imgurl=$(this).find("img").attr("src");
                console.log(imgurl);
                var type=$(this).attr("date-type");
                console.log(type);
                if(type){
                    $("#"+type).find("img").attr("src",imgurl);
                    $("#"+type).next("button").attr("disabled",false);
                }
            })

        }
    });
})
$(".submit").on("click",function(){
    var type=$(this).prev(".box").attr("id");
    var imgUrl=$(this).prev(".box").find("img").attr("src");
    console.log(imgUrl);
    console.log(type);
    if(imgUrl){
        $.ajax({
            type:'POST',
            url:"data.json",
            data:{"type":type,"imgUrl":imgUrl},
            dataType:"text",
            success:function(json){
                var datas=eval("("+json+")");
                // console.log(datas.msg);
            }
        });
    }
})
