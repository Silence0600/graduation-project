
(function($){
	// ajax验证用户密码.
	$("#login").click(function () {
        $.ajax({
            type:"POST",
            url:"login.action",
            data:{
            	id:$("input[id=id]").val(),
            	password:$("input[password=password]").val()
            },
            dataType:"json",
            success: function (data) {
                $("#resText").empty();
                var html = "";
                $.each(data, function (commentIndex, comment) {
                    html += "<div class='comment'><a href='#' class='username'>" + comment['username'] +
                            "</a><span class='location'>" + comment['location'] +
                            "</span></p><p class='contentTxt'>" + comment['contentTxt'] + "</p></div>";
                });
                $("#resText").html(html);
            
            },
            errer: function(){
        	
            }
        })
    });
	
	
	
    $.fn.drag = function(options){
        var x, drag = this, isMove = false, defaults = {
        };
        var options = $.extend(defaults, options);
        // 添加背景，文字，滑块
        var html = '<div class="drag_bg"></div>'+
                    '<div class="drag_text" onselectstart="return false;" unselectable="on">拖动滑块验证</div>'+
                    '<div class="handler handler_bg"></div>';
        this.append(html);
        
        var handler = drag.find('.handler');
        var drag_bg = drag.find('.drag_bg');
        var text = drag.find('.drag_text');
        var maxWidth = drag.width() - handler.width();  // 能滑动的最大间距
        
        // 鼠标按下时候的x轴的位置
        handler.mousedown(function(e){
            isMove = true;
            x = e.pageX - parseInt(handler.css('left'), 10);
        });
        
        // 鼠标指针在上下文移动时，移动距离大于0小于最大间距，滑块x轴位置等于鼠标移动距离
        $(document).mousemove(function(e){
            var _x = e.pageX - x;
            if(isMove){
                if(_x > 0 && _x <= maxWidth){
                    handler.css({'left': _x});
                    drag_bg.css({'width': _x});
                }else if(_x > maxWidth){  // 鼠标指针移动距离达到最大时清空事件
                    dragOk();
                }
            }
        }).mouseup(function(e){
            isMove = false;
            var _x = e.pageX - x;
            if(_x < maxWidth){ // 鼠标松开时，如果没有达到最大距离位置，滑块就返回初始位置
                handler.css({'left': 0});
                drag_bg.css({'width': 0});
            }
        });
        
        // 清空事件
        function dragOk(){
            handler.removeClass('handler_bg').addClass('handler_ok_bg');
            text.text('验证通过');
            drag.css({'color': '#fff'});
            handler.unbind('mousedown');
            $(document).unbind('mousemove');
            $(document).unbind('mouseup');
        }
    };
    
    
    
})(jQuery);


var code; //在全局定义验证码      
//产生验证码     
window.onload = function() {  
  createCode();  
}  

function createCode() {  
  code = "";  
  var codeLength = 5; //验证码的长度     
  var checkCode = document.getElementById("checkCode");  
  var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',  
      'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //随机数     
  for(var i = 0; i < codeLength; i++) { //循环操作     
      var charIndex = Math.floor(Math.random() * 36); //取得随机数的索引     
      code += random[charIndex]; //根据索引取得随机数加到code上     
  }  
  checkCode.value = code; //把code值赋给验证码     
}  
//校验验证码     
function validate() {  
  var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写           
  if(inputCode.length <= 0) { //若输入的验证码长度为0     
      alert("请输入验证码！"); //则弹出请输入验证码     
  } else if(inputCode != code) { //若输入的验证码与产生的验证码不一致时     
      alert("验证码输入错误！"); //则弹出验证码输入错误     
      createCode(); //刷新验证码     
  } else { //输入正确时     
      alert("^-^"); //弹出^-^     
  }  
}  


