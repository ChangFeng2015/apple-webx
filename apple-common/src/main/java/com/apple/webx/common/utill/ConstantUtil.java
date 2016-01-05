/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.apple.webx.common.utill;

import java.math.BigDecimal;

/**
 * 静态文件配置
 * 
 * @author Jndong
 * 
 * @version 0.1
 *
 */
public class ConstantUtil {

	public static final String IS_START_JOB_YES = "yes";

	public static final String URL_HOME_MODULE = "homeModule";

	public static final String URL_USER_MODULE = "userModule";

	public static final String URL_PAY_MODULE = "payModule";

	public static final String URL_ORDER_MODULE = "orderModule";

	public static final String IS_DELETE_N = "n";

	public static final String IS_DELETE_Y = "y";

	public static final String PROPERTY = "propertie";

	public static final String PROPERTY_SELECT = "select";

	public static final String PROPERTY_CHECKBOX = "checkbox";

	public static final String PROPERTY_INPUT = "input";

	public static final String IMG_FILE_URL = "http://cdn.packtwo.com/";

	// 数据字典Type定义
	public static final String DICTIONARY_SPLIT = ",";

	// DataDictionary中wirte的方式
	public static final String WRITE_BY_NAME = "name";
	public static final String WRITE_BY_TYPE = "type";

	/**
	 * 爬虫数据类型
	 * 
	 */
	public static enum REPTILE_TYPE {
		TYPE_ALIEXPRESS, // 数买通
		TYPE_1688 // 1688
	}

	/**
	 * 商品状态
	 */
	public static enum COMMODITY_STATUS {
		RELEASE, // 发布
		CREATE, // 创建
		Shelves, // 下架
		DELETE, // 删除
		CONFIRM, // 审核
		RESELLER, // 代售商品
	}
	
	/**
	 * 商品上传图片的域名地址
	 */
	public static String[] IMG_DOMAIN = {"img3","cdn","img2"};
	

	/**
	 * 支付记录交易类型
	 *
	 */
	public static enum PAY_TRANSACTION_TYPE {
		ORDER_PAY, // 订单支付
		WITHDRAWALS, // 提现
		TOP, // 充值
	}

	/**
	 * 支付交易Name类型
	 */
	public static enum PAY_TRANSACTION_NAME_TYPE {
		SHOP // 店铺支付
	}

	/***
	 * 数据检查KEY
	 */
	public static enum CHECK_KEY {
		ORDER_CHECK, // 订单检查
	}

	/**
	 * 实际支付方式类型
	 * 
	 */
	public static enum PAYMENTS_TYPE {
		TT, // TT 支付
		PAYPAL, // PAYPAL 支付
		BALANCE, // 余额
	}

	public static enum PAYPAL_STATUS {
		CREATE, // 创建
		SUCCESS, // 成功
		BACK, // 退款
		ERROR, // 失败
		Close, // 关闭
	}

	public static enum PAY_STATUS {
		CREATE, // 订单创建
		SUCCESS, // 支付成功
		CHECK, // 审核中
		Close, // 支付订单关闭
	}

	/**
	 * 支付资金明细状态
	 */
	public static enum PAY_MONEY_STATUS {
		SUBMIT_CHECK, // 提交 等待 校验
		FREEZE, // 资金暂时冻结
		ADDUCTION_SUCCESS, // 内转成功
		BACK, // 资金回退
		INVALID, // 无效
		TIMEOUT // 过期
	}

	public static enum PAY_MONEY_TT_STATUS {
		CHECK, // 等待检查
		SUCCESS, // 对账通过
		TOP, // 对账不通过 进行充值
		NOT_THROUGH // 对账不通过
	}

	/**
	 * 订单状态
	 * 
	 */
	public static enum ORDER_STATUS {
		SUBMIT, // 提交(等待卖家确认)
		CHECK, // 卖家审核（卖家已确认，等待买家付款）
		PAY_TT_CHECK, // TT支付审核中
		PAY, // 付款（买家已付款，等待卖家发货）
		DELIVERY, // 发货
		RECEIVING, // 买家收货
		// PAY_OVERTIME, // 支付超时
		// SUCCESS, // 买家确认

