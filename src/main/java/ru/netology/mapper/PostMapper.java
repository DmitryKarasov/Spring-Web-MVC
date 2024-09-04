package ru.netology.mapper;

import org.mapstruct.Mapper;
import ru.netology.dto.PostDTO;
import ru.netology.model.Post;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toPost(PostDTO postDTO);

    PostDTO toPostDTO(Post post);

    List<PostDTO> toPostDTOList(List<Post> posts);
}
