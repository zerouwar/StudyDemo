package cn.chenhuanming.study.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guangdao
 * Created at 2019-06-27
 */
public class MapSize {
    public Map<String, PageConfig> cache = new HashMap<>();

    public static void main(String[] args) {
        MapSize mapSize = new MapSize();
        for (int i = 0; i < 10000; i++) {
            mapSize.cache.put("/orders/order/logisticsSurvey"+i,PageConfig.of(Arrays.asList(12341L,52432L),Arrays.asList(12734L,52643L),new HashMap<String, List<Long>>(){
                {
                put("btn_submit1",Arrays.asList(6231L,93245L));
                put("btn_submit2",Arrays.asList(6232L,93245L));
                put("btn_submit3",Arrays.asList(6233L,93245L));
                put("btn_submit4",Arrays.asList(6234L,93245L));
                put("btn_submit5",Arrays.asList(6236L,93245L));
            }}));
        }

        while (true) {
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(staticName = "of")
    static class PageConfig{
        private List<Long> readPermissions;
        private List<Long> writePermissions;
        private Map<String,List<Long>> componentsPermission;
    }




}
