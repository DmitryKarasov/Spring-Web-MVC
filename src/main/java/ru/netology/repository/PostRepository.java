package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PostRepository implements RepositoryInterface<Post> {

    private final Map<Long, Post> postsById = new ConcurrentHashMap<>();

    public List<Post> all() {
        List<Post> result = new ArrayList<>();
        postsById.entrySet().stream().filter(x -> !x.getValue().isRemoved()).forEach(x -> result.add(x.getValue()));
        return result;
    }

    public Optional<Post> getById(long id) {
        if (id == 0) return Optional.empty();
        return postsById.values().stream().filter(post -> post.getId() == id && !post.isRemoved()).findAny();
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            Optional<Long> optionalId = postsById.values().stream().map(p -> p.getId() + 1).max(Long::compare);
            long id = optionalId.orElse(1L);
            post.setId(id);
            System.out.println(id);
            postsById.put(id, post);
        } else {
            postsById.put(post.getId(), post);
        }
    }

    public void removeById(long id) {
        Optional<Post> optionalPost = getById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setRemoved();
        }
    }
}
