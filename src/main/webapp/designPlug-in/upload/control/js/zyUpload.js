
(function($,undefined){
	$.fn.zyUpload = function(options,param){
		var otherArgs = Array.prototype.slice.call(arguments, 1);
		if (typeof options == 'string') {
			var fn = this[0][options];
			if($.isFunction(fn)){
				return fn.apply(this, otherArgs);
			}else{
				throw ("zyUpload - No such method: " + options);
			}
		}

		return this.each(function(){
			var para = {};    // 保留参数
			var self = this;  // 保存组件对象
			
			var defaults = {
					width            : "100%",  					// 宽度
					height           : "400px",  					// 宽度
					itemWidth        : "140px",                     // 文件项的宽度
					itemHeight       : "120px",                     // 文件项的高度
					url              : "cgformAttchController.do?mySaveFiles",  	// 上传文件的路径
					multiple         : true,  						// 是否可以多个文件上传
					dragDrop         : true,  						// 是否可以拖动上传文件
					del              : true,  						// 是否可以删除文件
					finishDel        : true,  						// 是否在上传文件完成后删除预览
					/* 提供给外部的接口方法 */
					onSelect         : function(selectFiles, files){},// 选择文件的回调方法  selectFile:当前选中的文件  allFiles:还没上传的全部文件
					onDelete		 : function(file, files){},     // 删除一个文件的回调方法 file:当前删除的文件  files:删除之后的文件
					onSuccess		 : function(file){},            // 文件上传成功的回调方法
					onFailure		 : function(file){},            // 文件上传失败的回调方法
					onComplete		 : function(responseInfo){},    // 上传完成的回调方法
			};
			
			para = $.extend(defaults,options);
			
			this.init = function(){
				this.createHtml();  // 创建组件html
				this.createCorePlug();  // 调用核心js
			};
			
			/**
			 * 功能：创建上传所使用的html
			 * 参数: 无
			 * 返回: 无
			 */
			this.createHtml = function(){
				var multiple = "";  // 设置多选的参数
				para.multiple ? multiple = "multiple" : multiple = "";
				var html= '';
				if(para.dragDrop){
					// 创建带有拖动的html
					html += '<form id="uploadForm_'+para.designId+'" action="'+para.url+'" method="post" enctype="multipart/form-data">';
					html += '	<input id="businessKey" name="businessKey" type="hidden"  value="'+para.mainId+'">';
					html += '	<input id="designId" name="designId" type="hidden"  value="'+para.designId+'">';
					html += '	<div class="upload_box">';
					html += '		<div class="upload_main">';
					//html += '			<div class="upload_choose">';
	            	//html += '				<div class="convent_choice">';
					//html += '					<div class="">';
	            	//html += '						<div class="filePicker">点击选择文件</div>';
	            	html += '						<input id="fileImage" type="file" size="30" name="fileselect[]" '+multiple+'>';
	            	//html += '					</div>';
	            	//html += '				</div>';
	            	//html += '			</div>';
	            	if(para.disabled_!="true"){
			            html += '			<div class="status_bar">';
			            html += '				<div id="status_info" class="info">选中0个文件，共0B。</div>';
			            html += '				<div class="btns">';
			            html += '					<div class="webuploader_pick layui-btn layui-btn-primary layui-btn-xs">选择</div>';
			            html += '					<div class="upload_btn layui-btn layui-btn-xs layui-btn-normal"><i class="layui-icon"></i>开始上传</div>';
			            html += '				</div>';
			            html += '			</div>';
	            	}
					html += '			<div id="preview" class="upload_preview"></div>';
					html += '		</div>';
					html += '		<div class="upload_submit">';
					html += '			<button type="button" id="fileSubmit" class="upload_submit_btn">确认上传文件</button>';
					html += '		</div>';
					html += '		<div id="uploadInf" class="upload_inf"></div>';
					html += '	</div>';
					html += '</form>';
				}else{
					var imgWidth = parseInt(para.itemWidth.replace("px", ""))-15;
					
					// 创建不带有拖动的html
					html += '<form id="uploadForm_'+para.designId+'" action="'+para.url+'" method="post" enctype="multipart/form-data">';
					html += '	<input id="businessKey" name="businessKey" type="hidden"  value="'+para.mainId+'">';
					html += '	<input id="designId" name="designId" type="hidden"  value="'+para.designId+'">';
					html += '	<div class="upload_box">';
					html += '		<div class="upload_main single_main">';
					if(para.disabled_!="true"){
			            html += '			<div class="status_bar">';
			            html += '				<div id="status_info" class="info">选中0个文件，共0B。</div>';
			            html += '				<div class="btns">';
			            html += '					<input id="fileImage" type="file" size="30" name="fileselect[]" '+multiple+'>';
			            html += '					<div class="webuploader_pick layui-btn layui-btn-primary layui-btn-xs">选择文件</div>';
			            html += '					<div class="upload_btn layui-btn layui-btn-xs layui-btn-normal"><i class="layui-icon"></i>开始上传</div>';
			            html += '				</div>';
			            html += '			</div>';
					}
		            html += '			<div id="preview" class="upload_preview">';
		            if(para.disabled_!="true"){
					    html += '				<div class="add_upload">';
					    html += '					<a style="height:30px;width:100%;" title="点击添加文件" id="rapidAddImg" class="add_imgBox" href="javascript:void(0)">';
					    html += '						<div class="uploadImg" style="padding:0px 40px 0px 2px;">';
					    html += '							<img class="upload_image" src='+$("#contextPath_").val()+'"/static/ace/upload/control/images/add_img.png" style="width:expression(this.width > '+imgWidth+' ? '+imgWidth+'px : this.width)" />';
					    html += '						</div>';
					    html += '					</a>';
					    html += '				</div>';
		            }
					html += '			</div>';
					html += '		</div>';
					 if(para.disabled_!="true"){
						html += '		<div class="upload_submit">';
						html += '			<button type="button" id="fileSubmit" class="upload_submit_btn">确认上传文件</button>';
						html += '		</div>';
						html += '		<div id="uploadInf" class="upload_inf"></div>';
					 }
					html += '	</div>';
					html += '</form>';
				}
				
	            $(self).append(html).css({"width":para.width,"height":para.height});
	            
	            // 初始化html之后绑定按钮的点击事件
	            this.addEvent();
			};
			
			/**
			 * 功能：显示统计信息和绑定继续上传和上传按钮的点击事件
			 * 参数: 无
			 * 返回: 无
			 */
			this.funSetStatusInfo = function(files){
				var size = 0;
				var num = files.length;
				$.each(files, function(k,v){
					// 计算得到文件总大小
					size += v.size;
				});
				
				// 转化为kb和MB格式。文件的名字、大小、类型都是可以现实出来。
				if (size > 1024 * 1024) {                    
					size = (Math.round(size * 100 / (1024 * 1024)) / 100).toString() + 'MB';                
				} else {                    
					size = (Math.round(size * 100 / 1024) / 100).toString() + 'KB';                
				}  
				
				// 设置内容
				$("#myFileUpload_"+para.designId).find("#status_info").html("选中"+num+"张文件，共"+size+"。");
			};
			
			/**
			 * 功能：过滤上传的文件格式等
			 * 参数: files 本次选择的文件
			 * 返回: 通过的文件
			 */
			this.funFilterEligibleFile = function(files){
				var arrFiles = [];  // 替换的文件数组
				for (var i = 0, file; file = files[i]; i++) {
					if (file.size >= 51200000) {
						alert('您这个"'+ file.name +'"文件大小过大');	
					} else {
						// 在这里需要判断当前所有文件中
						arrFiles.push(file);	
					}
				}
				return arrFiles;
			};
			
			/**
			 * 功能： 处理参数和格式上的预览html
			 * 参数: files 本次选择的文件
			 * 返回: 预览的html
			 */
			this.funDisposePreviewHtml = function(file, e){
				var html = "";
				var imgWidth = parseInt(para.itemWidth.replace("px", ""))-15;
				
				// 处理配置参数删除按钮
				var delHtml = "";
				if(para.del&&para.disabled_!="true"){  // 显示删除按钮
					delHtml = '<span class="file_del" data-index="'+file.index+'" title="删除"></span>';
				}
					
				
				// 处理不同类型文件代表的图标
				var fileImgSrc = "/static/ace/upload/control/images/fileType/";
				if(file.type.indexOf("rar") > 0){
					fileImgSrc = fileImgSrc + "rar.png";
				}else if(file.type.indexOf("zip") > 0){
					fileImgSrc = fileImgSrc + "zip.png";
				}else if(file.type.indexOf("text") > 0){
					fileImgSrc = fileImgSrc + "txt.png";
				}else{
					fileImgSrc = fileImgSrc + "file.png";
				}
				
				
				// 图片上传的是图片还是其他类型文件
				if (file.type.indexOf("image") == 0) {
					html += '<div id="uploadList_'+ file.index +'" class="upload_append_list"  data-id="">';
					html += '	<div class="file_bar">';
					html += '		<div style="padding:5px;">';
					html += '			<p class="file_name">' + file.name + '</p>';
					html += delHtml;   // 删除按钮的html
					html += '		</div>';
					html += '	</div>';
					html += '	<a style="height:30px;width:100%;" href="#" class="imgBox">';
					html += '		<div class="uploadImg" style="padding:0px 40px 0px 2px;">';				
					html +=file.name;                                                                 
					html += '		</div>';
					html += '	</a>';
					html += '	<p id="uploadProgress_'+file.index+'" class="file_progress"></p>';
					html += '	<p id="uploadFailure_'+file.index+'" class="file_failure">上传失败，请重试</p>';
					html += '	<p id="uploadSuccess_'+file.index+'" class="file_success"></p>';
					html += '</div>';
                	
				}else{
					html += '<div id="uploadList_'+ file.index +'" class="upload_append_list">';
					html += '	<div class="file_bar">';
					html += '		<div style="padding:5px;">';
					html += '			<p class="file_name">' + file.name + '</p>';
					html += delHtml;   // 删除按钮的html
					html += '		</div>';
					html += '	</div>';
					html += '	<a style="height:30px;width:100%;" href="#" class="imgBox">';
					html += '		<div class="uploadImg" style="padding:0px 40px 0px 2px;">';				
					html +=   file.name ;                                                                 
					html += '		</div>';
					html += '	</a>';
					html += '	<p id="uploadProgress_'+file.index+'" class="file_progress"></p>';
					html += '	<p id="uploadFailure_'+file.index+'" class="file_failure">上传失败，请重试</p>';
					html += '	<p id="uploadSuccess_'+file.index+'" class="file_success"></p>';
					html += '</div>';
				}
				
				return html;
			};
			
			/**
			 * 功能：调用核心插件
			 * 参数: 无
			 * 返回: 无
			 */
			this.createCorePlug = function(){
				var params = {
					fileInput: $("#myFileUpload_"+para.designId).find("#fileImage").get(0),
					uploadInput: $("#myFileUpload_"+para.designId).find("#fileSubmit").get(0),
					dragDrop: $("#myFileUpload_"+para.designId).find("#fileDragArea").get(0),
					url: $("#myFileUpload_"+para.designId+"").attr("action"),
					
					filterFile: function(files) {
						// 过滤合格的文件
						return self.funFilterEligibleFile(files);
					},
					onSelect: function(selectFiles, allFiles) {
						para.onSelect(selectFiles, allFiles);  // 回调方法
						self.funSetStatusInfo(ZYFILE.funReturnNeedFiles());  // 显示统计信息
						var html = '', i = 0;
						// 组织预览html
						var funDealtPreviewHtml = function() {
							file = selectFiles[i];
							if (file) {
								var reader = new FileReader()
								reader.onload = function(e) {
									// 处理下配置参数和格式的html
									html += self.funDisposePreviewHtml(file, e);
									
									i++;
									// 再接着调用此方法递归组成可以预览的html
									funDealtPreviewHtml();
								}
								reader.readAsDataURL(file);
							} else {
								// 走到这里说明文件html已经组织完毕，要把html添加到预览区
								funAppendPreviewHtml(html);
							}
						};
						
						// 添加预览html
						var funAppendPreviewHtml = function(html){
							// 添加到添加按钮前
							if(para.dragDrop){
								$("#myFileUpload_"+para.designId).find("#preview").append(html);
							}else{
								$("#myFileUpload_"+para.designId).find(".add_upload").before(html);
							}
							// 绑定删除按钮
							if(para.disabled_!="true"){
								funBindDelEvent();
								funBindHoverEvent();
							}
						};
						
						// 绑定删除按钮事件
						var funBindDelEvent = function(){
							if($("#myFileUpload_"+para.designId).find(".file_del").length>0){
								// 删除方法
								$("#myFileUpload_"+para.designId).find(".file_del").click(function() {
									var $ts=$(this);
									var id=$ts.attr("data-id");
									myConfirmDialog("您确定要删除吗？", function() {
										$.ajax({
											async : false,
											cache : false,
											type : 'POST',
											url : "cgformAttchController.do?delFile&id=" + id,// 请求的action路径
											error : function() {// 请求失败处理函数
											},
											success : function(data) {
												layer.msg('删除成功！', {icon : 1});
												ZYFILE.funDeleteFile(parseInt($ts.attr("data-index")), true);
												return true;
											}
										});
									}, function() {
										return true;
									}, "");
									
									return false;	
								});
							}
							
							if($("#myFileUpload_"+para.designId).find(".file_edit").length>0){
								// 编辑方法
								$("#myFileUpload_"+para.designId).find(".file_edit").click(function() {
									// 调用编辑操作
									//ZYFILE.funEditFile(parseInt($(this).attr("data-index")), true);
									return false;	
								});
							}
						};
						
						// 绑定显示操作栏事件
						var funBindHoverEvent = function(){
							$("#myFileUpload_"+para.designId).find(".upload_append_list").hover(
								function (e) {
									$(this).find(".file_bar").addClass("file_hover");
								},function (e) {
									$(this).find(".file_bar").removeClass("file_hover");
								}
							);
						};
						
						funDealtPreviewHtml();		
					},
					onDelete: function(file, files) {
						// 移除效果
						$("#myFileUpload_"+para.designId).find("#uploadList_" + file.index).fadeOut();
						// 重新设置统计栏信息
						self.funSetStatusInfo(files);
						console.info("33333333333");
						console.info(file);
						console.info("剩下的文件");
						console.info(files);
						var attach_id=$("#"+para.designId).val();
						attach_id=attach_id.replace(file.attach_id+",", "");
						$("#"+para.designId).val(attach_id);
					},
					onProgress: function(file, loaded, total) {
						var eleProgress = $("#myFileUpload_"+para.designId).find("#uploadProgress_" + file.index), percent = (loaded / total * 100).toFixed(2) + '%';
						if(eleProgress.is(":hidden")){
							eleProgress.show();
						}
						eleProgress.css("width",percent);
					},
					onSuccess: function(file, response) {
						var dataObj=eval("("+response+")");//转换为json对象 dg
						$("#myFileUpload_"+para.designId).find("#uploadProgress_" + file.index).closest(".upload_append_list").attr("data-id",dataObj.attributes.fileKey);
						$("#myFileUpload_"+para.designId).find("#uploadProgress_" + file.index).hide();
						$("#myFileUpload_"+para.designId).find("#uploadSuccess_" + file.index).show();
						console.info("----1111111--------");
						console.info(file);
						console.info(dataObj);
						file.attach_id=dataObj.attributes.fileKey;
						var attach_id=$("#"+para.designId).val();
						attach_id+=dataObj.attributes.fileKey+",";
						$("#"+para.designId).val(attach_id);
						
						$.funBindDelEvent(para.designId);
                        $.funBindHoverEvent(para.designId);
						/**
						$("#uploadInf").append("<p>上传成功，文件地址是：" + response + "</p>");
						// 根据配置参数确定隐不隐藏上传成功的文件
						if(para.finishDel){
							// 移除效果
							$("#uploadList_" + file.index).fadeOut();
							// 重新设置统计栏信息
							self.funSetStatusInfo(ZYFILE.funReturnNeedFiles());
						}
						*/
					},
					onFailure: function(file) {
						$("#myFileUpload_"+para.designId).find("#uploadProgress_" + file.index).hide();
						$("#myFileUpload_"+para.designId).find("#uploadSuccess_" + file.index).show();
						$("#myFileUpload_"+para.designId).find("#uploadInf").append("<p>文件" + file.name + "上传失败！</p>");	
						//$("#uploadImage_" + file.index).css("opacity", 0.2);
					},
					onComplete: function(response){
						console.info("------------");
						console.info(response);
						
					},
					onDragOver: function() {
						$(this).addClass("upload_drag_hover");
					},
					onDragLeave: function() {
						$(this).removeClass("upload_drag_hover");
					}

				};
				
				ZYFILE = $.extend(ZYFILE, params);
				ZYFILE.init();
			};
			
			/**
			 * 功能：绑定事件
			 * 参数: 无
			 * 返回: 无
			 */
			this.addEvent = function(){
				// 如果快捷添加文件按钮存在
				if($("#myFileUpload_"+para.designId).find(".filePicker").length > 0){
					// 绑定选择事件
					$("#myFileUpload_"+para.designId).find(".filePicker").bind("click", function(e){
						$("#myFileUpload_"+para.designId).find("#fileImage").click();
		            });
				}
	            
				// 绑定继续添加点击事件
				$("#myFileUpload_"+para.designId).find(".webuploader_pick").bind("click", function(e){
					$("#myFileUpload_"+para.designId).find("#fileImage").click();
	            });
				
				// 绑定上传点击事件
				$("#myFileUpload_"+para.designId).find(".upload_btn").bind("click", function(e){
					// 判断当前是否有文件需要上传
					if(ZYFILE.funReturnNeedFiles().length > 0){
						$("#myFileUpload_"+para.designId).find("#fileSubmit").click();
					}else{
						alert("请先选中文件再点击上传");
					}
	            });
				
				// 如果快捷添加文件按钮存在
				if($("#myFileUpload_"+para.designId).find("#rapidAddImg").length > 0){
					// 绑定添加点击事件
					$("#myFileUpload_"+para.designId).find("#rapidAddImg").bind("click", function(e){
						$("#myFileUpload_"+para.designId).find("#fileImage").click();
		            });
				}
			};
			
			
			// 初始化上传控制层插件
			this.init();
		});
	};
})(jQuery);

