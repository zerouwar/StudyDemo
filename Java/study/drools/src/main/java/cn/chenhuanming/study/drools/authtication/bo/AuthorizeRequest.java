package cn.chenhuanming.study.drools.authtication.bo;

import lombok.Data;

import java.util.List;

/**
 * @author guangdao
 * Created at 2019-07-05
 */
@Data
public class AuthorizeRequest {
    private String uri;
    private List<String> needPermissions;
    private boolean authorzied;
}
