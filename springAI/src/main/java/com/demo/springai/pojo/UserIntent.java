package com.demo.springai.pojo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserIntent {

    /**
     * 用户意图类型，例如：QUERY_ORDER, CHECK_STOCK, SEND_EMAIL, UNKNOWN
     */
    private String intentType;

    /**
     * 提取出的关键参数，例如：{"orderId": "123", "userId": "888"}
     */
    private Map<String, String> parameters;

    /**
     * 如果意图不明确，模型可以在此填入需要追问用户的问题
     */
    private String questionForUser;
}