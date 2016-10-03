package com.cx.bank.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.config.ForwardConfig;

import com.cx.bank.exception.InvalidDepositException;
import com.cx.bank.exception.InvalidTransferException;
import com.cx.bank.exception.IsRegisterException;
import com.cx.bank.exception.NoUserException;
import com.cx.bank.model.MoneyActionForm;
import com.cx.bank.model.MoneyBean;
import com.cx.bank.service.ManagerInterface;

public class BankAction extends DispatchAction {
	
	private ManagerInterface managerImpl;
	
	public ManagerInterface getManagerImpl() {
		return managerImpl;
	}

	public void setManagerImpl(ManagerInterface managerImpl) {
		this.managerImpl = managerImpl;
	}


	/**
	 * 注册功能
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public ActionForward register(ActionMapping mapping,ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMsg = null;
		boolean result = false;
		ActionForward forward = new ActionForward();
		MoneyActionForm mac = (MoneyActionForm) form;
		MoneyBean mb = new MoneyBean();
		try {
			BeanUtils.copyProperties(mb, mac);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(mb);
		try {
			result = managerImpl.register(mb);
		} catch (IsRegisterException e) {
			errorMsg = e.getMessage();
		}
		if (!result) {
			request.setAttribute("errorMsg", errorMsg);
			forward.setPath("/zhuce.jsp");
			return forward;
		}
		
		forward.setPath("/denglu.jsp");
		return forward;
	}


	/**
	 * 登入
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public ForwardConfig login(ActionMapping mapping,ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMsg = null;
		boolean result = false;
		ActionForward forward = new ActionForward();
		MoneyActionForm mac = (MoneyActionForm) form;
		MoneyBean mb = new MoneyBean();
		try {
			BeanUtils.copyProperties(mb, mac);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(mb);
		try {
			result = managerImpl.login(mb);
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg = e.getMessage();
		}
		if (!result) {
			request.setAttribute("errorMsg", errorMsg);
			forward.setPath("/denglu.jsp");
			return forward;
		}
		HttpSession session = request.getSession();
		session.setAttribute("username", mac.getUserName());
		forward.setPath("/WEB-INF/mdd/main.jsp");
		return forward;
	}

	/**
	 * 转发页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public ForwardConfig toView( ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = request.getParameter("view");
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/mdd/" + view + ".jsp");
		return forward;
	}

	/**
	 * 查询余额
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public ActionForward chaxun( ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String username = request.getParameter("username");
		double money = managerImpl.inquiry(username);
		request.setAttribute("money", money);
		forward.setPath("/WEB-INF/mdd/chaxun.jsp");
		return forward;
	}

	/**
	 * 转账查询是否存在
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public ActionForward checkIsExistToUser(ActionMapping mapping,
			ActionForm form,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		if (managerImpl.checkIsExistToUser(username)) {
			pw.print(1);
		} else {
			pw.print(0);
		}
		return null;
	}

	/**
	 * 存款
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public ActionForward cunkuan(ActionMapping mapping,ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/mdd/cunkuan.jsp");
		String errorMsg = null;
		boolean result = false;
		String username = (String) request.getSession()
				.getAttribute("username");
		String cunMoney = request.getParameter("cunMoney");
		double money = managerImpl.inquiry(username);
		MoneyBean mb = new MoneyBean();
		mb.setUserName(username);
		mb.setMoney(Double.parseDouble(cunMoney) + money);
		try {
			result = managerImpl.deposit(mb);
		} catch (InvalidDepositException e) {
			errorMsg = e.getMessage();
		}
		if (!result) {
			request.setAttribute("errorMsg", errorMsg);
			return forward;
		}
		request.setAttribute("money", Double.parseDouble(cunMoney) + money);
		request.setAttribute("errorMsg", "存款成功！");
		return forward;

	}

	/**
	 * 取款
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public ActionForward qukuan( ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/mdd/qukuan.jsp");
		String errorMsg = null;
		boolean result = false;
		String username = (String) request.getSession()
				.getAttribute("username");
		String quMoney = request.getParameter("quMoney");
		double money = managerImpl.inquiry(username);
		MoneyBean mb = new MoneyBean();
		mb.setUserName(username);
		mb.setMoney(money - Double.parseDouble(quMoney));
		try {
			result = managerImpl.withdrawals(mb);
		} catch (InvalidDepositException e) {
			System.out.println(e.getMessage());
			errorMsg = e.getMessage();
		}
		if (!result) {
			request.setAttribute("errorMsg", errorMsg);
			return forward;
		}
		request.setAttribute("money", money - Double.parseDouble(quMoney));
		request.setAttribute("errorMsg", "取款成功！");
		return forward;

	}

	/**
	 * 转账
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public ActionForward zhuanzhang( ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/mdd/zhuanzhang.jsp");
		String errorMsg = null;
		boolean result = false;
		String toUserName = request.getParameter("toUserName");
		String username = (String) request.getSession()
				.getAttribute("username");
		String zhuanMoney = request.getParameter("zhuanMoney");
		double mymoney = managerImpl.inquiry(username);
		double zmoney = Double.parseDouble(zhuanMoney);
		try {
			result = managerImpl.transfer(username, zmoney, toUserName);
		} catch (InvalidTransferException e) {
			System.out.println(e.getMessage());
			errorMsg = e.getMessage();
		} catch (NoUserException e) {
			e.printStackTrace();
		}
		if (!result) {
			request.setAttribute("errorMsg", errorMsg);
			return forward;
		}
		request.setAttribute("money", mymoney - zmoney);
		request.setAttribute("errorMsg", "转账成功！");
		return forward;

	}

	/**
	 * 注销
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public ActionForward loginOut(ActionMapping mapping,ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("denglu.jsp");
		HttpSession session = request.getSession();
		session.invalidate();
		return forward;

	}
	
	
	@SuppressWarnings("static-access")
	public ActionForward changelanguage(ActionMapping mapping,ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String language = request.getParameter("language");
		System.out.println(language);
		Locale locale = Locale.getDefault();
		if("en".equals(language)){
			locale.setDefault(new Locale("en","US"));
		}else if("zh".equals(language)){
			locale.setDefault(new Locale("zh","CN"));
		}
		this.setLocale(request, locale);
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/mdd/main.jsp");
		return forward;

	}
	
//	public static void main(String[] args) {
//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
//		ManagerImpl m = (ManagerImpl) ac.getBean("managerImpl");
//		System.out.println(m.inquiry("xwl"));
//	}
//	
}
