import com.easyserver.connector.EasyConnector;
import com.easyserver.core.Server;
import com.easyserver.core.WebappContext;
import com.easyserver.lifecycle.Lifecycle;
import com.easyserver.lifecycle.LifecycleImp;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class ServerConstructor extends LifecycleImp {

    Server server;

    private void start(int port,String contextPath,String webApp) {
        server =new Server();

        EasyConnector connector=new EasyConnector(port);

        WebappContext webappContext =new WebappContext(server);
        webappContext.setContextPath(contextPath);
        webappContext.setWebapp(webApp);

        server.setHandler(webappContext);//配置网页应用地址
        server.setEasyConnector(connector);//配置连接器

        server.start();
    }

    public static void main(String[] args) {

        ServerConstructor serverConstructor=new ServerConstructor();

        serverConstructor.start(8080,"/","src/main/webapp");
    }


}
