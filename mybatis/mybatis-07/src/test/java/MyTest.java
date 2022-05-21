import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDutils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addIntBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("java so easy");
        blog.setAuthor("longge");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("python so easy");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis so easy");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务 so easy");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIf(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","python so easy");
        map.put("views","9999");
        List<Blog> blogs = mapper.queryBlogChoose(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
//        一级缓存：默认开着，第二次查询相同数据直接拿，不用再访问mysql
        List<Blog> blogs2 = mapper.queryBlogChoose(map);

        for (Blog blog : blogs2) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
