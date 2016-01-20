package com.kingsoft.services.handlers;

import com.kingsoft.services.http.HttpResponse;

public interface HttpResponseHandler<T> {

	/**
	 * 处理http响应结果，返回T类型对象
	 * 
	 * @param response
	 *            http响应结果
	 * @return T类型结果
	 * @throws Exception
	 *             处理http响应遇到问题
	 */
	T handle(HttpResponse response) throws Exception;

}
