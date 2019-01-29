/************************************************
 * http://www.jq-school.com/Article.aspx?kid=471/
 * @author :leon.z
 * @email  :LeonJsObj@126.com
 * @date   :2014-12-12
 * @description :自己写的loading小插件
 ***********************************************/
/**
	自己写的Loading加载小插件,用户可以选择html格式或canvas格式，自定义loading图片，canvas色彩搭配可根据个人喜好，简单易用。
	eg:$.Loading({type:"html",speed:200,loadPicNum:2,autoHide:false})
**/
;(function($) {
	$.Loading = function(options) {
		//暴漏插件默认值
		$.Loading.defaults = {
			speed: 200, //弹出层淡出速度                      
			bgcolor: '#0078fe', //遮罩层颜色,需要rgba格式，默认黑色0.5透明度
			type: "html", //默认html样式，也可以是canvas
			msg: '正在加载......', //默认加载信息
			loadPicNum: 2, //为html时loading图片那一种(目前53种可选);
			canvassupport: false, //是否支持html5 canvas
			Loadtimer: 3000, //遮罩层隐藏时间 ，只有在html格式下有效
			autoHide: false, //是否自动隐藏
			random: false, //是否随机loading图片，只有在html格式下有效
			callback: function() {}, //默认回调函数
			canvasFillColor: "#0078fe", //默认canvas填充色
			canvasbackColor: "#ccc", //默认canvas底色
			canvasFontColor: "red" //默认canvas字体色
		};
		var opts = $.extend({}, $.Loading.defaults, options);;
		(function() {
			if (window.applicationCache) {
				canvassupport = true;
			} else {
				canvassupport = false;
			}
			if (opts.type && opts.type === "html") {
				pageRender("html");
			};
			if (opts.type && opts.type === "canvas") {
				if (canvassupport) {
					pageRender("canvas");
				} else {
					pageRender("html");
				}
			}
		})();

		function pageRender(type) {
			var html = '';
			html += '<div class="loadingbox">';

			if (type === "html") {
				if (!!opts.random) {
					opts.loadPicNum = Math.ceil(Math.random() * 53);
				}
				html += '<div class="topPart"><img src="designPlug-in/jquery/loading/loading' + opts.loadPicNum + '.gif" /></div>'
			};
			if (type === "canvas") {
				html += '<div class="topPart"><canvas id="mycanvas"></canvas></div>';
			}
			html += '<p class="font">' + opts.msg + '</p>';
			html += '</div>';

			var img = new Image();
			img.onload = function() {
				if ($(".loadingbox").length > 0) {
					$(".loadingbox").remove();
				}
				$('body').append(html);
				renderStyle(type);
			}
			img.src = "designPlug-in/jquery/loading/loading" + opts.loadPicNum + ".gif";
		};

		function renderStyle(type) {
			var iw = document.documentElement.clientWidth || document.body.clientWidth;
			var loadBixW = iw > 320 ? 200 : 160;
			var picH = $('.topPart').height() > 90 ? 100 : $('.topPart').height();
			var ml = (iw - loadBixW) / 2;

			$('.loadingbox').css({
				width: loadBixW + "px",
				zIndex: '999999',
				position: 'fixed',
				background: opts.bgcolor,
				borderRadius: '15px',
//				cursor: 'pointer',
				left: ml + 'px',
				top: "20%"
			});
			$('.font').css({
				textAlign: "center",
				fontSize: '16px',
				color: '#fff',
				margin: "5px 0 10px 0"
			});
			$('.topPart').css({
				width: "100%",
				textAlign: "center",
				paddingTop: '10px'
			});
			if (type === "html") {

				if (picH < 70 && picH > 0) {
					$('.topPart').find('img').css({
						maxWidth: "100%",
						padding: "20px 0"
					});
				}
				if (picH >= 90) {
					$('.topPart').find('img').css({
						maxWidth: "100%",
						height: picH + "px"
					});
				}
				if (opts.autoHide)
					setTimeout(function() {
						closeLoading(opts.callback);
					}, opts.Loadtimer);
			}
			if (type === "canvas") {
				var canvas = document.getElementById('mycanvas');
				canvas.width = 120;
				canvas.height = 120;
				if (canvas.getContext) {
					var cxt = canvas.getContext('2d'),
						W = canvas.width,
						H = canvas.height,
						deg = 0,
						new_deg = 0,
						diff = 0,
						loop,
						reloop,
						text,
						text_w;

					function init() {

						cxt.clearRect(0, 0, W, H);
						cxt.beginPath();
						cxt.strokeStyle = opts.canvasbackColor;
						cxt.lineWidth = 5;
						cxt.arc(W / 2, H / 2, 50, 0, Math.PI * 2, false);
						cxt.stroke();

						var r = deg * Math.PI / 180;
						cxt.beginPath();
						cxt.strokeStyle = opts.canvasFillColor;
						cxt.lineWidth = 5;
						cxt.arc(W / 2, H / 2, 50, 0 - 90 * Math.PI / 180, r - Math.PI * 90 / 180, false);
						cxt.stroke();

						cxt.fillStyle = opts.canvasFontColor;
						cxt.font = "25px Arial";
						text = Math.floor(deg / 360 * 100) + "%";
						text_w = cxt.measureText(text).width;
						cxt.fillText(text, W / 2 - text_w / 2, H / 2 + 10);
					};

					function draw() {
						new_deg = 360;
						diff = new_deg - deg;
						loop = setInterval(to, 5000 / diff);

					};

					function to() {
						if (deg == new_deg) {
							clearInterval(loop);
							if (opts.autoHide) closeLoading(opts.callback);

						}
						if (deg < new_deg) {
							deg++;
						}
						init();
					}
					draw();


				}
			}

		};

		function closeLoading(callback) {
			$('.loadingbox:visible').fadeOut(opts.speed);
			if (typeof callback === "function") {
				callback();
			}
		};
	},
	$.closeLoading_ =function () {
		$('.loadingbox:visible').fadeOut(200);
	}
})(jQuery);