		// 订单自动超时
		ORDERS_TIMEOUT_CHECK, // 卖家确认超时
		ORDERS_TIMEOUT_PAY, // 付款超时
		ORDERS_TIMEOUT_TT, // TT付款超时
		ORDERS_TIMEOUT_PP, // PP支付风控超时
		ORDERS_TIMEOUT_DELIVERY, // 发货超时
		ORDERS_TIMEOUT_RECEIVING// 收货超时
	}

	/**
	 * 订单超时时间
	 */
	// 卖家确认超时时间(7天)
	public static int ORDER_TIMEOUT_CHECK = 7;
	// public static Long ORDER_TIMEOUT_SELLER = 604800000L; //7天
	// (1000*3600*24*7)
	// 支付超时时间(15天)
	public static int ORDER_TIMEOUT_PAY = 15;
	// 收货确认超时时间(60天)
	public static int ORDER_TIMEOUT_RECEIVING = 60;

	// 单笔订单的最大金额
	public static BigDecimal ORDER_MAX_PRICE = new BigDecimal(45000);

	// 购物车中的最大SPU数
	public static int CART_MAX_SPU = 100;

	// paypal过期时间
	public static Long PAYPAL_TIME_OUT = 900000L; // 1000*60*15 15分钟

	/**
	 * 支付订单类型
	 */
	public static enum PAY_ORDER_TYPE {
		FLOW_INTO, // 流入
		OUT_FLOW, // 流出
		ADDUCTION // 内转
	}

	/***
	 * 
	 * 支付数据 类型
	 */
	public static enum PAY_DATA_ORDER_TYPE {
		GENERAL_ORDER, // 普通订单支付

	}

	public static enum PAY_ORDER_STATUS {

	}

	/**
	 * 客户等级
	 */
	public static enum CUSTOMER_RATING {
		A, B, C, D, T,
	}

	/**
	 * 卖家状态
	 */
	public static enum SELLER_STATUS {
		CREATE, // 创建
		VERIFY, // 审核
		OPEN // 通过
	}

	/**
	 * 卖家入驻状态
	 */
	public static enum SELLER_REGISTER_STATUS {
		CREATE, // 创建
		reviewSuccess, // 审核通过
		reviewFailed, // 审核不通过
		submitSuccess, // 提交成功
		submitBrand, // 提交品牌
		sign, // 协议
		pay, // 缴费
		information, // 公司信息
		finish, // 注册完成
		submitPay, // 提交支付
		paySuccess, // 支付审核成功
		payFailed, // 支付审核失败

	}

	/**
	 * 品牌入驻状态
	 * 
	 * @author SmallFish
	 *
	 */
	public static enum BRAND_STATUS {
		CHECK, // 提交新品牌等待审核
		CREATE, // 创建
		noPass, // 审核不通过
		OPEN// 审核通过
	}

	/**
	 * 卖家注册后的数据初始化
	 * 
	 * @author lothar
	 *
	 */
	public static enum SELLE_REGISTER_DATA_INITIAL {
		site, // 数据初始化
	}

	/**
	 * 爬虫的状态
	 * 
	 * @author SmallFish
	 *
	 */
	public static enum REPTITLE_STATUS {
		CREATE, // 添加
		START, // 待爬取
		SUCCESS, // 成功
		EROOR // 失败
	}
	/**
	 * 站内信--消息状态
	 */
	public static int MESSAGE_DRAFT = 10;
	
	public static int MESSAGE_SENDED = 20;
	
	public static int MESSAGE_UNREADED = 30;
	
	public static int MESSAGE_READED = 40;
	
	public static int MESSAGE_REPLYED = 50;
	
	public static int MESSAGE_DELETED = 60;
}
