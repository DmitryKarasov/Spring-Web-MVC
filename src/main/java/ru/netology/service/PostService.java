package ru.netology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.dto.PostDTO;
import ru.netology.exception.NotFoundException;
import ru.netology.mapper.PostMapper;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;
import ru.netology.repository.RepositoryInterface;

import java.util.List;

@Service
public class PostService implements ServiceInterface<PostDTO> {
    private final RepositoryInterface<Post> repository;
    private final PostMapper mapper;

    @Autowired
    public PostService(PostRepository repository, PostMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PostDTO> all() {
        return mapper.toPostDTOList(repository.all());
    }

    public PostDTO getById(long id) {
        Post post = repository.getById(id).orElseThrow(NotFoundException::new);
        return mapper.toPostDTO(post);
    }

    public void save(PostDTO post) {
        repository.save(mapper.toPost(post));
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}

