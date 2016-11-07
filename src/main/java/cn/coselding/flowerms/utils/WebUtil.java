package cn.coselding.flowerms.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public class WebUtil {

    /**
     * 将request中的数据封装到javabean中
     *
     * @param request
     * @param clazz   要合成的JavaBean类
     * @return 返回合成好的JavaBean对象
     */
    public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
        try {
            // 创建Bean
            T t = clazz.newInstance();
            // 将Request中的数据填充到Bean
            Enumeration enumeration = request.getParameterNames();
            while (enumeration.hasMoreElements()) {
                String name = (String) enumeration.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(t, name, value);
            }
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将一个javabean中的数据复制到另一种类的javabean，通过属性名对应
     *
     * @param src  源Bean
     * @param dest 目标Bean
     */
    public static void copyBean(Object src, Object dest) {

        // 设置Date类型的转换器
        ConvertUtils.register(new Converter() {

            public Object convert(Class type, Object value) {
                if (value == null)
                    return null;
                String str = (String) value;
                if (str.trim().equals("") || str.trim().equals("null"))
                    return null;
                try {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    return format.parse(str);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }, Date.class);
        try {
            BeanUtils.copyProperties(dest, src);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过文件名打乱文件分布，并通过文件名合成路径，既可以打乱文件，又可以通过文件名直接找到文件所在路径
     *
     * @param filename 要合成路径的文件名
     *                 ，要确保唯一
     * @param savePath 服务器保存文件的总目录
     * @return返回合成后的文件相对savePath的相对路径
     */
    public static String encodeFilePath(String filename, String savePath) {

        // 采用哈希码打乱文件分布，分成16*16个文件夹
        int hashCode = filename.hashCode();
        // 第一级的16个文件夹中的对应目录
        int dir1 = hashCode & 0xf;
        // 第二级的16个文件夹中的对应目录
        int dir2 = (hashCode & 0xf0) >> 4;
        File file2 = new File(savePath + "/" + dir1 + "/" + dir2);
        if (!file2.exists())
            file2.mkdirs();
        // 返回最后合成的路径
        return "/"+ dir1 + "/" + dir2 + "/" + filename;
    }

    /**
     * 通过文件名和UUID结合得到唯一的文件名
     *
     * @param filename 文件名
     * @return 返回UUID结合的唯一文件名
     */
    public static String encodeFilename(String filename) {
        return getUUID() + "_" + filename.substring(filename.lastIndexOf("."));
    }

    /**
     * 获取一个UUID字符串
     *
     * @return返回的UUID字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
