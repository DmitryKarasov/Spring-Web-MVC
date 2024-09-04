package ru.netology.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.netology.dto.PostDTO;
import ru.netology.model.Post;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-04T11:07:41+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post toPost(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        long id = 0L;
        String content = null;

        id = postDTO.getId();
        content = postDTO.getContent();

        Post post = new Post( id, content );

        return post;
    }

    @Override
    public PostDTO toPostDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        long id = 0L;
        String content = null;

        id = post.getId();
        content = post.getContent();

        PostDTO postDTO = new PostDTO( id, content );

        return postDTO;
    }

    @Override
    public List<PostDTO> toPostDTOList(List<Post> posts) {
        if ( posts == null ) {
            return null;
        }

        List<PostDTO> list = new ArrayList<PostDTO>( posts.size() );
        for ( Post post : posts ) {
            list.add( toPostDTO( post ) );
        }

        return list;
    }
}
