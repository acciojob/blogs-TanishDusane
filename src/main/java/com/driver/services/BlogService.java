
package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        User user = userRepository1.findById(userId).get();
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setUser(user);
        blog.setPubDate(new Date());
        blog.setContent(content);
        user.getBlogList().add(blog);
        blogRepository1.save(blog);
        userRepository1.save(user);
        return blog;
    }

    public void deleteBlog(int blogId) {
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}