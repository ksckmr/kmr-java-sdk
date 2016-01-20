package com.kingsoft.services.http;

import com.kingsoft.services.RequestMessage;
import com.kingsoft.services.ResponseMessage;
import com.kingsoft.services.exception.KSCClientException;
import com.kingsoft.services.exception.KSCServiceException;
import com.kingsoft.services.handlers.HttpResponseHandler;

public interface IKSCHttpClient {

	/**
	 * 执行请求：如果执行失败，则抛出异常；如果执行成功，则返回结果
	 * 
	 * @param requestMsg
	 *            请求消息
	 * @param responseHandler
	 *            响应处理handler
	 * @param errorResponseHandler
	 *            错误处理handler
	 * @return
	 * @throws KSCServiceException
	 * @throws KSCClientException
	 */
	<T> ResponseMessage<T> execute(RequestMessage<?> requestMsg,
			HttpResponseHandler<ResponseMessage<T>> responseHandler,
			HttpResponseHandler<KSCServiceException> errorResponseHandler)
			throws KSCServiceException, KSCClientException;

	/**
	 * 关闭http client对象，释放资源，关闭之后，当前http client对象不能再使用
	 */
	void shutdown();
}
