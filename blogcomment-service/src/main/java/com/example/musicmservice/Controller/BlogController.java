package com.example.musicmservice.Controller;


import com.example.musicmservice.Entities.Blog;
import com.example.musicmservice.Entities.Comment;
import com.example.musicmservice.Service.IBlogService;
import com.example.musicmservice.Service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BlogController {
    private final IBlogService iBlogService;
    private final ICommentService iCommentService;

    @GetMapping("/all")
    @ResponseBody
    public List<Blog> getBlogs(){
        return iBlogService.display();
    }
    @PostMapping("/add")
    public Blog addBlog(@RequestBody Blog blog){
        return iBlogService.addBlog(blog);
    }
    @PutMapping ("/update")
    public Blog updateBlog(@RequestBody Blog blog){
        return iBlogService.editBlog(blog);
    }
    @GetMapping("/get/{id-blog}")
public Blog findbyid(@PathVariable("id-blog") Integer id ){
        return iBlogService.findbyid(id);
    }
    @DeleteMapping("/remove/{id-blog}")
    public void deleteblog(@PathVariable("id-blog") Integer id ){
       iBlogService.removeBlog(id);
    }


    /* commenttttttttttttttttttt*/
    @GetMapping("/allcomment")
    @ResponseBody
    public List<Comment> getcomment(){
        return iCommentService.display();
    }
    @PostMapping("/addcomment")
    public Comment addComment(@RequestBody Comment comment){
        return iCommentService.addComment(comment);
    }
    @PutMapping ("/updatecomment")
    public Comment updateComment(@RequestBody Comment comment){
        return iCommentService.editComment(comment);
    }
    @GetMapping("/getcomment/{id-comment}")
    public Comment findbyidcomment(@PathVariable("id-comment") Integer id ){
        return iCommentService.findbyid(id);
    }
    @DeleteMapping("/removecomment/{id-comment}")
    public void deleteComment(@PathVariable("id-comment") Integer id ){
        iCommentService.removeComment(id);
    }

    @PostMapping("/{blogId}/comment")
    public Comment addCommentToBlog(@PathVariable Integer blogId, @RequestBody Comment comment) {
        return iCommentService.addCommentToBlog(blogId, comment);
    }
    @GetMapping("/{blogId}/comments")
    public List<Comment> getCommentsForBlog(@PathVariable Integer blogId) {
        return iCommentService.getCommentsForBlog(blogId);
    }
    @DeleteMapping("/{blogId}/comment/{commentId}")
    public void removeCommentFromBlog(@PathVariable Integer blogId, @PathVariable Integer commentId) {
        iCommentService.removeCommentFromBlog(blogId, commentId);
    }
}
