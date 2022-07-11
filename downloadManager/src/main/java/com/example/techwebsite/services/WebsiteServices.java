package com.example.techwebsite.services;

import com.example.techwebsite.dtos.CreateWebsite;
import com.example.techwebsite.dtos.UpdateWebsite;
import com.example.techwebsite.models.Website;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface WebsiteServices {

  List<Website>findAll();

  Website findById(UUID id);

  Website post(CreateWebsite createArticle);

  Website edit(UpdateWebsite updateArticle, UUID id);

  Boolean deleteWebsite(UUID id);


}
