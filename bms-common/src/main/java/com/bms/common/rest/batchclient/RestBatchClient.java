package com.bms.common.rest.batchclient;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Rest Template 客户端
 *
 * @author li_huiqian
 */
public class RestBatchClient extends AbstractBatchRestClient {
    private static Logger logger = LoggerFactory.getLogger(RestBatchClient.class);

    private ResponseEntity<String> responseEntity;
    private RestTemplate restTemplate;

    protected RestBatchClient(int connectTimeout, int readTimeout, int asyncConnectTimeout, int asyncReadTimeout, String apiKey, String securityKey, RestTemplate restTemplate) {
        super(connectTimeout, readTimeout, asyncConnectTimeout, asyncReadTimeout, apiKey, securityKey);
        this.restTemplate = restTemplate;
    }

    /**
     * POST请求
     * <p>
     * Demo:<br>
     * <code>
     * RestBatchClient client = RestClientFactory.newRestClient();<br>
     * UserEntity entity = client.post("http://localhost:8080/user/_find", param, UserEntity.class);<br>
     * </code>
     *
     * @param url           请求的URL
     * @param requestEntity 请求对象
     * @param typeReference 返回值类型
     * @return
     */
    public <T extends Serializable, O extends Serializable> T post(String url, O requestEntity,
                                                                   TypeReference<T> typeReference, String batchId) {
        executePost(url, requestEntity, batchId, null, null);
        return getResult(typeReference);
    }


    /**
     * POST请求
     * <p>
     * Demo:<br>
     * <code>
     * RestBatchClient client = RestClientFactory.newRestClient();<br>
     * UserEntity entity = client.post("http://localhost:8080/user/_find", param, UserEntity.class);<br>
     * </code>
     *
     * @param url           请求的URL
     * @param requestEntity 请求对象
     * @param typeReference 返回值类型
     * @param showField     显示字段
     * @return
     */
    public <T extends Serializable, O extends Serializable> T post(String url, O requestEntity,
                                                                   TypeReference<T> typeReference, String batchId, String... showField) {
        executePost(url, requestEntity, batchId, showField, null);
        return getResult(typeReference);
    }

    /**
     * POST请求
     * <p>
     * Demo:<br>
     * <code>
     * RestBatchClient client = RestClientFactory.newRestClient();<br>
     * UserEntity entity = client.post("http://localhost:8080/user/_find", param, UserEntity.class);<br>
     * </code>
     *
     * @param url           请求的URL
     * @param requestEntity 请求对象
     * @param typeReference 返回值类型
     * @param showField     显示字段
     * @param hideField     隐藏字段
     * @return
     */
    public <T extends Serializable, O extends Serializable> T post(String url, O requestEntity,
                                                                   TypeReference<T> typeReference, String batchId, String[] showField, String[] hideField) {
        executePost(url, requestEntity, batchId, showField, hideField);
        return getResult(typeReference);
    }

    /**
     * GET请求
     * <p>
     * Demo:<br>
     * <code> RestBatchClient client = RestClientFactory.newRestClient();<br>
     * HashMap<String, Object> map = new HashMap<>();<br>
     * map.put("id",100);<br>
     * UserEntity entity = client.get("http://localhost:8080/user/{id}/", map,
     * UserEntity.class)<br>
     * <code>
     *
     * @param url           请求URL
     * @param map           参数map
     * @param typeReference 返回值类型
     * @return
     */
    public <T extends Serializable> T get(String url, HashMap<String, Object> map, TypeReference<T> typeReference) {
        executeGet(url, map);
        return getResult(typeReference);
    }

    @Override
    protected void executePost(String url, Object requestEntity, String batchId, String[] showField, String... hideField) {
        logger.info("请求URL:" + url + "请求参数:" + JSONObject.toJSONString(requestEntity));
        long startTime = System.currentTimeMillis();
        responseEntity = restTemplate.postForEntity(url, createFormData(requestEntity, batchId, showField, hideField), String.class);
        long endTime = System.currentTimeMillis();
        logger.debug("请求花费时间为:" + (endTime - startTime));
    }

    @Override
    protected void executeGet(String url, HashMap<String, Object> map) {
        responseEntity = restTemplate.getForEntity(url, String.class, map);
    }

    @Override
    protected <T extends Serializable> T getResult(TypeReference<T> typeReference) {
        T result = processResponse(responseEntity, typeReference);
        logger.info("返回参数：" + JSONObject.toJSONString(result));
        return result;
    }

}
