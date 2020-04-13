package cn.chenhuanming.study.drools.sprinkler;

import cn.chenhuanming.study.drools.sprinkler.domain.Fire;
import cn.chenhuanming.study.drools.sprinkler.domain.Room;
import cn.chenhuanming.study.drools.sprinkler.domain.Sprinkler;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guangdao
 * Created at 2019-04-18
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //初始化
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();

        KieSession session = kc.newKieSession();

        String[] names = new String[]{"kitchen", "bedroom", "office", "livingroom"};

        Map<String, Room> name2room = new HashMap<String,Room>();
        for( String name: names ){
            Room room = new Room(name);
            name2room.put( name, room );
            session.insert( room );
            Sprinkler sprinkler = new Sprinkler(room,false);
            session.insert( sprinkler );
        }
        session.fireAllRules();

        //点火
        Thread.sleep(2000);
        Fire kitchenFire = new Fire(name2room.get("kitchen"));
        Fire officeFire = new Fire(name2room.get("office"));

        FactHandle kitchenHandle = session.insert(kitchenFire);
        FactHandle officeHandle = session.insert(officeFire);

        session.fireAllRules();

        //熄火
        Thread.sleep(2000);
        session.delete(kitchenHandle);
        session.delete(officeHandle);
        session.fireAllRules();

    }
}
