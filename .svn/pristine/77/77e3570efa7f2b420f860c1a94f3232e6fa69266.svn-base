package com.tj720.mip.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.ICommentService;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.model.Comment;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.Tools;

@Controller("frontCommentController")
@RequestMapping("/front/comment")
public class CommentController extends BaseController<Comment> {
	@Autowired
	private ICacheService cacheService;

	@Autowired
	private ICommentService commentService;

	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult addOrUpdate(@ModelAttribute Comment comment) throws MyException {
		if (cacheService.getSetting(Const.SETTING_COMMENTCODE).getValue().equals("true")) {
			if (!comment.getId().equals(Tools.getImgCode(request))) {
				throw new MyException("000010");
			}
		}
		LoginInfoDto user = Tools.getUser();
		if(user != null)
			comment.setUserId(user.getId());
		
		comment.setId(null);
		comment.setUpdateTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
		commentService.save(comment);
		
		cacheService.delObj( Const.CACHE_COMMENTLIST + comment.getArticleId());
		cacheService.delObj( Const.CACHE_COMMENT_PAGE + comment.getArticleId());
		
		return new JsonResult(1, null);
	}
}
