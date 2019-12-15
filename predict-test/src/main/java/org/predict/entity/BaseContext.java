package org.predict.entity;

public class BaseContext {
	 private String rankId;

	    private long userId;

	    /**
	     * 用户画像
	     */
	    private UserPersona userPersona;

	    private int cityId;

	    /**
	     * ab信息
	     */
	    private ABInfo abInfo;

	    /**
	     * 预测模型名
	     */
	    private String modelName;

}
