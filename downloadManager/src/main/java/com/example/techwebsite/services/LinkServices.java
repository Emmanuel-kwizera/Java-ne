package com.example.techwebsite.services;

import com.example.techwebsite.dtos.CreateLink;
import com.example.techwebsite.dtos.UpdateLink;
import com.example.techwebsite.models.Link;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface LinkServices {
    List<Link> findAll();

    Link findById(UUID id);

    Link post(CreateLink createLink);

    Link edit(UpdateLink updateLink, UUID id);

    Boolean deleteLink(UUID id);
}
