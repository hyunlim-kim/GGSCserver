package com.test.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.bean.MemberBean;
import com.test.web.dao.MemberDao;

@Controller
public class RESTController {

	@Autowired
	private MemberDao memberDao;


	//DB-->Bean-->JSON
	@RequestMapping("/rest/selectMember")
	@ResponseBody
	public Map<String, Object> selectMember(MemberBean mBean){

		Map<String,Object> resMap = new HashMap<String, Object>();

		try {
			MemberBean bBean  = memberDao.selectMember(mBean);

			resMap.put("result", "OK");
			resMap.put("memberBean",bBean);

		}catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}
		return resMap;

	}//end selectMember



	//DB-->Bean-->JSON
	@RequestMapping("/rest/selectMemberList")
	@ResponseBody
	public Map<String, Object> selectMemberList(){

		Map<String,Object> resMap = new HashMap<String, Object>();

		try {
			List<MemberBean> list = memberDao.selectMemberList();

			resMap.put("result", "OK");
			resMap.put("memberList",list);

		}catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}
		return resMap;

	}//end selectMemberList

	//DB-->Bean-->JSON
	@RequestMapping("/rest/insertMember")
	@ResponseBody
	public Map<String, Object> insertMember(MemberBean mBean){

		Map<String,Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			int resVal = memberDao.insertMember(mBean);


			if(resVal > 0) {
				resMap.put("memberBean",mBean);
				resMap.put("result", "OK");
			}
		}
		catch(DuplicateKeyException dke) {
			resMap.put("resultMsg","이미 존재하는 USER_ID입니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg",e.getMessage());


		}
		return resMap;

	}//end insertMember


	//DB-->Bean-->JSON
	@RequestMapping("/rest/updateMember")
	@ResponseBody
	public Map<String, Object> updateMember(MemberBean mBean){

		Map<String,Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			int resVal = memberDao.updateMember(mBean);


			if(resVal > 0) {
				resMap.put("result", "OK");
				resMap.put("resultMsg","업데이트에 성공하였습니다.");
			}
			else {
				resMap.put("resultMsg", "존재하지 않는 USER_ID 입니다. ");
			}
		}

		catch(Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg",e.getMessage());


		}
		return resMap;

	}//end insertMember

	//DB-->Bean-->JSON
	@RequestMapping("/rest/deleteMember")
	@ResponseBody
	public Map<String, Object> deleteMember(MemberBean mBean){

		Map<String,Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			int resVal = memberDao.deleteMember(mBean);


			if(resVal > 0) {
				resMap.put("result", "OK");
				resMap.put("resultMsg","삭제에 성공하였습니다.");
			}
			else {
				resMap.put("resultMsg", "존재하지 않는 USER_ID 입니다. ");
			}
		}

		catch(Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg",e.getMessage());


		}
		return resMap;

	}//end deleteMember


}//end RESTController
