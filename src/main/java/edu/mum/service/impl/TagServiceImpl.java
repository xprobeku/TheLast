package edu.mum.service.impl;

import edu.mum.domain.Tag;

import edu.mum.repository.TagRepository;
import edu.mum.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> getAll() {
        return (List<Tag>)tagRepository.findAll();
    }
}
