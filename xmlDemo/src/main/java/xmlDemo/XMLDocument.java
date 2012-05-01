package xmlDemo;

/**
 * User: 刘永健
 * Date: 12-5-1
 * Time: 上午9:06
 * To change this template use File | Settings | File Templates.
 */

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author hongliang.dinghl
 *         定义XML文档建立与解析的接口
 */
public interface XMLDocument {

    /**
     * 建立XML文档
     *
     *
     */
    public void createXml(OutputStream os);

    /**
     * 解析XML文档
     *
     *
     */
    public void parserXml(InputStream is);


}
