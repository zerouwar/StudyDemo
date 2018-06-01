package cn.chenhuanming.study.elasticsearch.client;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author chenhuanming
 * Created at 2018/6/1
 */
public class Main {
    public static void main(String[] args) {
        RestHighLevelClient client = ESClientFactory.getClient();


    }
}
