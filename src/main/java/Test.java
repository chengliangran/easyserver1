import com.easyserver.util.PathKit;
import com.easyserver.util.XmlKit;
import org.dom4j.Element;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class Test {
    public static void main(String[] args) {
        System.out.println(String.valueOf("c"));
        Element root= new XmlKit(PathKit.getWebRoot()+ File.separator+"src/main/webapp/WEB-INF/web.xml").getRoot();
        List<Element> eles=root.elements();
        for (Element ele : eles) {
            System.out.println(ele.getName());

        }
    }
}
