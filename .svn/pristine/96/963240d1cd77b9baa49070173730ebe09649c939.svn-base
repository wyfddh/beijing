package com.tj720.mip.controller.front;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.mysql.fabric.xmlrpc.base.Data;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.ICurationService;
import com.tj720.mip.inter.service.table.IMipCommentService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.Curation;
import com.tj720.mip.model.MipComment;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.SortListUtil;
import com.tj720.mip.utils.TimeShowUtil;
import com.tj720.mip.utils.Tools;

@Controller("CurationController")
@RequestMapping("/front/curation")
public class CurationController extends BaseController<Curation> {
	
	@Autowired
	private ICurationService curationService;
	@Autowired
	private IMipCommentService commentService;
	@Autowired
	private IUserService userService;
	@Autowired
	private Config config;
	
	/**
	 * 跳转到我要策展页面
	 * @return curation（取其id）
	 * @throws MyException
	 */
	@RequestMapping("/toCuration.do")
	@ResponseBody
	public JsonResult toCuration() throws MyException {
		try {
			//获取用户信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			if (cacheUser == null) {
				return new JsonResult(new MyException("200000","请先登录！"));
			} else {
				String uid = cacheUser.getId();
				Curation curation = new Curation();
				//获取用户昵称
				User user = userService.get(uid);
				if (!MyString.isEmpty(user)) {
					curation.setAuthor(user.getNickName());
				}
				curation.setUid(uid);
				curation = curationService.save(curation);
				return new JsonResult(1,curation);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	/**
	 * 系列：新建一个策展
	 */
	@RequestMapping("/moreSeries.do")
	@ResponseBody
	public JsonResult moreSeries(String id) throws MyException {
		try {
			if (!MyString.isEmpty(id)) {
				Curation curation = curationService.get(id);
				//获取用户信息
				LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
				if (cacheUser == null) {
					return new JsonResult(new MyException("200000","请先登录！"));
				} 
				String uid = cacheUser.getId();
				Curation newCuration = new Curation();
				newCuration.setUid(uid);
				newCuration.setPid(id);
				newCuration.setTitle(curation.getTitle());
				newCuration.setDescription(curation.getDescription());
				newCuration.setSeriesName(curation.getSeriesName());
				newCuration = curationService.save(newCuration);
				return new JsonResult(1,newCuration);
			}else {
				return new JsonResult(new MyException("id为空"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
		
	}
	
	
	/**
	 * 保存策展
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public JsonResult save(Curation curation,  @RequestParam(defaultValue = "0") int isPublish) throws MyException {
		try {
			if (!MyString.isEmpty(curation.getId())) {
				Curation orgCuration = curationService.get(curation.getId());
				orgCuration.setAuthor(curation.getAuthor());
				orgCuration.setDescription(curation.getDescription());
				orgCuration.setTitle(curation.getTitle());
				orgCuration.setSeriesName(curation.getSeriesName());
				orgCuration.setSeriesDescription(curation.getSeriesDescription());
				orgCuration.setSeriesNum(curation.getSeriesNum());
				orgCuration.setImage1(curation.getImage1());
				orgCuration.setImage2(curation.getImage2());
				orgCuration.setImage3(curation.getImage3());
				orgCuration.setImage4(curation.getImage4());
				orgCuration.setImage5(curation.getImage5());
				orgCuration.setImage6(curation.getImage6());
				orgCuration.setImage7(curation.getImage7());
				orgCuration.setImage8(curation.getImage8());
				orgCuration.setImage9(curation.getImage9());
				orgCuration.setImage10(curation.getImage10());
				orgCuration.setImage11(curation.getImage11());
				orgCuration.setImage12(curation.getImage12());
				orgCuration.setAudio(curation.getAudio());
				//判断是否发布
				/*if (isPublish == 0) {
					//仅保存，不发布
					orgCuration.setIsPublished((byte)0);
				}
				if (isPublish == 1) {
					//保存并发布
					orgCuration.setIsPublished((byte)1);
				}*/
				
				if (!MyString.isEmpty(orgCuration.getUid())) {
					curationService.update(orgCuration);
					return new JsonResult(1, "保存成功");
				} else {
					return new JsonResult(0, "保存失败");
				}
			}else {
				return new JsonResult(0, "保存失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
		
	}
	
	
	/**
	 * 发布整个系列策展
	 */
	@RequestMapping("/publishAll.do")
	@ResponseBody
	public JsonResult publishAll(String id) throws MyException {
		try {
			if (!MyString.isEmpty(id)) {
				List<Curation> curList = (List<Curation>) curationService.queryByHql("from Curation where status>0 and (id='"+id+"' or pid='"+id+"')", Tools.getMap());
				if (!MyString.isEmpty(curList)) {
					for (Curation curation : curList) {
						curation.setIsPublished((byte)1);
						curationService.update(curation);
					}
					return new JsonResult(1, "发布成功");
				}else {
					return new JsonResult(0, "发布失败");
				}
			}else {
				return new JsonResult(0, "没有发布内容或id为空");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	
	/**
	 * 取消发布整个系列策展
	 */
	@RequestMapping("/nonPublish.do")
	@ResponseBody
	public JsonResult nonPublish(String id) throws MyException {
		try {
			if (!MyString.isEmpty(id)) {
				List<Curation> curList = (List<Curation>) curationService.queryByHql("from Curation where status>0 and (id='"+id+"' or pid='"+id+"')", Tools.getMap());
				if (!MyString.isEmpty(curList)) {
					for (Curation curation : curList) {
						curation.setIsPublished((byte)0);
						curationService.update(curation);
					}
					return new JsonResult(1, "取消发布成功");
				}else {
					return new JsonResult(0, "取消发布失败");
				}
			}else {
				return new JsonResult(0, "没有取消发布内容或id为空");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	/**
	 * 策展列表页
	 */
	@RequestMapping("/curList.do")
	@ResponseBody
	public JsonResult curList(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "0") int order) throws MyException {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			String hql = "from Curation where status > 0 and isPublished = 1 and pid = ''";
			if (order == 0) {
				hql += " order by createTime desc";
			}
			if (order == 1) {
				hql += " order by likeCounts desc";
			}
			List<Curation> curList = (List<Curation>) curationService.queryByHql(hql, Tools.getMap(),page);
			//通过id获取此系列所有的策展
			if (!MyString.isEmpty(curList)) {
				//遍历集合，获取评论数目
				for (Curation curation : curList) {
					//设置是否为系列展
					List<Curation> serList = (List<Curation>) curationService.queryByHql("from Curation where status > 0 and isPublished = 1 and pid='"+curation.getId()+"'", Tools.getMap());
					if (!MyString.isEmpty(serList)) {
						curation.setIsSeries(1);
					}else {
						curation.setIsSeries(0);
					}
					//统计评论次数
					String comHql = "select count(*) from MipComment where status > 0 and cid = '" + curation.getId() + "'";
					List<Long> counts = (List<Long>) commentService.queryByHql(comHql, Tools.getMap());
					curation.setCommentCounts(counts.get(0));//设置评论数目
					String uid = curation.getUid();
					User user = userService.get(uid);
					curation.setUserName(user.getNickName());//设置策展人
					//设置显示主图
					if (!MyString.isEmpty(curation.getImage1())) {
						curation.setMainImage(curation.getImage1());
					}else {
						if (!MyString.isEmpty(curation.getImage2())) {
							curation.setMainImage(curation.getImage2());
						}else {
							if (!MyString.isEmpty(curation.getImage3())) {
								curation.setMainImage(curation.getImage3());
							}else {
								if (!MyString.isEmpty(curation.getImage4())) {
									curation.setMainImage(curation.getImage4());
								}else {
									if (!MyString.isEmpty(curation.getImage5())) {
										curation.setMainImage(curation.getImage5());
									}else {
										if (!MyString.isEmpty(curation.getImage6())) {
											curation.setMainImage(curation.getImage6());
										}else {
											if (!MyString.isEmpty(curation.getImage7())) {
												curation.setMainImage(curation.getImage7());
											}else {
												if (!MyString.isEmpty(curation.getImage8())) {
													curation.setMainImage(curation.getImage8());
												}else {
													if (!MyString.isEmpty(curation.getImage9())) {
														curation.setMainImage(curation.getImage9());
													}else {
														if (!MyString.isEmpty(curation.getImage10())) {
															curation.setMainImage(curation.getImage10());
														}else {
															if (!MyString.isEmpty(curation.getImage11())) {
																curation.setMainImage(curation.getImage11());
															}else {
																if (!MyString.isEmpty(curation.getImage12())) {
																	curation.setMainImage(curation.getImage12());
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			map.put("page", page);
			map.put("curList", curList);
			map.put("rootUrl", config.getRootUrl());
			return new JsonResult(1, map);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	/**
	 * 我的策展列表页
	 */
	@RequestMapping("/myCurations.do")
	@ResponseBody
	public JsonResult myCurations(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "0") int isPublished) throws MyException {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			// 获取用户信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			if (cacheUser == null) {
				return new JsonResult(new MyException("200000", "请先登录！"));
			} else {
				String userid = cacheUser.getId();
				Page page = new Page();
				page.setCurrentPage(currentPage);
				page.setSize(size);
				String hql = "from Curation where seriesName != '' and uid = '" + userid + "' and status > 0 and isPublished = " + isPublished + " and pid = ''";
				List<Curation> curList = (List<Curation>) curationService.queryByHql(hql, Tools.getMap(), page);
				// 通过id获取此系列所有的策展
				if (!MyString.isEmpty(curList)) {
					// 遍历集合，获取评论数目
					for (Curation curation : curList) {
						// 设置是否为系列展
						List<Curation> serList = (List<Curation>) curationService.queryByHql(
								"from Curation where status > 0 and isPublished = 1 and pid='" + curation.getId() + "'",
								Tools.getMap());
						if (!MyString.isEmpty(serList)) {
							curation.setIsSeries(1);
						} else {
							curation.setIsSeries(0);
						}
						// 统计评论次数
						String comHql = "select count(*) from MipComment where status > 0 and cid = '"
								+ curation.getId() + "'";
						List<Long> counts = (List<Long>) commentService.queryByHql(comHql, Tools.getMap());
						curation.setCommentCounts(counts.get(0));// 设置评论数目
						String uid = curation.getUid();
						User user = userService.get(uid);
						curation.setUserName(user.getNickName());// 设置策展人
						// 设置显示主图
						if (!MyString.isEmpty(curation.getImage1())) {
							curation.setMainImage(curation.getImage1());
						} else {
							if (!MyString.isEmpty(curation.getImage2())) {
								curation.setMainImage(curation.getImage2());
							} else {
								if (!MyString.isEmpty(curation.getImage3())) {
									curation.setMainImage(curation.getImage3());
								} else {
									if (!MyString.isEmpty(curation.getImage4())) {
										curation.setMainImage(curation.getImage4());
									} else {
										if (!MyString.isEmpty(curation.getImage5())) {
											curation.setMainImage(curation.getImage5());
										} else {
											if (!MyString.isEmpty(curation.getImage6())) {
												curation.setMainImage(curation.getImage6());
											} else {
												if (!MyString.isEmpty(curation.getImage7())) {
													curation.setMainImage(curation.getImage7());
												} else {
													if (!MyString.isEmpty(curation.getImage8())) {
														curation.setMainImage(curation.getImage8());
													} else {
														if (!MyString.isEmpty(curation.getImage9())) {
															curation.setMainImage(curation.getImage9());
														} else {
															if (!MyString.isEmpty(curation.getImage10())) {
																curation.setMainImage(curation.getImage10());
															} else {
																if (!MyString.isEmpty(curation.getImage11())) {
																	curation.setMainImage(curation.getImage11());
																} else {
																	if (!MyString.isEmpty(curation.getImage12())) {
																		curation.setMainImage(curation.getImage12());
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				map.put("page", page);
				map.put("curList", curList);
				map.put("rootUrl", config.getRootUrl());
				return new JsonResult(1, map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	/**
	 * 策展详情页（策展内容）
	 */
	@RequestMapping("/curDetail.do")
	@ResponseBody
	public JsonResult curDetail(String id) throws MyException {
		try {
			if (!MyString.isEmpty(id)) {
				List<Curation> curList = null;
				if (!MyString.isEmpty(id)) {
					curList = (List<Curation>) curationService.queryByHql("from Curation where status > 0 and (id='"+id+"' or pid='"+id+"') order by seriesNum", Tools.getMap());
					if (curList.size() >= 1) {
						for (Curation cur : curList) {
							String uid = cur.getUid();
							User user = userService.get(uid);
							cur.setUserName(user.getNickName());
							String rootUrl = config.getRootUrl();
							cur.setImage1(rootUrl+cur.getImage1());
							cur.setImage2(rootUrl+cur.getImage2());
							cur.setImage3(rootUrl+cur.getImage3());
							cur.setImage4(rootUrl+cur.getImage4());
							cur.setImage5(rootUrl+cur.getImage5());
							cur.setImage6(rootUrl+cur.getImage6());
							cur.setImage7(rootUrl+cur.getImage7());
							cur.setImage8(rootUrl+cur.getImage8());
							cur.setImage9(rootUrl+cur.getImage9());
							cur.setImage10(rootUrl+cur.getImage10());
							cur.setImage11(rootUrl+cur.getImage11());
							cur.setImage12(rootUrl+cur.getImage12());
							cur.setAudio(rootUrl+cur.getAudio());
						}
					}
				}
				return new JsonResult(1, curList);
				
			}else {
				return new JsonResult(0, "未传id 或 id不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	/**
	 * 策展详情页（评论内容:所有评论）
	 */
	@RequestMapping("/comDetail.do")
	@ResponseBody
	public JsonResult comDetail(String id, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int currentPage) throws MyException {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			//通过id获取此系列所有的策展
			if (!MyString.isEmpty(id)) {
				List<Curation> curList = (List<Curation>) curationService.queryByHql("from Curation where status > 0 and (id='"+id+"' or pid='"+id+"')", Tools.getMap());
				//获取所有的id成字符串
				String cids = "";
				if (!MyString.isEmpty(curList)) {
					for (Curation curation : curList) {
						cids += "'"+curation.getId()+"',";
					}
				}
				cids = cids.substring(0, cids.length()-1);
				String hql = "from MipComment where status > 0 and cid in (" + cids + ") order by publishTime desc";
				List<MipComment> comList = (List<MipComment>) commentService.queryByHql(hql, Tools.getMap(), page);
				for (MipComment mipComment : comList) {
					String uid = mipComment.getUid();
					User user = userService.get(uid);
					mipComment.setUserName(user.getNickName());//设置昵称
					if (!MyString.isEmpty(user.getAvatarUrl())) {
						mipComment.setAvatarUrl(config.getRootUrl() + user.getAvatarUrl());//设置头像路径
					}else {
						mipComment.setAvatarUrl("");//设置头像路径
					}
//					String publishTimeStr = sim.format(new Date(mipComment.getPublishTime()));
					Long currentTime = System.currentTimeMillis();
					Long publishTime = mipComment.getPublishTime();
					String publishTimeStr = TimeShowUtil.plTime(currentTime, publishTime);
					mipComment.setPublishTimeStr(publishTimeStr);//设置时间
				}
				map.put("page", page);
				map.put("comList", comList);
				return new JsonResult(1,map);
			}else {
				return new JsonResult(0, "未传id 或 id不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	
	/**
	 * 保存评论
	 */
	@RequestMapping("/saveComment.do")
	@ResponseBody
	public JsonResult saveComment(MipComment mipComment, String cid) throws MyException {
		try {
			//获取用户信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			if (cacheUser == null) {
				return new JsonResult(new MyException("200000","请先登录！"));
			} else {
				String uid = cacheUser.getId();
				mipComment.setUid(uid);
				mipComment.setCid(cid);
				long publishTime = System.currentTimeMillis();
				mipComment.setPublishTime(publishTime);
				mipComment = commentService.save(mipComment);
				return new JsonResult(1,"保存成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	/**
	 * 跳转到策展修改（编辑）页面
	 */
	@RequestMapping("/toUpdate.do")
	@ResponseBody
	public JsonResult toUpdate(String id) throws MyException {
		try {
			//获取用户信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			//创建map保存数据
			Map<String, Object> map = new HashMap<String, Object>();
			if (cacheUser == null) {
				return new JsonResult(new MyException("200000","请先登录！"));
			} else {
				//此系列所有策展
				List<Curation> curList = (List<Curation>) curationService.queryByHql("from Curation where status > 0 and (id='"+id+"' or pid='"+id+"') order by seriesNum", Tools.getMap());
				String rootUrl = config.getRootUrl();
				for (Curation curation : curList) {
					curation.setAudioUrl(rootUrl + curation.getAudio());
				}
				map.put("curList", curList);
				map.put("rootUrl", rootUrl);
				return new JsonResult(1, map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	/**
	 * 修改策展信息
	 * @param curation
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/updateCur.do")
	@ResponseBody
	public JsonResult updateCur(Curation curation) throws MyException {
		try {
			//获取用户信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			if (cacheUser == null) {
				return new JsonResult(new MyException("200000","请先登录！"));
			} else {
				//获取原信息
				Curation orgCuration = curationService.get(curation.getId());
				//修改信息
				if (!MyString.isEmpty(orgCuration)) {
					if (curation.getSeriesNum() == 1) {
						orgCuration.setSeriesName(curation.getSeriesName());
						orgCuration.setSeriesDescription(curation.getSeriesDescription());
						orgCuration.setAuthor(curation.getAuthor());
					}
					orgCuration.setTitle(curation.getTitle());
					orgCuration.setDescription(curation.getDescription());
					orgCuration.setImage1(curation.getImage1());
					orgCuration.setImage2(curation.getImage2());
					orgCuration.setImage3(curation.getImage3());
					orgCuration.setImage4(curation.getImage4());
					orgCuration.setImage5(curation.getImage5());
					orgCuration.setImage6(curation.getImage6());
					orgCuration.setImage7(curation.getImage7());
					orgCuration.setImage8(curation.getImage8());
					orgCuration.setImage9(curation.getImage9());
					orgCuration.setImage10(curation.getImage10());
					orgCuration.setImage11(curation.getImage11());
					orgCuration.setImage12(curation.getImage12());
					orgCuration.setAudio(curation.getAudio());
					//修改
					curationService.update(orgCuration);
					return new JsonResult(1, "修改成功");
				}else {
					return new JsonResult(new MyException("id不存在"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	/**
	 * 点赞功能
	 */
	@RequestMapping("/like.do")
	@ResponseBody
	public JsonResult like(String id) throws MyException {
		try {
			if (!MyString.isEmpty(id)) {
				Curation curation = curationService.get(id);
				curation.setLikeCounts(curation.getLikeCounts() + 1);
				curationService.update(curation);
				return new JsonResult(1, "点赞成功！");
			}else {
				return new JsonResult(0, "未传id 或 id不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	/**
	 * 删除功能
	 */
	@RequestMapping("/del.do")
	@ResponseBody
	public JsonResult del(String id) throws MyException {
		try {
			if (!MyString.isEmpty(id)) {
				Curation curation = curationService.get(id);
				//假删除
				curation.setStatus((byte)-127);
				curationService.update(curation);
				//真删除
//				curationService.delete(curation);
				return new JsonResult(1, "删除成功！");
			}else {
				return new JsonResult(0, "未传id 或 id不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	/**
	 * 我的评论
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/myComments.do")
	@ResponseBody
	public JsonResult myComments(@RequestParam(defaultValue = "6") int size, @RequestParam(defaultValue = "1") int currentPage) throws MyException {
		try {
			//获取用户信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			//page
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			
			if (cacheUser == null) {
				return new JsonResult(new MyException("200000","请先登录！"));
			} else {
				String uid = cacheUser.getId();
				List<MipComment> myComments = (List<MipComment>) commentService.queryByHql("from MipComment where status > 0 and uid = '"+uid+"' order by publishTime desc", Tools.getMap(), page);
				if (!MyString.isEmpty(myComments)) {
					for (MipComment mipComment : myComments) {
						String cid = mipComment.getCid();
						Curation curation = curationService.get(cid);
						mipComment.setCurName(curation.getSeriesName());//设置评论对象名称
						//设置评论数目
						List<Long> totalComments = (List<Long>) commentService.queryByHql("select count(*) from MipComment where status > 0 and cid='" + cid + "'", Tools.getMap());
						if (!MyString.isEmpty(totalComments)) {
							mipComment.setTotalComm(totalComments.get(0));
						}else {
							mipComment.setTotalComm(0L);
						}
						//设置评论时间
						Date date = new Date(mipComment.getPublishTime());
						String dateToString = DateUtil.DateToString(date, DateStyle.YYYY_MM_DD);
						mipComment.setPublishTimeStr(dateToString);
					}
				}
				return new JsonResult(1, myComments, page);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	/**
	 * 评论我的
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/commMine.do")
	@ResponseBody
	public JsonResult commMine(@RequestParam(defaultValue = "6") int size, @RequestParam(defaultValue = "1") int currentPage) throws MyException {
		try {
			//获取用户信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			//page
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			
			List<MipComment> comments = new ArrayList<MipComment>();
			if (cacheUser == null) {
				return new JsonResult(new MyException("200000","请先登录！"));
			} else {
				String uid = cacheUser.getId();
				List<Curation> myCurations = (List<Curation>) curationService.queryByHql("from Curation where status > 0 and uid = '"+uid+"'", Tools.getMap());
				StringBuffer sBuffer = new StringBuffer();
				if (!MyString.isEmpty(myCurations)) {
					for (Curation curation : myCurations) {
						String cid = curation.getId();
						sBuffer.append("'").append(cid).append("',");
					}
				}
				String cids = sBuffer.toString();
				List<MipComment> cidComments = new ArrayList<MipComment>();
				if (!MyString.isEmpty(cids)) {
					cids = cids.substring(0,cids.length()-1);
					cidComments = (List<MipComment>) commentService
							.queryByHql("from MipComment where status > 0 and cid in (" + cids + ")", Tools.getMap(), page);
				}
				//获取评论
				if (!MyString.isEmpty(cidComments)) {
					for (MipComment comm : cidComments) {
						String uid2 = comm.getUid();
						User user = userService.get(uid2);
						if (!MyString.isEmpty(user)) {
							comm.setUserName(user.getNickName());// 设置评论人昵称
							if (!MyString.isEmpty(user.getAvatarUrl())) {
								comm.setAvatarUrl(config.getRootUrl()+user.getAvatarUrl());// 设置评论人头像
							}else {
								comm.setAvatarUrl("");
							}
						} else {
							comm.setUserName("");
							comm.setAvatarUrl("");
						}
						// 设置评论时间
						Date date = new Date(comm.getPublishTime());
						String dateToString = DateUtil.DateToString(date, DateStyle.YYYY_MM_DD);
						comm.setPublishTimeStr(dateToString);
						// 设置评论策展名
						Curation curation = curationService.get(comm.getCid());
						comm.setCurName(curation.getSeriesName());
						comments.add(comm);
					}
				}
				//按发布时间倒序排
				SortListUtil.sort(comments, "publishTime",SortListUtil.DESC);
				return new JsonResult(1, comments, page);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new MyException("000001"));
		}
	}
	
	
	
}
